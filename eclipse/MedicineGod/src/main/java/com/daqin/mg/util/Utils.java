package com.daqin.mg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utils {
	public static long getDateFromString(String Value) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long time = 0;
		try {
			// 将日期转成Date对象作比较
			java.util.Date fomatDate = dateFormat.parse(Value);
			time = fomatDate.getTime();

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	public static String getStringFromDate(long Value) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(Value);
		return dateFormat.format(date);
	}

	public static String getRandomKeyId() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString().toUpperCase();
	}

	public static String getTimeString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date datenow = new Date();
		return dateFormat.format(datenow);
	}

	public static int isTimeOut(String timeA, String timeB) {
		/**
		 * @param timeA  第一个时间
		 * @param timeB  第二个时间
		 * @param return 0为临期；-1过期；1未过期;
		 */
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int res = 0;
		try {
			// 将日期转成Date对象作比较
			Date fomatDate1 = dateFormat.parse(timeA);
			Date fomatDate2 = dateFormat.parse(timeB);

			Long time1 = fomatDate1.getTime();
			Long time2 = fomatDate2.getTime();

			int day = (int) ((time1 - time2) / (24 * 3600 * 1000));

			if (day <= 0) {
				res = -1;
			} else if (day <= 60) {
				res = 0;
			} else {
				res = 1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static int[] getRemainTime(String timeA, String timeB) {
		/**
		 * @param timeA  第一个时间
		 * @param timeB  第二个时间
		 * @param return 返回时间数组
		 */
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int[] outdate = new int[] { 0, 0, 0, 0, 0, 0 };
		// 0年 1月 2天 3时 4分 5秒
		try {
			// 将日期转成Date对象作比较
			Date fomatDate1 = dateFormat.parse(timeA);
			Date fomatDate2 = dateFormat.parse(timeB);

			Long time1 = fomatDate1.getTime();
			Long time2 = fomatDate2.getTime();
			int second = (int) ((time1 - time2) / 1000);
			// 如有更好的方案则优化此处
			if (second > 0) {
				outdate[5] = second;
				if (outdate[5] >= 60) {
					outdate[4] = outdate[5] / 60;
					outdate[5] = outdate[5] % 60;
					if (outdate[4] >= 60) {
						outdate[3] = outdate[4] / 60;
						outdate[4] = outdate[4] % 60;
						if (outdate[3] > 24) {
							outdate[2] = outdate[3] / 24;
							outdate[3] = outdate[3] % 24;
							if (outdate[2] > 30) {
								outdate[1] = outdate[2] / 30;
								outdate[2] = outdate[2] % 30;
								if (outdate[1] > 12) {
									outdate[0] = outdate[1] / 12;
									outdate[1] = outdate[1] % 12;
								}
							}
						}
					}
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return outdate;
	}

	public static String getOutDateString(long date, int style) {
		
		// timeA 2022-03-01 药品的时间
		// timeB 2022-01-01 现在的时间
		String timeA = getStringFromDate(date);
		Calendar cl = Calendar.getInstance();
		String timeB = cl.get(Calendar.YEAR) + "-" + (cl.get(Calendar.MONTH) + 1) + "-" + cl.get(Calendar.DAY_OF_MONTH);
		int[] outdate_res = getRemainTime(timeA, timeB);
		String res = "";
		if (style == 1) {
			res = "过期时间:";
			res = res + ((outdate_res[0] == 0) ? "" : outdate_res[0] + "年");
			res = res + ((outdate_res[1] == 0) ? "" : outdate_res[1] + "月");
			res = res + ((outdate_res[2] == 0) ? "" : outdate_res[2] + "天");
			res = res + "后过期";
		} else if (style == 2) {
			res = "还有";
			res = res + ((outdate_res[0] == 0) ? "" : outdate_res[0] + "年");
			res = res + ((outdate_res[1] == 0) ? "" : outdate_res[1] + "月");
			res = res + ((outdate_res[2] == 0) ? "" : outdate_res[2] + "天");
			res = res + "过期";
		}
		if (res.equals("还有过期") || res.equals("过期时间:后过期")) {
			return "已过期";
		}
		return res;
	}
}
