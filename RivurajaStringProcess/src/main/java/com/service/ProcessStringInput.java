package com.service;

import com.exception.CustomException;

public class ProcessStringInput {
	private FetchUserInput queryUser;
	private String inputStringValue;
	private String checkCharacter;

	/**
	 * Process String to provide the maximum distance between two characters in a
	 * String
	 */
	public void processString() {
		queryUser = new FetchUserInput();
		try {
			inputStringValue = queryUser.getInputString();
			checkCharacter = queryUser.getCharacter();
		} catch (CustomException e) {
			System.err.println(e);
			System.err.println("Program Terminated...");
			return;
		}
		int distance = calculateMaximumCharacterDistance(inputStringValue, checkCharacter);
		System.out.println("Output: " + distance);
	}

	/**
	 * Business logic for calculation of max distance between two occurrences of
	 * characters
	 * 
	 * @param input1
	 * @param input2
	 * @return -1 for invalid and distance in integer
	 */
	public int calculateMaximumCharacterDistance(String inputStringValue, String checkCharacter) {

		// validation of input data and characters
		if (validateInputData(inputStringValue) == 0) {
			System.err.println("Input String cannot be empty");
			return -1;
		}
		if (validateInputData(inputStringValue) == 1) {
			System.err.println("Input String is less than 3 characters, no distance to calculate");
			return -1;
		}

		if (validateCharacter(checkCharacter) == 0) {
			System.err.println("Input character cannot be empty");
			return -1;
		}
		if (validateCharacter(checkCharacter) == 1) {
			System.err.println("Input character is more than 1 character, invalid input");
			return -1;
		}

		// Split token to get the tokens by eliminating whitespace
		inputStringValue = inputStringValue.toLowerCase();
		StringBuffer buffer = new StringBuffer();
		StringBuffer outputbuffer = new StringBuffer();
		String[] tokens = inputStringValue.split(" ");
		for (String value : tokens)
			buffer.append(value);

		// split token based on character to get all the values other than characters
		String temp = buffer.toString();
		String[] output = temp.split(checkCharacter);

		if (output.length < 1)
			return -1;

		if (output.length == 2) {
			return output[1].length();
		}

		if (temp.lastIndexOf(checkCharacter) == temp.length() - 1) {
			for (int i = 1; i < output.length; i++) {
				outputbuffer.append(output[i]);
			}
		}
		else
		{
			for (int i = 1; i < output.length-1; i++) {
				outputbuffer.append(output[i]);
			}			
		}

		// calculate the characters after first occurrence and before last occurrence
		
		if (outputbuffer.length() > 0)
			return outputbuffer.length();
		else
			return -1;
	}

	public int validateInputData(String inputStringValue) {

		if (inputStringValue == null || inputStringValue.isEmpty())
			return 0;
		else if (inputStringValue.trim().length() < 3)
			return 1;
		else
			return 2;
	}

	public int validateCharacter(String checkCharacter) {

		if (checkCharacter == null || checkCharacter.isEmpty())
			return 0;
		else if (checkCharacter.trim().length() > 1)
			return 1;
		else
			return 2;
	}

}
