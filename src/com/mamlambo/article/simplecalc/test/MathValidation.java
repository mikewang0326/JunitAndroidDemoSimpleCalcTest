package com.mamlambo.article.simplecalc.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.mamlambo.article.simplecalc.MainActivity;
import com.mamlambo.article.simplecalc.R;

public class MathValidation extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private static final String NUMBER_24 = "2 4 ENTER";
	private static final String NUMBER_74 = "7 4 ENTER";
	private static final String ADD_RESULT = "98";
	
	private static final String NUMBER_5_DOT_5 = "5 PERIOD 5 ENTER";
	private static final String ADD_DECIMAL_RESULT = "79.5";
	
	private static final String MULTIPLY_RESULT = "1776";
	
	private TextView result;

	/*
	 * do not add the parameters name, if not, will cause exception:
	 * 
	 * error key message: "testSuiteConstructionFailed name == null"
	 * 
	 * more details:http://stackoverflow.com/questions/18102887/runtimeexception-while-using-activityunittestcase-but-not-while-activityinstrum
	 * 
	 */
	
//	public MathValidation(String name) { 
//		super("com.mamlambo.article.simplecalc", MainActivity.class);
//	}
	
	public MathValidation() { 
		super("com.mamlambo.article.simplecalc", MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		MainActivity activity = getActivity();
		result = (TextView) activity.findViewById(R.id.result);
	}
	
	public void testAddValue() {
		sendKeys(NUMBER_24);
		//now on value2 entry
		sendKeys(NUMBER_74);
		// now on Add button
		sendKeys("ENTER");
		// get result
		String mathResult = result.getText().toString();
	    assertTrue("Add result should be 98", mathResult.equals(ADD_RESULT));
	}

	public void testAddDecimalValues() {
		sendKeys(NUMBER_5_DOT_5 + NUMBER_74 + "ENTER");
		String mathResult = result.getText().toString();
		assertTrue("Add result should be " + ADD_DECIMAL_RESULT + " but was " + mathResult, mathResult.equals(ADD_DECIMAL_RESULT));
	}
	
	public void testMultiplyValues() {
		sendKeys(NUMBER_24+NUMBER_74+ " DPAD_RIGHT ENTER");
	    String mathResult = result.getText().toString();
		assertTrue("Multiply result should be " + MULTIPLY_RESULT + " but was "
		+ mathResult, mathResult.equals(MULTIPLY_RESULT));
	}
	
	
	
}
