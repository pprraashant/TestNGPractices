package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test0001 {

	@Test(retryAnalyzer = com.test.RetryAnalyzer.class)
	public void Test1()
	{
		Assert.assertEquals(false, true);
	}

	@Test
	public void Test2()
	{
		Assert.assertEquals(false, true);
	}
}