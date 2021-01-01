package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class FetchUserInput {
	private static BufferedReader reader;

	public static String getData() throws IOException {
		if (Objects.isNull(reader))
			reader = new BufferedReader(new InputStreamReader(System.in));

		return reader.readLine();

	}

}
