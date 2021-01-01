package com.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

import com.exception.CustomException;

public class ProcessJackSparrowJump {
	private String input1;
	private String input2;
	private String input3;
	private String input4;
	private int output;

	public void execute() {
		// read data from user
		try {
			System.out.print("input1: ");
			input1 = FetchUserInput.getData();

			System.out.print("input2: ");
			input2 = FetchUserInput.getData();

			System.out.print("input3: ");
			input3 = FetchUserInput.getData();

			System.out.print("input4: ");
			input4 = FetchUserInput.getData();

		} catch (IOException e) {
			System.err.println("Unable to read user data input");
		}

		output = processJumpCount(input1, input2, input3, input4);
		System.out.println("Output: "+output);
	}

	public int processJumpCount(String input1, String input2, String input3, String input4) {

		int climbUp;
		int climbDown;
		int noOfWalls;
		int[] wallHeights;
		// validate input from user
		try {
			climbUp = validateReturnIntegerInput(input1);
			climbDown = validateReturnIntegerInput(input2);
			noOfWalls = validateReturnIntegerInput(input3);
			wallHeights = validateReturnWallData(noOfWalls, input4);
		} catch (CustomException e) {
			System.out.println("Invalid! --> " + e.getMessage());
			return -1;
		}
		
		Arrays.sort(wallHeights);
		int maxWallHeight = wallHeights[wallHeights.length-1];
		
		
		// business Logic calculation
		if (climbUp<maxWallHeight && climbDown >= climbUp)
			return -1;

		
		int jumpCount = 0;
		for(int wall:wallHeights)
		{
			int temp=0;
			do {
				//jump
				jumpCount++;
				temp += climbUp;
				
				//wall greater than climb? slide down
				if(temp<wall)
					temp -= climbDown;
				
			}while(temp<wall);
		}
		
		
		return jumpCount;

	}

	private int[] validateReturnWallData(int noOfWalls, String input) throws CustomException {
		int[] heights = new int[noOfWalls];
		if (input == null || noOfWalls < 0)
			throw new CustomException("Null value passed in Wall array");
		try {
			if (Pattern.compile("^[{]{1}[1-9]\\d*(,[1-9]\\d*)*[}]{1}$").matcher(input).matches()) {
				String[] tokens = input.substring(1, input.length() - 1).split(",");
				if (tokens.length != noOfWalls)
					throw new CustomException("Input3 is " + noOfWalls + " but Input4 has " + tokens.length
							+ " elements. Provide valid data");

				for (int i = 0; i < noOfWalls; i++) {
					heights[i] = Integer.parseInt(tokens[i]);
				}
				return heights;
			} else
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			throw new CustomException("Invalid data provided as input4 (zero and negatives not allowed) " + input);
		}

	}

	private int validateReturnIntegerInput(String input) throws CustomException {
		if (input == null)
			throw new CustomException("Null Value passed as Input. Please pass proper data");
		try {
			if (Pattern.compile("^[1-9]\\d*$").matcher(input).matches())
				return Integer.parseInt(input);
			else
				throw new NumberFormatException();

		} catch (NumberFormatException e) {
			throw new CustomException("Invalid value sent (zero and negatives not valid) " + input);
		}

	}

}
