package com.gp.bhi.im;

import java.util.HashMap;

import com.gp.bhi.ui.Ui_main;

public class im_operate_enToKo {
	HashMap<String, String> koToEn_map = new HashMap<String, String>();

	// 初声 中声 尾声
	enum CodeType {
		chosung, jungsung, jongsung
	}

	public im_operate_enToKo() {
		// 这里是把韩文翻译成英语

		koToEn_map.put("ㄱ", "r");
		koToEn_map.put("ㄴ", "k");
		koToEn_map.put("ㄷ", "e");
		koToEn_map.put("ㄹ", "f");
		koToEn_map.put("ㅁ", "a");
		koToEn_map.put("ㅂ", "q");
		koToEn_map.put("ㅅ", "t");
		koToEn_map.put("ㅈ", "w");
		koToEn_map.put("ㅊ", "c");
		koToEn_map.put("ㅋ", "z");
		koToEn_map.put("ㅌ", "x");
		koToEn_map.put("ㅍ", "v");
		koToEn_map.put("ㅎ", "g");
		koToEn_map.put("ㄱ", "r");
		koToEn_map.put("ㄴ", "s");
		koToEn_map.put("ㄷ", "e");
		koToEn_map.put("ㄹ", "f");
		koToEn_map.put("ㅁ", "a");
		koToEn_map.put("ㅂ", "q");
		koToEn_map.put("ㅅ", "t");
		koToEn_map.put("ㅇ", "d");
		koToEn_map.put("ㅈ", "w");
		koToEn_map.put("ㅊ", "c");
		koToEn_map.put("ㅋ", "z");
		koToEn_map.put("ㅌ", "x");
		koToEn_map.put("ㅍ", "v");
		koToEn_map.put("ㅎ", "g");
	}

	private String preOpe(char[] _charArr) {
		String res = "";
		for (int i = 0; i < _charArr.length; i++) {
			res = res + koToEn_map.get(String.valueOf(_charArr[i]));
			System.out.println("im_operate_enToKo:" + res);
		}
		return res;
	}

	/*
	 * 这里处理双写问题： 遍历字符串如果t后面接的是r,e,q,t,w的话 把后面的q w e r t 变成QWERT
	 */
	private String checkUpperCase(String uncheckStr) {

		String checkedStr = uncheckStr;
		char[] finishedStr = checkedStr.toCharArray();
		int t_position = 870725;
		while (true) {
			finishedStr = checkedStr.toCharArray();
			t_position = 870725;
			if (checkedStr.indexOf("t") != -1) {
				t_position = checkedStr.indexOf("t");
				System.out.println("t_position的位置是：" + t_position);
				System.out.print(checkedStr);
			} else {
				break;
			}
			/*
			 * 3曰24日 做到这里。 接下来的工作要解决双写的问题ㅆㅃㅉㄸㄲ
			 */
			if (t_position < checkedStr.length() - 1) {
				/*
				 * 这里处理双写符号问题
				 */
				System.out.println("现在t的位置是：" + t_position);
				System.out.println("现在的checkedStr:" + checkedStr);
				// 两个t的情况
				if (finishedStr[t_position + 1] == 't') {
					System.out.println("找到了是两个t，替换前:" + checkedStr);
					checkedStr = checkedStr.replace("tt", "T");
					System.out.println("替换成功" + checkedStr);
				}
				// 一个t 一个q的情况：ㅃ
				else if (finishedStr[t_position + 1] == 'q') {
					System.out.println("找到了一个t 一个q，替换前:" + checkedStr);
					checkedStr = checkedStr.replace("tq", "Q");
				}
				// 一个t 一个w的情况：ㅉ
				else if (finishedStr[t_position + 1] == 'w') {
					System.out.println("找到了一个t 一个w，替换前:" + checkedStr);
					checkedStr = checkedStr.replace("tw", "W");
				}
				// 一个t 一个e的情况：ㄸ
				else if (finishedStr[t_position + 1] == 'e') {
					System.out.println("找到了一个t 一个e，替换前:" + checkedStr);
					checkedStr = checkedStr.replace("te", "E");
				}
				// 一个t 一个r的情况：ㄲ
				else if (finishedStr[t_position + 1] == 'r') {
					System.out.println("找到了一个t一个r，替换前:" + checkedStr);
					checkedStr = checkedStr.replace("tr", "R");
				} else {
					System.out.println("没有找到双写问题");
					break;
				}
			} else {
				break;
			}

		}
		System.out.println("checkedStr:" + checkedStr);
		return checkedStr;
	}

