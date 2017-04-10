package com.gp.bhi.ui;

import javax.security.auth.PrivateCredentialPermission;

import com.example.graduation_project_bhi.R;
import com.gp.bhi.im.im_core;
import com.gp.bhi.tools.tools_brailleCodeOperation;
import com.gp.bhi.tools.tools_checkInputContent;
import com.gp.bhi.tools.tools_readOnlyEditText;

import android.os.Bundle;
import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Ui_main extends Activity implements OnClickListener,
		OnLongClickListener {

	/* 枚举，使用的语言 */
	public enum Language {
		ko, en;
	}

	/**************************
	 * 声明待用变量
	 **************************/
	// 第一页的linearLayout
	LinearLayout linearLayout_top = null;
	LinearLayout linearLayout_1 = null;
	LinearLayout linearLayout_2 = null;
	LinearLayout linearLayout_3 = null;

	// 第一页的6个点
	TableRow tableRow_0 = null;
	TableRow tableRow_1 = null;
	TableRow tableRow_2 = null;
	TableRow tableRow_3 = null;
	TableRow tableRow_4 = null;
	TableRow tableRow_5 = null;

	// UI上的tTextView控件
	TextView tv_chattingHistory = null;

	// UI上的EditText控件
	EditText et_inputArea = null;

	// 获取屏幕大小
	DisplayMetrics dm = null;
	int SCREEN_WIDTH = 0;
	int SCREEN_HEIGHT = 0;

	// 盲文点数组
	boolean braille_points[] = null;

	// 选择语言
	Language lang = Language.en;

	// 输入内容
	public static String myContent = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* 全屏 去标题栏 */
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.layout_main);

		/*
		 * 变量赋值 - UI部分
		 */
		// 6个盲文块
		tableRow_0 = (TableRow) findViewById(R.id.TableRow0);
		tableRow_1 = (TableRow) findViewById(R.id.TableRow1);
		tableRow_2 = (TableRow) findViewById(R.id.TableRow2);
		tableRow_3 = (TableRow) findViewById(R.id.TableRow3);
		tableRow_4 = (TableRow) findViewById(R.id.TableRow4);
		tableRow_5 = (TableRow) findViewById(R.id.TableRow5);

		// 输入待选区
		et_inputArea = tools_readOnlyEditText
				.getReadOnlyEditText((EditText) findViewById(R.id.et_inputArea));

		// 聊天内容显示区
		tv_chattingHistory = (TextView) findViewById(R.id.tv_chattingHistory);

		/*
		 * 变量赋值 - 逻辑部分
		 */
		// 盲文数组实例化， 默认全为false
		braille_points = new boolean[6];

		/*
		 * 操作部分
		 */

		/* 获取屏幕大小 */
		dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		this.SCREEN_WIDTH = dm.widthPixels;
		this.SCREEN_HEIGHT = dm.heightPixels;

		/* 输出屏幕信息到命令行 */
		Log.i("ScreenSize:", "width:" + Integer.toString(SCREEN_WIDTH)
				+ " height:" + Integer.toString(SCREEN_HEIGHT));

		/* 设置大小 */
		tableRow_0.setMinimumWidth(SCREEN_WIDTH / 2);
		tableRow_0.setMinimumHeight(SCREEN_HEIGHT / 3);

		tableRow_1.setMinimumWidth(SCREEN_WIDTH / 2);
		tableRow_1.setMinimumHeight(SCREEN_HEIGHT / 3);

		tableRow_2.setMinimumWidth(SCREEN_WIDTH / 2);
		tableRow_2.setMinimumHeight(SCREEN_HEIGHT / 3);

		tableRow_3.setMinimumWidth(SCREEN_WIDTH / 2);
		tableRow_3.setMinimumHeight(SCREEN_HEIGHT / 3);

		tableRow_4.setMinimumWidth(SCREEN_WIDTH / 2);
		tableRow_4.setMinimumHeight(SCREEN_HEIGHT / 3);

		tableRow_5.setMinimumWidth(SCREEN_WIDTH / 2);
		tableRow_5.setMinimumHeight(SCREEN_HEIGHT / 3);

		/* 轻点 事件 */
		tableRow_0.setOnClickListener(this);
		tableRow_1.setOnClickListener(this);
		tableRow_2.setOnClickListener(this);
		tableRow_3.setOnClickListener(this);
		tableRow_4.setOnClickListener(this);
		tableRow_5.setOnClickListener(this);

		/* 长按事件 */
		tableRow_0.setOnLongClickListener(this);
		tableRow_1.setOnLongClickListener(this);
		tableRow_2.setOnLongClickListener(this);
		tableRow_3.setOnLongClickListener(this);
		tableRow_4.setOnLongClickListener(this);
		tableRow_5.setOnLongClickListener(this);

		/* 输入待选框处理 */
		et_inputArea.setWidth(SCREEN_WIDTH / 2); // 设置宽度
		et_inputArea.setFocusable(false); // 设置不能聚点
		et_inputArea.setText(""); // 初始化内容
		// et_inputArea.setBackgroundColor(Color.parseColor("#000000"));
		/* 聊天记录框处理 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/*
	 * 重写onClick
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View view) {
		if (view == tableRow_0) {
			Log.i("onClickListener", "tableRow_0");
			braille_points[0] = !braille_points[0];
			Log.i("onClickListener", "step1");
			tableRow_0.setBackgroundDrawable(ui_getBrailleDrawable
					.get_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3,
							braille_points[0], false));
			Log.i("onClickListener", "step2");
		} else if (view == tableRow_1) {
			Log.i("onClickListener", "tableRow_1");
			braille_points[1] = !braille_points[1];
			tableRow_1.setBackgroundDrawable(ui_getBrailleDrawable
					.get_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3,
							braille_points[1], true));
		} else if (view == tableRow_2) {
			Log.i("onClickListener", "tableRow_2");
			braille_points[2] = !braille_points[2];
			tableRow_2.setBackgroundDrawable(ui_getBrailleDrawable
					.get_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3,
							braille_points[2], false));
		} else if (view == tableRow_3) {
			Log.i("onClickListener", "tableRow_3");
			braille_points[3] = !braille_points[3];
			tableRow_3.setBackgroundDrawable(ui_getBrailleDrawable
					.get_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3,
							braille_points[3], true));
		} else if (view == tableRow_4) {
			Log.i("onClickListener", "tableRow_4");
			braille_points[4] = !braille_points[4];
			tableRow_4.setBackgroundDrawable(ui_getBrailleDrawable
					.get_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3,
							braille_points[4], false));
		} else if (view == tableRow_5) {
			Log.i("onClickListener", "tableRow_5");
			braille_points[5] = !braille_points[5];
			tableRow_5.setBackgroundDrawable(ui_getBrailleDrawable
					.get_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3,
							braille_points[5], true));
		}

	}

	/*
	 * 重写onLongClick
	 * 
	 * @see android.view.View.OnLongClickListener#onLongClick(android.view.View)
	 */
	public boolean onLongClick(View view) {
		if (view == tableRow_0) {
			tableRow_0.setBackgroundColor(Color.RED);

			int shower[] = new int[6];
			for (int i = 0; i < braille_points.length; i++) {
				if (braille_points[i])
					shower[i] = 1;
				else {
					shower[i] = 0;
				}
			}
			Log.i("braille_points:",
					Integer.toString(shower[5]) + Integer.toString(shower[4])
							+ Integer.toString(shower[3])
							+ Integer.toString(shower[2])
							+ Integer.toString(shower[1])
							+ Integer.toString(shower[0]));

			return true;
		} else if (view == tableRow_1) {
			et_inputArea.setText("");
			tableRow_0
					.setBackgroundDrawable(ui_getBrailleDrawable
							.clear_Drawable(SCREEN_WIDTH / 2,
									SCREEN_HEIGHT / 3, false));

			tableRow_1.setBackgroundDrawable(ui_getBrailleDrawable
					.clear_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3, true));
			tableRow_2
					.setBackgroundDrawable(ui_getBrailleDrawable
							.clear_Drawable(SCREEN_WIDTH / 2,
									SCREEN_HEIGHT / 3, false));
			tableRow_3.setBackgroundDrawable(ui_getBrailleDrawable
					.clear_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3, true));
			tableRow_4
					.setBackgroundDrawable(ui_getBrailleDrawable
							.clear_Drawable(SCREEN_WIDTH / 2,
									SCREEN_HEIGHT / 3, false));
			tableRow_5.setBackgroundDrawable(ui_getBrailleDrawable
					.clear_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3, true));
			braille_points[0] = false;
			braille_points[1] = false;
			braille_points[2] = false;
			braille_points[3] = false;
			braille_points[4] = false;
			braille_points[5] = false;
			myContent = "";
			return true;
		}
		/*
		 * 3号 清屏
		 */
		else if (view == tableRow_2) {

			tableRow_0
					.setBackgroundDrawable(ui_getBrailleDrawable
							.clear_Drawable(SCREEN_WIDTH / 2,
									SCREEN_HEIGHT / 3, false));

			tableRow_1.setBackgroundDrawable(ui_getBrailleDrawable
					.clear_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3, true));
			tableRow_2
					.setBackgroundDrawable(ui_getBrailleDrawable
							.clear_Drawable(SCREEN_WIDTH / 2,
									SCREEN_HEIGHT / 3, false));
			tableRow_3.setBackgroundDrawable(ui_getBrailleDrawable
					.clear_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3, true));
			tableRow_4
					.setBackgroundDrawable(ui_getBrailleDrawable
							.clear_Drawable(SCREEN_WIDTH / 2,
									SCREEN_HEIGHT / 3, false));
			tableRow_5.setBackgroundDrawable(ui_getBrailleDrawable
					.clear_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3, true));
			braille_points[0] = false;
			braille_points[1] = false;
			braille_points[2] = false;
			braille_points[3] = false;
			braille_points[4] = false;
			braille_points[5] = false;

			return true;
		}
		/*
		 * 暂时用来换语言用
		 */
		else if (view == tableRow_3) {
			myContent="";
			this.et_inputArea.setText("");
			if(lang==Language.en)
			{
				lang=Language.ko;return true;
			}
			
			if(lang==Language.ko)
			{
				lang=Language.en;return true;
			}
			
		} else if (view == tableRow_4) {

			return true;

		}
		/*
		 * 
		 * 6号 确认输入
		 */
		else if (view == tableRow_5) {
			// 翻译盲文到字符
			// 检验返回的结果是否为空
			String _tempInputStr = im_core.im_mapping(lang,
					tools_brailleCodeOperation.boolToString(braille_points),
					et_inputArea.getText().toString());
			System.out.println("界面层:" + _tempInputStr);

			// 不为空则添加
			if (_tempInputStr != null) {
				//用来接受将要显示的内容
				String _str=tools_checkInputContent.check(lang,
						myContent, _tempInputStr);
				
				//制作spannableString 
				SpannableString toEditText = new SpannableString(_str);
				
				//设置最后一位为黑底
				toEditText.setSpan(new BackgroundColorSpan(Color.parseColor("#000000")),_str.length()-1,_str.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				//设置所有字体为白色
				toEditText.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, _str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//				et_inputArea.setText(tools_checkInputContent.check(lang,
//						myContent, _tempInputStr));
				et_inputArea.setText(toEditText);
				myContent = myContent + _tempInputStr;
				
				System.out.println("输入内容储存用：" + myContent);

			}

			// 清空当前状态
			tableRow_0
					.setBackgroundDrawable(ui_getBrailleDrawable
							.clear_Drawable(SCREEN_WIDTH / 2,
									SCREEN_HEIGHT / 3, false));

			tableRow_1.setBackgroundDrawable(ui_getBrailleDrawable
					.clear_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3, true));
			tableRow_2
					.setBackgroundDrawable(ui_getBrailleDrawable
							.clear_Drawable(SCREEN_WIDTH / 2,
									SCREEN_HEIGHT / 3, false));
			tableRow_3.setBackgroundDrawable(ui_getBrailleDrawable
					.clear_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3, true));
			tableRow_4
					.setBackgroundDrawable(ui_getBrailleDrawable
							.clear_Drawable(SCREEN_WIDTH / 2,
									SCREEN_HEIGHT / 3, false));
			tableRow_5.setBackgroundDrawable(ui_getBrailleDrawable
					.clear_Drawable(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 3, true));
			braille_points[0] = false;
			braille_points[1] = false;
			braille_points[2] = false;
			braille_points[3] = false;
			braille_points[4] = false;
			braille_points[5] = false;
			return true;
		}
		return false;

	}
}
