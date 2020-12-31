package com.service;

import org.junit.Assert;
import org.junit.Test;

public class ProcessStringInputTest {
	

	@Test
	public void checkNullInput1()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(-1, service.calculateMaximumCharacterDistance(null, null));
	}
	
	@Test
	public void checkNullInput2()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(-1, service.calculateMaximumCharacterDistance(null, null));
	}
	
	@Test
	public void checkEmptyInput1()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(-1, service.calculateMaximumCharacterDistance("", "a"));
	}
	
	@Test
	public void checkEmptyInput2()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(-1, service.calculateMaximumCharacterDistance("abcd", ""));
	}
	
	/**
	 * Input1 is valid and Input2 is valid and present with 1 occurrence
	 */
	@Test
	public void checkValidValid1Occ()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(-1, service.calculateMaximumCharacterDistance("My name is Rivuraja Pal", "n"));
	}
	
	
	
	/**
	 * Input1 is valid and Input2 is valid and present with 2 occurrences
	 */
	@Test
	public void checkValidValid2Occ()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(3, service.calculateMaximumCharacterDistance("My name is Rivuraja Pal", "m"));
	}
	/**
	 * Input1 is valid and Input2 is valid and present with more than 2 occurrences
	 */
	@Test
	public void checkValidValidMoreThan2Occ()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(11, service.calculateMaximumCharacterDistance("My name is Rivuraja Pal", "a"));
	}
	
	/**
	 * Input1 is valid and Input2 is valid and not present with 0 occurrences
	 */
	@Test
	public void checkValidValidNoOcc()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(-1, service.calculateMaximumCharacterDistance("My name is Rivuraja Pal", "c"));
	}
	
	/**
	 * Input1 is valid and Input2 is valid and special characters
	 */
	@Test
	public void checkValidValidSpecChars()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(14, service.calculateMaximumCharacterDistance("My_name is Rivuraja_Pal", "_"));
	}

	/**
	 * Input1 is valid and Input2 is valid and numbers
	 */
	@Test
	public void checkValidValidNumbers()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(20, service.calculateMaximumCharacterDistance("My 5name is Rivuraja5 Pal and 5 is my number", "5"));
	}
	
	/**
	 * Input1 is valid and Input2 is spaces
	 */
	@Test
	public void checkSpaces()
	{
		ProcessStringInput service = new ProcessStringInput();
		Assert.assertEquals(-1, service.calculateMaximumCharacterDistance("My name is Rivuraja Pal and is my number", " "));
	}

}