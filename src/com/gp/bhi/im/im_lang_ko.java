package com.gp.bhi.im;

import java.util.HashMap;

public class im_lang_ko {

	// 盲文翻译的map
	private HashMap<String, String> ko_map = null;

	// 构造函数 并且初始化map
	public im_lang_ko() {
		System.out.println("im_lang_ko 这里是im_lang_ko: 我正在把盲文翻译成韩语");
		ko_map = new HashMap<String, String>();
//		// 자음 - 초성
		ko_map.put("001000", "r"); // ㄱ
		ko_map.put("001001", "s"); // ㄴ
		ko_map.put("001010", "e"); // ㄷ
		ko_map.put("010000", "f"); // ㄹ
		ko_map.put("010001", "a"); // ㅁ
		ko_map.put("011000", "q"); // ㅂ
		ko_map.put("100000", "t"); // ㅅ
		ko_map.put("101000", "w"); // ㅈ
		ko_map.put("110000", "c"); // ㅊ
		ko_map.put("001011", "z"); // ㅋ
		ko_map.put("010011", "x"); // ㅌ
		ko_map.put("011001", "v"); // ㅍ
		ko_map.put("011010", "g"); // ㅎ


		// 자음 - 종성
		ko_map.put("000001", "r"); // ㄱ
		ko_map.put("010010", "s"); // ㄴ
		ko_map.put("010100", "e"); // ㄷ
		ko_map.put("000010", "f"); // ㄹ
		ko_map.put("100010", "a"); // ㅁ
		ko_map.put("000011", "q"); // ㅂ
		ko_map.put("000100", "t"); // ㅅ
		ko_map.put("110110", "d"); // ㅇ
		ko_map.put("000101", "w"); // ㅈ
		ko_map.put("000110", "c"); // ㅊ
		ko_map.put("010110", "z"); // ㅋ
		ko_map.put("100110", "x"); // ㅌ
		ko_map.put("110010", "v"); // ㅍ
		ko_map.put("110100", "g"); // ㅎ

		// 모음
		ko_map.put("100011", "k"); // ㅏ
		ko_map.put("011100", "i"); // ㅑ
		ko_map.put("001110", "j"); // ㅓ
		ko_map.put("110001", "u"); // ㅕ
		ko_map.put("100101", "h"); // ㅗ
		ko_map.put("101100", "y"); // ㅛ
		ko_map.put("001101", "n"); // ㅜ
		ko_map.put("101001", "b"); // ㅠ
		ko_map.put("101010", "m"); // ㅡ
		ko_map.put("010101", "l"); // ㅣ

		ko_map.put("010111", "o"); // ㅐ
		ko_map.put("011101", "p"); // ㅔ
		ko_map.put("111101", "hl"); // ㅚ
		ko_map.put("100111", "hk"); // ㅘ
		ko_map.put("001111", "nj"); // ㅝ
		ko_map.put("111010", "ml"); // ㅢ
		ko_map.put("001100", "P"); // ㅖ
		
		
//
//		// 两个 合并 都是以010111 结尾:8
//
//		// ㅟ : 001101 + 010111
//		ko_map.put("001101", "n");
//		ko_map.put("010111", "8");
//
//		// ㅒ : 011100+010111
//		ko_map.put("011100", "i");
//		ko_map.put("010111", "8");
//
//		// ㅙ : 100111+010111
//		ko_map.put("100111", "hk");
//		ko_map.put("010111", "8");
//
//		// ㅞ : 001111+010111
//		ko_map.put("001111", "nj");
//		ko_map.put("010111", "8");
//
//		// 比较特殊 것 111000+001110
//		ko_map.put("111000", "");
//		ko_map.put("001110", "");
//
//		// 약자
//		ko_map.put("101011", "rk"); // 가
//		ko_map.put("001001", "sk"); // 나
//		ko_map.put("001010", "ek"); // 다
//		ko_map.put("010001", "ak"); // 마
//		ko_map.put("011000", "qk"); // 바
//		ko_map.put("000111", "tk"); // 사
//		ko_map.put("101000", "wk"); // 자
//		ko_map.put("001011", "zk"); // 카
//		ko_map.put("010011", "xk"); // 타
//		ko_map.put("011001", "vk"); // 파
//		ko_map.put("011010", "gk"); // 하
//
//		// 双写 尾声
//		ko_map.put("001100", "T"); // 两个ㅅ做尾声
//
//		ko_map.put("111001", "djr"); // 억
//		ko_map.put("111110", "djs"); // 언
//		ko_map.put("011110", "djf"); // 얼
//		ko_map.put("100001", "dus"); // 연
//		ko_map.put("110011", "duf"); // 열
//		ko_map.put("111011", "dud"); // 영
//		ko_map.put("101101", "dhr"); // 옥
//		ko_map.put("110111", "dhs"); // 온
//		ko_map.put("111111", "dhd"); // 옹
//		ko_map.put("011011", "dns"); // 운
//		ko_map.put("101111", "dnf"); // 울
//		ko_map.put("110101", "dms"); // 은
//		ko_map.put("101110", "dmf"); // 을
//		ko_map.put("011111", "dls"); // 인
//
//		// 短语缩写 全是000001开头
//
//		// 1:그래서 000001+001110
//		ko_map.put("000001", "r");
//		ko_map.put("001110", "1");
//
//		// 2:그러나 000001+001001
//		ko_map.put("000001", "r");
//		ko_map.put("001001", "2");
//
//		// 3:그러면 000001+010010
//		ko_map.put("000001", "r");
//		ko_map.put("010010", "3");
//
//		// 4:그러므로 000001+100010
//		ko_map.put("000001", "r");
//		ko_map.put("100010", "4");
//
//		// 5:그런데 000001+011101
//		ko_map.put("000001", "r");
//		ko_map.put("011101", "5");
//
//		// 6:그리고 000001+100101
//		ko_map.put("000001", "r");
//		ko_map.put("100101", "6");
//
//		// 7:그리하여 000001+110001
//		ko_map.put("110001", "7");
		
		//`````````````````````````````````````````````````````````
		// 자음 - 초성
//				ko_map.put("001000", "ㄱ"); // ㄱ
//				ko_map.put("001001", "ㄴ"); // ㄴ
//				ko_map.put("001010", "ㄷ"); // ㄷ
//				ko_map.put("010000", "ㄹ"); // ㄹ
//				ko_map.put("010001", "ㅁ"); // ㅁ
//				ko_map.put("011000", "ㅂ"); // ㅂ
//				ko_map.put("100000", "ㅅ"); // ㅅ
//				ko_map.put("101000", "ㅈ"); // ㅈ
//				ko_map.put("110000", "ㅊ"); // ㅊ
//				ko_map.put("001011", "ㅋ"); // ㅋ
//				ko_map.put("010011", "ㅌ"); // ㅌ
//				ko_map.put("011001", "ㅍ"); // ㅍ
//				ko_map.put("011010", "ㅎ"); // ㅎ
//				ko_map.put("100000", "^"); // 双写
//
//				// 자음 - 종성
//				ko_map.put("000001", "ㄱ"); // ㄱ
//				ko_map.put("010010", "ㄴ"); // ㄴ
//				ko_map.put("010100", "ㄷ"); // ㄷ
//				ko_map.put("000010", "ㄹ"); // ㄹ
//				ko_map.put("100010", "ㅁ"); // ㅁ
//				ko_map.put("000011", "ㅂ"); // ㅂ
//				ko_map.put("000100", "ㅅ"); // ㅅ
//				ko_map.put("110110", "ㅇ"); // ㅇ
//				ko_map.put("000101", "ㅈ"); // ㅈ
//				ko_map.put("000100", "ㅊ"); // ㅊ
//				ko_map.put("010110", "ㅋ"); // ㅋ
//				ko_map.put("100110", "ㅌ"); // ㅌ
//				ko_map.put("110010", "ㅍ"); // ㅍ
//				ko_map.put("110100", "ㅎ"); // ㅎ
//
//				// 모음
//				ko_map.put("100011", "ㅏ"); // ㅏ
//				ko_map.put("011100", "ㅑ"); // ㅑ
//				ko_map.put("001110", "ㅓ"); // ㅓ
//				ko_map.put("110001", "ㅕ"); // ㅕ
//				ko_map.put("100101", "ㅗ"); // ㅗ
//				ko_map.put("101100", "ㅛ"); // ㅛ
//				ko_map.put("001101", "ㅜ"); // ㅜ
//				ko_map.put("101001", "ㅠ"); // ㅠ
//				ko_map.put("101010", "ㅡ"); // ㅡ
//				ko_map.put("010101", "ㅣ"); // ㅣ

//				ko_map.put("010111", "ㅐ"); // ㅐ
//				ko_map.put("011101", "ㅔ"); // ㅔ
//				ko_map.put("111101", "hl"); // ㅚ
//				ko_map.put("100111", "hk"); // ㅘ
//				ko_map.put("001111", "nj"); // ㅝ
//				ko_map.put("111010", "ml"); // ㅢ
//				ko_map.put("001100", "P"); // ㅖ
//
//				// 两个 合并 都是以010111 结尾:8
//
//				// ㅟ : 001101 + 010111
//				ko_map.put("001101", "n");
//				ko_map.put("010111", "8");
//
//				// ㅒ : 011100+010111
//				ko_map.put("011100", "i");
//				ko_map.put("010111", "8");
//
//				// ㅙ : 100111+010111
//				ko_map.put("100111", "hk");
//				ko_map.put("010111", "8");
//
//				// ㅞ : 001111+010111
//				ko_map.put("001111", "nj");
//				ko_map.put("010111", "8");
//
//				// 比较特殊 것 111000+001110
//				ko_map.put("111000", "");
//				ko_map.put("001110", "");
//
//				// 약자
//				ko_map.put("101011", "rk"); // 가
//				ko_map.put("001001", "sk"); // 나
//				ko_map.put("001010", "ek"); // 다
//				ko_map.put("010001", "ak"); // 마
//				ko_map.put("011000", "qk"); // 바
//				ko_map.put("000111", "tk"); // 사
//				ko_map.put("101000", "wk"); // 자
//				ko_map.put("001011", "zk"); // 카
//				ko_map.put("010011", "xk"); // 타
//				ko_map.put("011001", "vk"); // 파
//				ko_map.put("011010", "gk"); // 하
//
//				// 双写 尾声
//				ko_map.put("001100", "T"); // 两个ㅅ做尾声
//
//				ko_map.put("111001", "djr"); // 억
//				ko_map.put("111110", "djs"); // 언
//				ko_map.put("011110", "djf"); // 얼
//				ko_map.put("100001", "dus"); // 연
//				ko_map.put("110011", "duf"); // 열
//				ko_map.put("111011", "dud"); // 영
//				ko_map.put("101101", "dhr"); // 옥
//				ko_map.put("110111", "dhs"); // 온
//				ko_map.put("111111", "dhd"); // 옹
//				ko_map.put("011011", "dns"); // 운
//				ko_map.put("101111", "dnf"); // 울
//				ko_map.put("110101", "dms"); // 은
//				ko_map.put("101110", "dmf"); // 을
//				ko_map.put("011111", "dls"); // 인
//
//				// 短语缩写 全是000001开头
//
//				// 1:그래서 000001+001110
//				ko_map.put("000001", "r");
//				ko_map.put("001110", "1");
//
//				// 2:그러나 000001+001001
//				ko_map.put("000001", "r");
//				ko_map.put("001001", "2");
//
//				// 3:그러면 000001+010010
//				ko_map.put("000001", "r");
//				ko_map.put("010010", "3");
//
//				// 4:그러므로 000001+100010
//				ko_map.put("000001", "r");
//				ko_map.put("100010", "4");
//
//				// 5:그런데 000001+011101
//				ko_map.put("000001", "r");
//				ko_map.put("011101", "5");
//
//				// 6:그리고 000001+100101
//				ko_map.put("000001", "r");
//				ko_map.put("100101", "6");
//
//				// 7:그리하여 000001+110001
//				ko_map.put("110001", "7");

	}
	/*翻译盲文到指定语言*/
	public String brailleToKo(String braille_code)
	{
		String _strImLangKo = null;
		_strImLangKo=ko_map.get(braille_code);
		System.out.println("im_lang_ko 这里的韩文字符是："+_strImLangKo);
		
		//判断是否为输入错误
		if(_strImLangKo==null)
		{
			//如果为输入错误 则返回null
			return null;
		}
		return ko_map.get(braille_code);
	}

}
