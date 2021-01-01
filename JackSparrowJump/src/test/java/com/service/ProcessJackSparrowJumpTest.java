package com.service;

import org.junit.Assert;
import org.junit.Test;

public class ProcessJackSparrowJumpTest {
	/**
	 * Negative Test Cases
	 */
	@Test
	public void checkNullInput1() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = null;
		String input2 = "1";
		String input3 = "1";
		String input4 = "{5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkNullInput2() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = null;
		String input3 = "1";
		String input4 = "{5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkNullInput3() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "1";
		String input3 = null;
		String input4 = "{5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkNullInput4() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "1";
		String input3 = "1";
		String input4 = null;
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkZeroInput1() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "0";
		String input2 = "1";
		String input3 = "1";
		String input4 = "{5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkZeroInput2() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "0";
		String input3 = "1";
		String input4 = "{5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkZeroInput3() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "1";
		String input3 = "0";
		String input4 = "{5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkZeroInput4() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "1";
		String input3 = "2";
		String input4 = "{0,2}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkNegativeIntegerInput1() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "-5";
		String input2 = "1";
		String input3 = "1";
		String input4 = "{5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkNegativeIntegerInput2() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "-1";
		String input3 = "1";
		String input4 = "{5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkNegativeIntegerInput3() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "1";
		String input3 = "-1";
		String input4 = "{5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	@Test
	public void checkNegativeIntegerInput4() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "1";
		String input3 = "1";
		String input4 = "{-5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}
	
	@Test
	public void checkSpecialCharacter() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "$";
		String input2 = "1";
		String input3 = "1";
		String input4 = "{-5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}
	
	@Test
	public void checkAlphanumeric() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "4";
		String input2 = "a";
		String input3 = "1";
		String input4 = "{-5}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	/**
	 * To validate that No of Walls value cannot be less than the size of list of
	 * wall heights
	 */

	@Test
	public void checkInput3LessThanInput4() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "1";
		String input3 = "1";
		String input4 = "{5,6}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	/**
	 * To validate that No of Walls value cannot be more than the size of list of
	 * wall heights
	 */
	@Test
	public void checkInput3MoreThanInput4() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "1";
		String input3 = "5";
		String input4 = "{5,6}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	/**
	 * To validate that climbDown cannot be more than climbUp when max wall size is
	 * more than climbUp
	 */

	@Test
	public void checkInput2MoreThanInput1WhenMaxWallLengthGreater() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "10";
		String input3 = "2";
		String input4 = "{5,6}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}

	/**
	 * To validate that climbDown cannot be equal to climbUp when max wall size is
	 * more than climbUp
	 */

	@Test
	public void checkInput2EqualToInput1WhenMaxWallLengthGreater() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "5";
		String input3 = "2";
		String input4 = "{5,6}";
		Assert.assertEquals(-1, object.processJumpCount(input1, input2, input3, input4));
	}
	
	/**
	 * To validate that climbDown can be more than climbUp when max wall size is
	 * lesser than climbUp
	 */

	@Test
	public void checkInput2MoreThanInput1WhenMaxWallLengthLesser() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "10";
		String input3 = "2";
		String input4 = "{1,4}";
		Assert.assertEquals(2, object.processJumpCount(input1, input2, input3, input4));
	}
	
	/**
	 * To validate that climbDown can be equal to climbUp when max wall size is
	 * lesser than climbUp
	 */

	@Test
	public void checkInput2EqualInput1WhenMaxWallLengthLesser() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "5";
		String input3 = "2";
		String input4 = "{1,4}";
		Assert.assertEquals(2, object.processJumpCount(input1, input2, input3, input4));
	}
	
	/**
	 * To validate that climbDown can be equal to climbUp when max wall size is
	 * equal to climbUp
	 */

	@Test
	public void checkInput2EqualInput1WhenMaxWallLengthEqual() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "5";
		String input3 = "2";
		String input4 = "{5,5}";
		Assert.assertEquals(2, object.processJumpCount(input1, input2, input3, input4));
	}

	/**
	 * Ideal scenario for Jack Sparrow
	 */
	@Test
	public void checkIdealData() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "1";
		String input3 = "2";
		String input4 = "{5,6}";
		Assert.assertEquals(3, object.processJumpCount(input1, input2, input3, input4));
	}

	/**
	 * Sample Case 1 as per request
	 */
	@Test
	public void checkSampleData1() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "10";
		String input2 = "1";
		String input3 = "1";
		String input4 = "{10}";
		Assert.assertEquals(1, object.processJumpCount(input1, input2, input3, input4));
	}

	/**
	 * Sample Case 2 as per request
	 */
	
	@Test
	public void checkSampleData2() {
		ProcessJackSparrowJump object = new ProcessJackSparrowJump();
		String input1 = "5";
		String input2 = "1";
		String input3 = "2";
		String input4 = "{9,10}";
		Assert.assertEquals(5, object.processJumpCount(input1, input2, input3, input4));
	}

}
