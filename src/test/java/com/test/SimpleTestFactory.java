package com.test;

import org.testng.annotations.Factory;

public class SimpleTestFactory {
	
	@Factory
    public Object[] factoryMethod() {
        return new Object[] { new DriverTest(), new TestClass() };
    }

}
