package com.hiwayne.hive.udf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.hadoop.hive.ql.exec.UDF;

public class UDFDateformatAtStr extends UDF {

	public String evaluate(String dateStr, String showFormatStr,
			String coverFormatStr, String LocaleDesc) {
		// 选定本地化
		Locale user;
		if (LocaleDesc != null && LocaleDesc.equals("cn")) {
			user = Locale.CHINA;
		} else {
			user = Locale.US;
		}
		String showinfo = "NULL";
		SimpleDateFormat cover = new SimpleDateFormat(coverFormatStr, user);
		SimpleDateFormat show;
		Date adate;
		try {
			adate = cover.parse(dateStr);
			show = new SimpleDateFormat(showFormatStr, user);
			showinfo = show.format(adate);
		} catch (Exception e) {
		}
		cover = null;
		show = null;
		adate = null;
		return showinfo;
	}

	public static void main(String[] args) {
		UDFDateformatAtStr aDateformatAtStr = new UDFDateformatAtStr();
		String showinfo = aDateformatAtStr.evaluate(
				"12/Apr/2012:19:55:50 +0800", "yyyy-mm",
				"dd/MMM/yyyy:HH:mm:ss Z", "us");
		System.out.println(showinfo);

		showinfo = aDateformatAtStr.evaluate("2012-11-08 10:04:48",
				"yyyy-MM-dd HH", "yyyy-MM-dd HH:mm:ss", "cn");
		System.out.println(showinfo);
	}

}
