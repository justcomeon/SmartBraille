package com.gp.bhi.im;

import java.util.HashMap;

public class im_lang_en {

	// 盲文翻译的map
	private HashMap<String, String> en_map = null;

	// 构造函数 并且初始化map
	public im_lang_en() {
		System.out.println("这里是im_lang_en内部： 初始化前");
		en_map=new HashMap<String, String>();
		en_map.put("000001", "a");
		en_map.put("000011", "b");
		en_map.put("001001", "c");
		en_map.put("011001", "d");
		en_map.put("010001", "e");
		en_map.put("001011", "f");
		en_map.put("011011", "g");
		en_map.put("010011", "h");
		en_map.put("001010", "i");
		en_map.put("011010", "j");
		en_map.put("000101", "k");
		en_map.put("000111", "l");
		en_map.put("001101", "m");
		en_map.put("011101", "n");
		en_map.put("010101", "o");
		en_map.put("001111", "p");
		en_map.put("011111", "q");
		en_map.put("010111", "r");
		en_map.put("001110", "s");
		en_map.put("011110", "t");
		en_map.put("100101", "u");
		en_map.put("100111", "v");
		en_map.put("111010", "w");
		en_map.put("101101", "x");
		en_map.put("111101", "y");
		en_map.put("110101", "z");
		
		// 英语里的符号位置
		en_map.put("100000", "^"); //0代表大写
		
		// 空格位置
		en_map.put("000000", " ");
		System.out.println("这里是im_lang_en内部： 初始化后");
	}
	
	/*翻译盲文到指定语言*/
	public String brailleToEn(String braille_code)
	{
		String _strImLangEn = null;
		_strImLangEn=en_map.get(braille_code);
		
		//判断是否为输入错误
		if(_strImLangEn==null)
		{
			//如果为输入错误 则返回null
			return null;
		}
		return en_map.get(braille_code);
	}

}
