package com.gp.bhi.tools;

import android.R.integer;
import android.R.string;

import com.gp.bhi.im.im_operate_enToKo;
import com.gp.bhi.ui.Ui_main.Language;

public class tools_checkInputContent {
	/*
	 * 这里面要检查输入的内容 英语部分： 是否有"^"来判断大小写 ASCII:94
	 */

	public static String check(Language lang, String _checkedStr,
			String _unCheckedStr) {
		String testStr = _checkedStr+_unCheckedStr;

		switch (lang) {

		/* 英语部分的检查 */
		case en: {
			// 判断是否进行过操作 如果进行过操作 则截取
			boolean _operated = false;
			// 用来接受的数组
			char[] testCharArr = (_checkedStr + _unCheckedStr).toCharArray();

			// 遍历数组来找'^'
			for (int i = 0; i < testCharArr.length; i++) {
				
				// 找到"^" 并且不是最后一位的情况
				if (testCharArr[i] == 94 && i + 1 < testCharArr.length) {
					System.out.println("英语检查 转换前：" + testCharArr.length);
					for (int j = 0; j < testCharArr.length; j++) {
						System.out.println(testCharArr[j]);
					}
					// 大小写转换
					testCharArr[i] = (char) (testCharArr[i + 1] - 32);
					switch (testCharArr[i + 1]) {
					
					case 'a':
						System.out.println("下一位是a  "+testStr);
						testStr=testStr.replace("^a", "A");
						System.out.println("替换结束后："+testStr);
						break;
					case 'b':
						System.out.println("下一位是b  "+testStr);
						testStr=testStr.replace("^b", "B");
						System.out.println("替换结束后："+testStr);
						break;
					case 'c':
						System.out.println("下一位是c  "+testStr);
						testStr=testStr.replace("^c", "C");
						System.out.println("替换结束后："+testStr);
						break;
					case 'd':
						System.out.println("下一位是d  "+testStr);
						testStr=testStr.replace("^d", "D");
						System.out.println("替换结束后："+testStr);
						break;
					case 'e':
						System.out.println("下一位是e  "+testStr);
						testStr=testStr.replace("^e", "E");
						System.out.println("替换结束后："+testStr);
						break;
					case 'f':
						System.out.println("下一位是f  "+testStr);
						testStr=testStr.replace("^f", "F");
						System.out.println("替换结束后："+testStr);
						break;
					case 'g':
						System.out.println("下一位是g  "+testStr);
						testStr=testStr.replace("^g", "G");
						System.out.println("替换结束后："+testStr);
						break;
					case 'h':
						System.out.println("下一位是h  "+testStr);
						testStr=testStr.replace("^h", "H");
						System.out.println("替换结束后："+testStr);
						break;
					case 'i':
						System.out.println("下一位是i  "+testStr);
						testStr=testStr.replace("^i", "I");
						System.out.println("替换结束后："+testStr);
						break;
					case 'j':
						System.out.println("下一位是j  "+testStr);
						testStr=testStr.replace("^j", "J");
						System.out.println("替换结束后："+testStr);
						break;
					case 'k':
						System.out.println("下一位是k  "+testStr);
						testStr=testStr.replace("^k", "K");
						System.out.println("替换结束后："+testStr);
						break;
					case 'l':
						System.out.println("下一位是l  "+testStr);
						testStr=testStr.replace("^l", "L");
						System.out.println("替换结束后："+testStr);
						break;
					case 'm':
						System.out.println("下一位是m  "+testStr);
						testStr=testStr.replace("^m", "M");
						System.out.println("替换结束后："+testStr);
						break;
					case 'n':
						System.out.println("下一位是n  "+testStr);
						testStr=testStr.replace("^n", "N");
						System.out.println("替换结束后："+testStr);
						break;
					case 'o':
						System.out.println("下一位是o  "+testStr);
						testStr=testStr.replace("^o", "O");
						System.out.println("替换结束后："+testStr);
						break;
					case 'p':
						System.out.println("下一位是p  "+testStr);
						testStr=testStr.replace("^p", "P");
						System.out.println("替换结束后："+testStr);
						break;
					case 'q':
						System.out.println("下一位是q  "+testStr);
						testStr=testStr.replace("^q", "Q");
						System.out.println("替换结束后："+testStr);
						break;
					case 'r':
						System.out.println("下一位是r  "+testStr);
						testStr=testStr.replace("^r", "R");
						System.out.println("替换结束后："+testStr);
						break;
					case 's':
						System.out.println("下一位是s  "+testStr);
						testStr=testStr.replace("^s", "S");
						System.out.println("替换结束后："+testStr);
						break;
					case 't':
						System.out.println("下一位是t  "+testStr);
						testStr=testStr.replace("^t", "T");
						System.out.println("替换结束后："+testStr);
						break;
					case 'u':
						System.out.println("下一位是u  "+testStr);
						testStr=testStr.replace("^u", "U");
						System.out.println("替换结束后："+testStr);
						break;
					case 'v':
						System.out.println("下一位是v  "+testStr);
						testStr=testStr.replace("^v", "V");
						System.out.println("替换结束后："+testStr);
						break;
					case 'w':
						System.out.println("下一位是w  "+testStr);
						testStr=testStr.replace("^w", "W");
						System.out.println("替换结束后："+testStr);
						break;
					case 'x':
						System.out.println("下一位是x  "+testStr);
						testStr=testStr.replace("^x", "X");
						System.out.println("替换结束后："+testStr);
						break;
					case 'y':
						System.out.println("下一位是y  "+testStr);
						testStr=testStr.replace("^y", "Y");
						System.out.println("替换结束后："+testStr);
						break;
					case 'z':
						System.out.println("下一位是z  "+testStr);
						testStr=testStr.replace("^z", "Z");
						System.out.println("替换结束后："+testStr);
						break;
					case '^':
						System.out.println("下一位是^  "+testStr);
						testStr=testStr.replace("^^", "^");
						System.out.println("替换结束后："+testStr);
						break;

					default:
						break;
					}
					

					
					_operated = true;
					System.out.println("英语检查 转换后：" + testCharArr.length);
					for (int j = 0; j < testCharArr.length; j++) {
						System.out.println(testCharArr[j]);
					}

				}

			}
		
			// 如果进行过操作 则去掉最后一位
			if (_operated) {
//				String _str = String.valueOf(testCharArr);
//				System.out.println("操作以后字符串内容是：" + _str + ", 长度"
//						+ _str.length() + " 输出内容是："
//						+ _str.substring(0, _str.length() - 1));
//				return _str.substring(0, _str.length() - 1);
				return testStr;
			} else {
				return String.valueOf(testCharArr);
			}
		}

		/* 韩语部分的检查 */
		case ko: {
			/*
			 * 这里要组合韩文。 先把韩文翻译成英文 然后英文筛选， 不 能组合的部分用韩文的字符输出， 每次输入都要进行一次检查
			 */

			String _strShower = im_operate_enToKo.enToKo(_unCheckedStr,
					_checkedStr);
			System.out.println("tools_checkInputContent 这里经过处理的韩文是："
					+ _strShower);
			// return _checkedStr + _unCheckedStr;
			if (!_strShower.equalsIgnoreCase("error:101")) {
				System.out.println("输出成功");
				return _strShower;
			} else {
				System.out.println("输出失败啦");
				return "error:101";
			}
		}

		default:
			return null;
		}

	}
}
