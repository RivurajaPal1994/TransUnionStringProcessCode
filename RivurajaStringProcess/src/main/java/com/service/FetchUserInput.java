package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import com.exception.CustomException;

public class FetchUserInput {
	private BufferedReader reader;

	/**
	 * Asks the user for input1 and read from console
	 * @return String
	 * @throws CustomException
	 */
	public String getInputString() throws CustomException {
		System.out.print("input1: ");
		String data;

		try {
			data = getData();
			return data;
		} catch (IOException e) {

			throw new CustomException("Unable to input user data. Kindly provide proper data or restart program");
		}

	}

	/**
	 * Asks the user for Input2 and read from console
	 * @return
	 * @throws CustomException
	 */
	public String getCharacter() throws CustomException {

		String characterInput;
		try {
			System.out.print("input2: ");
			characterInput = getData();
			return characterInput;
		} catch (IOException e) {
			throw new CustomException("Unable to input character. Kindly provide proper data or restart program");
		}

	}

	private String getData() throws IOException {
		if (Objects.isNull(reader))
			reader = new BufferedReader(new InputStreamReader(System.in));

		return reader.readLine();

	}

}
