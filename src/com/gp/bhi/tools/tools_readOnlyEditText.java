package com.gp.bhi.tools;

import android.widget.EditText;

public class tools_readOnlyEditText {
	public static EditText getReadOnlyEditText(EditText et) {
		//获取进去的et 取消触摸点击按键的回馈
		et.setFocusable(false);
		et.setOnTouchListener(null);
		et.setOnClickListener(null);
		et.setOnKeyListener(null);
		return et;
	}

}