	public static String enToKo(String str_en, String inputedContent) {

		System.out.println("im_operate_enToKo: 即将要处理的前后两个字符串是：inputedContent:"
				+ inputedContent + " str_en:" + str_en);
		// 数据接受正确
		im_operate_enToKo _operater = new im_operate_enToKo();
		// 开始处理
		String inputedContentEn = _operater
				.preOpe(inputedContent.toCharArray());
		System.out.println("im_operate_enToKo: inputedContent["
				+ inputedContent + "] str_en[" + str_en + "] "
				+ "inputedContentEn:[" + inputedContentEn + "]");
		System.out
				.println("inputedContent+str_en:" + (inputedContent + str_en));
		// 这里处理双写问题： 遍历字符串如果t后面接的是r,e,q,t,w的话 把后面的q w e r t 变成QWERT

		String str_ko = _operater.engToKor(_operater
				.checkUpperCase(inputedContent + str_en));
		System.out.println("im_operate_enToKo 这里是翻译过程的内部，翻译出的韩语是：" + str_ko);
		return str_ko;

	}

	/**
	 * 从英语翻译到韩语的过程 从字符串里找初声中声终声
	 */
	public String engToKor(String eng) {
		StringBuffer sb = new StringBuffer();
		int initialCode = 0, medialCode = 0, finalCode = 0;
		int tempMedialCode, tempFinalCode;

		for (int i = 0; i < eng.length(); i++) {
			/*
			 * 这里找初声
			 */
			System.out.println("要翻译的字符串：" + eng + " , i:" + i);
			initialCode = getCode(CodeType.chosung, eng.substring(i, i + 1));
			if (initialCode == -1) {
				System.out.println("找初声没找到啊。。。");
			} else {
				System.out.println("找到了初声！！！！！！初声的代号是：" + (initialCode / 588)
						+ " i:" + i);

				// 检查到初声以后 移到下一位
				i++;
			}

			/*
			 * 这里找中声
			 */

			// 先找两位的中声
			tempMedialCode = getDoubleMedial(i, eng);
			if (tempMedialCode == -1) {
				System.out.println("两位的中声没有找到。。。");
			}
			if (tempMedialCode != -1) {
				System.out.println("找到了两位的中声！！！！！");
				medialCode = tempMedialCode;
				i += 2;
			}
			// 没有找到两位中声的话 开始找一位中声
			else {
				medialCode = getSingleMedial(i, eng); // 한 자로 이루어진 중성코드 추출
				if (medialCode == -1) {
					System.out.println("一位的中声没有找到。。。");
				} else {
					System.out.println("一位的中声找到了！！！！！");
					System.out
							.println("中声代码是：" + (medialCode / 28) + " i:" + i);

				}
				i++;
			}

			/*
			 * 开始找尾声
			 */

			// 先找两位的尾声
			System.out.println("找尾声前字符串检查 ：" + eng + " 以及i:" + i);
			tempFinalCode = getDoubleFinal(i, eng);
			// 找到了的话
			if (tempFinalCode != -1) {
				System.out.println("找到了两位的尾声");
				finalCode = tempFinalCode;
				// 这里找出中声
				tempMedialCode = getSingleMedial(i + 2, eng);
				if (tempMedialCode != -1) {
					// 如果没有中声，则储存尾声
					finalCode = getSingleFinal(i, eng);
				} else {
					i++;
				}

			}
			// 没有找到两位尾声
			else {
				System.out.println("没有找到两位的尾声");
				// 找一位尾声
				tempMedialCode = getSingleMedial(i + 1, eng);

				if (tempMedialCode != -1) {
					// 如果有中声
					System.out.println("不存在尾声");
					// 没有尾声
					finalCode = 0;
					i--;
				} else {
					System.out.println("存在尾声");
					// 找尾声
					finalCode = getSingleFinal(i, eng);
					System.out.println("尾声的代码是：" + finalCode);

					if (finalCode == -1) {
						finalCode = 0;
						i--;
					}
				}
			}

			if (initialCode < 0) {
				System.out.println("错误的案例： 没有找到初声 可以返回错误 交给前台来处理");
				return "error:101";
			}
			if (medialCode < 0) {
				switch (initialCode / 21 / 28) {
				// rRseEfaqQtTdwWczxvg
				case 0:
					sb.append("ㄱ");
					return sb.toString();

				case 1:
					sb.append("ㄲ");
					return sb.toString();

				case 2:
					sb.append("ㄴ");
					return sb.toString();

				case 3:
					sb.append("ㄷ");
					return sb.toString();

				case 4:
					sb.append("ㄸ");
					return sb.toString();

				case 5:
					sb.append("ㄹ");
					return sb.toString();
				case 6:
					sb.append("ㅁ");
					return sb.toString();
				case 7:
					sb.append("ㅂ");
					return sb.toString();
				case 8:
					sb.append("ㅃ");
					return sb.toString();
				case 9:
					sb.append("ㅅ");
					return sb.toString();
				case 10:
					sb.append("ㅆ");
					return sb.toString();
				case 11:
					sb.append("ㅇ");
					return sb.toString();
				case 12:
					sb.append("ㅈ");
					return sb.toString();
				case 13:
					sb.append("ㅉ");
					return sb.toString();
				case 14:
					sb.append("ㅊ");
					return sb.toString();
				case 15:
					sb.append("ㅋ");
					return sb.toString();
				case 16:
					sb.append("ㅌ");
					return sb.toString();
				case 17:
					sb.append("ㅍ");
					return sb.toString();
				case 18:
					sb.append("ㅎ");
					return sb.toString();

				default:
					break;
				}
			}
			// 通过公式输出
			sb.append((char) (0xAC00 + initialCode + medialCode + finalCode));
			System.out.println("initialCode:" + initialCode + "   medialCode:"
					+ medialCode + "   finalCode:" + finalCode);
		}

		return sb.toString();
	}

