package com.plivo.Utils;

import org.testng.Reporter;

import java.text.SimpleDateFormat;

public class LoggerUtils {
	
	
	/**
	 *			LoggerUtils will allow user to report various logs with
	 *         level like info, debug, warning and error. this also does log in
	 *         console and also puts that in testNG reporter output.
	 */
	

	    private LoggerUtils() {

	    }

	    /**
	     * Log Info, this is the highest level of logging. Should be used for
	     * logging test intent, and actions.
	     */
	    public static void info(String text) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
		String timestamp = sdf.format(date);
		text = String.format("INFO: [%s] %s", timestamp, text);
		System.out.println("----> " + text);
		Reporter.log(String.format("<div style=\"color:green\">%s</div>", text), false);
	    }

	    /**
	     * Log Debug, this is designed for debug information, used to determine why
	     * a test is failing.
	     */
	    public static void debug(String text) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
		String timestamp = sdf.format(date);
		text = String.format("DEBUG: [%s] %s", timestamp, text);
		System.out.println("----> " + text);
		Reporter.log(String.format("<div>%s</div>", text), false);
	    }

	    /**
	     * Log A Warning. Use this when something went wrong, but may not be
	     * critical for test success. Will show up yellow in the report.
	     */
	    public static void warning(String text) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
		String timestamp = sdf.format(date);
		text = String.format("WARNING: [%s] %s", timestamp, text);
		System.out.println("----> " + text);
		Reporter.log(String.format("<div style=\"background-color:yellow\">%s</div>", text), false);
	    }

	    public static void error(String text) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
		String timestamp = sdf.format(date);
		text = String.format("ERROR: [%s] %s", timestamp, text);
		System.out.println("!---- " + text);
		Reporter.log(String.format("<div style=\"background-color:red; color:white\">%s</div>", text), false);
	    }

}
