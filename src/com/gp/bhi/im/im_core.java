package com.gp.bhi.im;


import com.gp.bhi.ui.Ui_main.Language;

public class im_core {

	public static String im_mapping(Language user_langString,
			String braille_code, String inputedContent) {
		/* 枚举出使用者使用的语言 */
		switch (user_langString) {
		case en:
			return im_mapping_en(braille_code);

		case ko:

			return im_mapping_ko(braille_code,inputedContent);
		default:
			break;
		}
		return null;
	}

	/*
	 * 英文部分
	 */
	private static String im_mapping_en(String _str) {
		im_lang_en braille_en_translator = new im_lang_en();
		if (braille_en_translator.brailleToEn(_str) == null) {
			return null;
		}
		// 用来接受翻译内容的数组
		char[] _charArr_en = braille_en_translator.brailleToEn(_str)
				.toCharArray();
		if (_charArr_en == null)
			return "haha";
		System.out.println("im_core 3曰19日测试： 到这里的字符串为："
				+ braille_en_translator.brailleToEn(_str));
		// 遍历寻找是否有大写英文字母
		for (int i = 0; i < _charArr_en.length; i++) {
			System.out.println("_charArr[" + i + "]:" + _charArr_en[i]);
			if (_charArr_en[i] == 48) {
				System.out.println("here");
				// _charArr_en[i+1]=(char)((int)_charArr_en[i+1]+32);
			}
		}
		System.out.println("im_core 这里是im_mapping，获得的盲文代码是" + _str + " 翻译的内容是："
				+ braille_en_translator.brailleToEn(_str));
		System.out.println("im_core 3曰19日测试： 字符串为" + String.valueOf(_charArr_en));
		return String.valueOf(_charArr_en);
	}
	
	/*
	 * 韩文部分
	 */
	private static String im_mapping_ko(String _str,String inputedContent) {
		System.out.println("im_core 现在的位置 输入框里的内容是:"+ inputedContent);
		im_lang_ko braille_ko_translator = new im_lang_ko();
		if(braille_ko_translator.brailleToKo(_str) == null)
		{
			return null;
		}
		System.out.println("im_core 韩文部分测试： "+braille_ko_translator.brailleToKo(_str));
		System.out.println(im_operate_enToKo.enToKo(braille_ko_translator.brailleToKo(_str),inputedContent));
	
//		return braille_ko_translator.brailleToKo(_str);
		return braille_ko_translator.brailleToKo(_str);
		
	}
}