	private int getCode(CodeType type, String c) {
		// 初声
		String init = "rRseEfaqQtTdwWczxvg";
		// 中声
		String[] mid = { "k", "o", "i", "O", "j", "p", "u", "P", "h", "hk",
				"ho", "hl", "y", "n", "nj", "np", "nl", "b", "m", "ml", "l" };
		// 尾声
		String[] fin = { "r", "R", "rt", "s", "sw", "sg", "e", "f", "fr", "fa",
				"fq", "ft", "fx", "fv", "fg", "a", "q", "qt", "t", "T", "d",
				"w", "c", "z", "x", "v", "g" };

		switch (type) {
		case chosung:
			int index = init.indexOf(c);
			if (index != -1) {
				return index * 21 * 28;
			}
			break;
		case jungsung:

			for (int i = 0; i < mid.length; i++) {
				if (mid[i].equals(c)) {
					return i * 28;
				}
			}
			break;
		case jongsung:
			for (int i = 0; i < fin.length; i++) {
				if (fin[i].equals(c)) {
					return i + 1;
				}
			}
			break;
		default:
			System.out.println("error");
		}

		return -1;
	}

	// 一位的中声 -1为找不到
	private int getSingleMedial(int i, String eng) {
		if ((i + 1) <= eng.length()) {
			return getCode(CodeType.jungsung, eng.substring(i, i + 1));
		} else {
			return -1;
		}
	}

	// 两位的中声 -1为找不到
	private int getDoubleMedial(int i, String eng) {
		int result;
		if ((i + 2) > eng.length()) {
			return -1;
		} else {
			result = getCode(CodeType.jungsung, eng.substring(i, i + 2));
			if (result != -1) {
				return result;
			} else {
				return -1;
			}
		}
	}

	// 以为的尾声 -1为找不到
	private int getSingleFinal(int i, String eng) {
		if ((i + 1) <= eng.length()) {
			return getCode(CodeType.jongsung, eng.substring(i, i + 1));
		} else {
			return -1;
		}
	}

	// 两位的尾声 -1为找不到
	private int getDoubleFinal(int i, String eng) {
		if ((i + 2) > eng.length()) {
			return -1;
		} else {
			return getCode(CodeType.jongsung, eng.substring(i, i + 2));
		}
	}
}
