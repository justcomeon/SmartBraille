package com.gp.bhi.tools;

public class tools_brailleCodeOperation {
	public static String boolToString(boolean[] _arr) {
		String _strCodeRes = "";
		for (int i = 0; i < _arr.length; i++) {
			if (_arr[i])
				_strCodeRes = "1" + _strCodeRes;
			else {
				_strCodeRes = "0" + _strCodeRes;
			}
		}
		System.out.println("tools_brailleCodeOperation,返回值：" + _strCodeRes);
		return _strCodeRes;
	}

	public static Boolean[] stringToBool(String _str) {
		return null;
	}

}
