package com.testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.test.NumbertoWordConversionApp;

public class NumbertoWordConversionTest {

	NumbertoWordConversionApp app = null;
	
	
	@Before
	public void setUp() throws Exception {
		app = new NumbertoWordConversionApp();
	}

	@Test
	public void testSuccess() {
		assertEquals("one hundred", app.convertNumbertoWord(100));
	}
	
	@Test
	public void testFail() {
		assertNotEquals("one hundred four", app.convertNumbertoWord(100));
	}

}
