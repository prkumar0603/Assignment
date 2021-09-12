package com.example.demo.Util;

import java.util.Calendar;

public class UserValidator {

	public static boolean checkDOB(String dob) {

		String[] arr = dob.split("-");
		int dobYear = Integer.parseInt(arr[0]);

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		// change this value to limit age
		if (currentYear - dobYear >= 2)
			return true;

		return false;
	}

	public static boolean checkMobile(String mobile) {

		if (mobile.length() == 10)
			return true;

		return false;
	}

	public static boolean checkName(String str) {

		return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z ]*$")));

	}

	public static boolean checkPassword(String pass, String confpass) {

		if (pass.equals(confpass))
			return true;

		return false;
	}
}
