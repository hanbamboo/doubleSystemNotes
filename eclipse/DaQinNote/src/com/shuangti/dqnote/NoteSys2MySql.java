package com.shuangti.dqnote;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * 
 * @笔记管理系统 具有增删查改的基本功能
 *
 */
public class NoteSys2MySql {
	// 具体笔记数据，用于储存
	static ArrayList<Map<String, String>> data = new ArrayList<Map<String, String>>();

	// 输入流和日历类
	static Scanner scanner = new Scanner(System.in);
	static Calendar calendar = new GregorianCalendar();
	static final String URL = "jdbc:mysql://localhost/note?user=root&password=123456&serverTimezone=UTC&useSSL=false&CHARSET=utf8";
	static final String TABLE_NAME = "notedata";
	static java.sql.PreparedStatement ppstatement = null;
	static Connection conn = null;
	static final String COLUMN_ID = "ID";
	static final String COLUMN_TITLE = "TITLE";
	static final String COLUMN_CONTENT = "CONTENT";
	static final String COLUMN_TODO = "TODO";
	static final String COLUMN_LOVE = "LOVE";
	static final String COLUMN_TYPE = "TYPE";
	static final String COLUMN_TIME = "TIME";
	static ResultSet resultSet = null;
//	public static void createTable() {
//		try {
//			String createTableSql = "CREATE TABLE `" + TABLE_NAME + "` (`" + COLUMN_ID
//					+ "` varchar(6) PRIMARY KEY NOT NULL," + "`" + COLUMN_TITLE + "` text(255) NOT NULL," + "`"
//					+ COLUMN_CONTENT + "` text(255) NOT NULL," + "`" + COLUMN_TODO + "` char(1) NOT NULL," + "`"
//					+ COLUMN_LOVE + "` char(1) NOT NULL," + "`" + COLUMN_TYPE + "` text(255) NOT NULL," + "`"
//					+ COLUMN_TIME + "` text(255) NOT NULL" + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
//			statement.executeUpdate(createTableSql);
//		} catch (Exception e) {
//		}
//	}

	public static void main(String[] args) {

		try {
			conn = DriverManager.getConnection(URL);
//			createTable();
			getAllMetaData();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		while (true) {
			showSysMenu();
			System.out.print("请选择:");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				// 创建笔记
				createNote();
				break;
			case 2:
				// 展示笔记
				showNote(true);
				break;
			case 3:
				// 查找笔记
				findNote();
				break;
			case 4:
				// 筛选笔记分类
				screenNote();
				break;
			case 5:
				// 删改笔记
				actionNote();
				break;
			case 6:
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				if (ppstatement != null) {
					try {
						ppstatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("###指令无效###");
				break;
			}

		}
	}

	/**
	 * @showSysMenu 展示系统菜单
	 */
	public static void showSysMenu() {
		System.out.println();
		System.out.println("==========================");
		System.out.println("==\t      笔记系统           \t==");
		System.out.println("==\t1.新的笔记 2.查看记录\t==");
		System.out.println("==\t3.搜索笔记 4.分类筛选\t==");
		System.out.println("==\t5.操作笔记 6.退出系统\t==");
		System.out.println("==\t               \t==");
	}

	/**
	 * @showFindMenu 展示查找菜单
	 */
	public static void showFindMenu() {
		System.out.println("==========================");
		System.out.println("==\t      笔记查询           \t==");
		System.out.println("==\t1.查询ID 2.查询标题\t==");
		System.out.println("==\t3.模糊全查  4.退出查询\t==");
		System.out.println("==\t               \t==");
	}

	/**
	 * showActionMenu 展示操作菜单
	 */
	public static void showActionMenu() {
		System.out.println("==========================");
		System.out.println("==\t      笔记操作           \t==");
		System.out.println("==\t1.修改笔记 2.删除笔记\t==");
		System.out.println("==\t3.复制笔记  4.退出操作\t==");
		System.out.println("==\t               \t==");
	}

	/**
	 * @screenNote 筛选分类模块(默认为"默认")
	 */
	public static void screenNote() {
		getAllMetaData();
		if (data.size() == 0) {
			System.out.println("\t###无记录可操作###");
			System.out.print("输入任意内容后返回:");
			scanner.next();
			return;
		}
		System.out.print("\t你拥有以下分类：");

		try {
			String sql = "select " + COLUMN_TYPE + " from " + TABLE_NAME + " group by " + COLUMN_TYPE;
			ppstatement = conn.prepareStatement(sql);
			ResultSet res = ppstatement.executeQuery();
			res.getString(COLUMN_TYPE);
			System.out.print("【" + res + "】 ");
		} catch (Exception e) {
			System.out.println("###查询失败###");
		}
//
//		System.out.print("请输入分类名：");
//		String ac = scanner.next();
//		System.out.println("\t序列\t标题\t\t待办\t收藏\t内容\t\t分类\t最后修改时间");
//		int count = 0;
//		count++;
//		String id = res.getString(COLUMN_ID);
//		String title = res.getString(COLUMN_TITLE);
//		if (title.length() > 5) {
//			title = title.substring(0, 5) + "...";
//		}
//		String content = res.getString(COLUMN_CONTENT);
//		if (content.length() > 5) {
//			content = content.substring(0, 5) + "...";
//		}
//		String type = res.getString(COLUMN_TYPE);
//		String time = res.getString(COLUMN_TIME);
//		String complete = res.getString(COLUMN_TODO).equals("1") ? "✔" : "□";
//		String love = res.getString(COLUMN_LOVE).equals("1") ? "♥" : "♡";
//		System.out.print("\t" + id + "\t" + title + "\t\t" + complete + "\t" + love + "\t" + content + "\t\t" + type
//				+ "\t" + time);
//		System.out.println();
//
//		System.out.println("###找到包含\"" + ac + "\"的共有" + count + "条数据###");
//		System.out.print("输入任意内容后返回:");
//		scanner.next();

	}

	/**
	 * @findNoteId 通过笔记id准确查找笔记
	 * @param id
	 * @输出 查找到的内容
	 */
	public static void findNoteId(String id) {
		if (!isInData(id)) {
			System.out.println("###序列id不合法###");
		} else {
			System.out.println("\t序列\t标题\t\t待办\t收藏\t内容\t分类\t最后修改时间");
			int count = 0;
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).get(COLUMN_ID).contains(id)) {
					count++;
					String idd = data.get(i).get(COLUMN_ID);
					String title = data.get(i).get(COLUMN_TITLE);
					if (title.length() > 5) {
						title = title.substring(0, 5) + "...";
					}
					String content = data.get(i).get(COLUMN_CONTENT);
					if (content.length() > 5) {
						content = content.substring(0, 5) + "...";
					}
					String type = data.get(i).get(COLUMN_TYPE);
					String time = data.get(i).get(COLUMN_TIME);
					String complete = data.get(i).get(COLUMN_TODO).equals("1") ? "✔" : "□";
					String love = data.get(i).get(COLUMN_LOVE).equals("1") ? "♥" : "♡";
					System.out.print("\t" + idd + "\t" + title + "\t\t" + complete + "\t" + love + "\t" + content
							+ "\t\t" + type + "\t" + time);
					System.out.println();
				}

			}

			System.out.println("###找到包含\"" + id + "\"的共有" + count + "条数据###");
			System.out.print("输入任意内容后返回:");
			scanner.next();

		}
	}

	/**
	 * findNoteTitle 通过笔记标题模糊查找笔记
	 * 
	 * @param titleFind
	 * @输出 查找到的内容
	 */
	public static void findNoteTitle(String titleFind) {
		System.out.println("\t序列\t标题\t\t待办\t收藏\t内容\t\t分类\t最后修改时间");
		int count = 0;

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).get(COLUMN_TITLE).contains(titleFind)) {
				count++;
				String idd = data.get(i).get(COLUMN_ID);
				String title = data.get(i).get(COLUMN_TITLE);
				if (title.length() > 5) {
					title = title.substring(0, 5) + "...";
				}
				String content = data.get(i).get(COLUMN_CONTENT);
				if (content.length() > 5) {
					content = content.substring(0, 5) + "...";
				}
				String type = data.get(i).get(COLUMN_TYPE);
				String time = data.get(i).get(COLUMN_TIME);
				String complete = data.get(i).get(COLUMN_TODO).equals("1") ? "✔" : "□";
				String love = data.get(i).get(COLUMN_LOVE).equals("1") ? "♥" : "♡";
				System.out.print("\t" + idd + "\t" + title + "\t\t" + complete + "\t" + love + "\t" + content + "\t\t"
						+ type + "\t" + time);
				System.out.println();
			}

		}

		System.out.println("###找到包含\"" + titleFind + "\"的共有" + count + "条数据###");
		System.out.print("输入任意内容后返回:");
		scanner.next();

	}

	/**
	 * findNoteMsg 通过内容模糊查找笔记是否有此内容
	 * 
	 * @param msg
	 * @输出 查找到的内容
	 */
	public static void findNoteMsg(String msg) {
		System.out.println("\t序列\t标题\t\t待办\t收藏\t内容\t分类\t最后修改时间");
		int count = 0;

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).get(COLUMN_TITLE).contains(msg) || data.get(i).get(COLUMN_ID).contains(msg)
					|| data.get(i).get(COLUMN_CONTENT).contains(msg) || data.get(i).get(COLUMN_TYPE).contains(msg)) {
				count++;
				String idd = data.get(i).get(COLUMN_ID);
				String title = data.get(i).get(COLUMN_TITLE);
				if (title.length() > 5) {
					title = title.substring(0, 5) + "...";
				}
				String content = data.get(i).get(COLUMN_CONTENT);
				if (content.length() > 5) {
					content = content.substring(0, 5) + "...";
				}
				String type = data.get(i).get(COLUMN_TYPE);
				String time = data.get(i).get(COLUMN_TIME);
				String complete = data.get(i).get(COLUMN_TODO).equals("1") ? "✔" : "□";
				String love = data.get(i).get(COLUMN_LOVE).equals("1") ? "♥" : "♡";
				System.out.print("\t" + idd + "\t" + title + "\t\t" + complete + "\t" + love + "\t" + content + "\t\t"
						+ type + "\t" + time);
				System.out.println();
			}

		}

		System.out.println("###找到包含\"" + msg + "\"的共有" + count + "条数据###");
		System.out.print("输入任意内容后返回:");
		scanner.next();

	}

	/**
	 * findNote 查找笔记模块
	 * 
	 * @输出 查找到的内容
	 */
	public static void findNote() {
		if (data.size() == 0) {
			System.out.println("\t###无记录可操作###");
			System.out.print("输入任意内容后返回:");
			scanner.next();
			return;
		}
		showFindMenu();
		int choose = -1;
		while (true) {
			showNote(false);
			System.out.print("请选择:");
			choose = scanner.nextInt();

			if (choose == 4) {
				return;
			}
			if (choose == 1) {
				System.out.print("请输入查找的id:");
				String id = scanner.next();
				findNoteId(id);
				break;
			}
			if (choose == 2) {
				System.out.print("请输入查找的标题:");
				String title = scanner.next();
				findNoteTitle(title);
				break;
			}
			if (choose == 3) {
				System.out.print("请输入想查询的信息:");
				String msg = scanner.next();
				findNoteMsg(msg);
				break;
			}
		}

	}

	/**
	 * @actionNote 笔记操作模块
	 */
	public static void actionNote() {

		if (data.size() == 0) {
			System.out.println("\t###无记录可操作###");
			System.out.print("输入任意内容后返回:");
			scanner.next();
			return;
		}
		showActionMenu();
		int choose = -1;
		while (true) {
			showNote(false);
			System.out.print("请选择:");
			choose = scanner.nextInt();

			if (choose == 4) {
				return;
			}
			if (choose == 1) {
				System.out.print("请输入修改的id:");
				String id = scanner.next();
				editNote(id);
				break;
			}
			if (choose == 2) {
				System.out.print("请输入删除的id:");
				String id = scanner.next();
				deleteNote(id);
				break;
			}
			if (choose == 3) {
				System.out.print("请输入复制的id:");
				String id = scanner.next();
				copyedNote(id);
				break;
			}
		}
	}

	/**
	 * @getTime 取当前时间
	 * @return 当前时间字符串，如 2020-03-20 13:00
	 */
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		return sdf.format(date);
	}

	/**
	 * @isInData id是否在数据中存在
	 * @param id 笔记id
	 * @return 返回 true 或 false
	 */
	public static boolean isInData(String id) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).get(COLUMN_ID).equals(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @copyedNote 根据id复制笔记功能
	 * @param id 笔记id
	 */
	public static void copyedNote(String id) {
		getAllMetaData();
		if (!isInData(id)) {
			System.out.println("###序号id不合法###");
		} else {
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).get(COLUMN_ID).equals(id)) {
					Map<String, String> map = data.get(i);
					map.put(COLUMN_TIME, getTime());
					map.put(COLUMN_ID, createId());
					String sql = "insert into " + TABLE_NAME + " values(?,?,?,?,?,?,?);";
					try {
						ppstatement = conn.prepareStatement(sql);
						ppstatement.setString(1, map.get(COLUMN_ID));
						ppstatement.setString(2, map.get(COLUMN_TITLE));
						ppstatement.setString(3, map.get(COLUMN_CONTENT));
						ppstatement.setString(4, map.get(COLUMN_TODO));
						ppstatement.setString(5, map.get(COLUMN_LOVE));
						ppstatement.setString(6, map.get(COLUMN_TYPE));
						ppstatement.setString(7, map.get(COLUMN_TIME));
						int status = ppstatement.executeUpdate();
						if (status > 0) {
							data.add(map);
							System.out.println("###复制成功###");
						} else {
							System.out.println("###复制失败###");
						}
						System.out.println();
					} catch (SQLException e) {
						System.out.println("###复制失败###");
					}

					return;
				}
			}

		}
	}

	/**
	 * @editNote 根据笔记id修改笔记
	 * @param id
	 */
	public static void editNote(String id) {
		getAllMetaData();
		if (!isInData(id)) {
			System.out.println("###序列id不合法###");
		} else {
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).get(COLUMN_ID).equals(id)) {
					Map<String, String> map = data.get(i);
					System.out.println("###注意：输入no不修改，输入其他则视为修改###");
					System.out.print("正在修改标题[" + map.get(COLUMN_TITLE) + "]:");
					String title = scanner.next();
					System.out.print("正在修改内容[" + map.get(COLUMN_CONTENT) + "]:");
					String content = scanner.next();
					System.out.print("正在修改分类[" + map.get(COLUMN_TYPE) + "]:");
					String type = scanner.next();
					System.out.print("正在修改代办:T已办 或  F待办");
					String complete = scanner.next();
					System.out.print("正在修改收藏:T收藏 或  F不收藏");
					String love = scanner.next();

					if (!title.equals("no")) {
						map.put(COLUMN_TITLE, title);
					}
					if (!content.equals("no")) {
						map.put(COLUMN_CONTENT, content);
					}
					if (!type.equals("no")) {
						map.put(COLUMN_TYPE, type);
					}
					if (!complete.equals("no")) {
						if (complete.equals("T") || complete.equals("t")) {
							map.put(COLUMN_TODO, "1");
							complete = "1";
						} else if (complete.equals("F") || complete.equals("f")) {
							map.put(COLUMN_TODO, "0");
							complete = "0";
						}
					}
					if (!love.equals("no")) {
						if (love.equals("T") || love.equals("t")) {
							map.put(COLUMN_LOVE, "1");
							love = "1";
						} else if (love.equals("F") || love.equals("f")) {
							map.put(COLUMN_LOVE, "0");
							love = "1";
						}
					}
					map.put(COLUMN_TIME, getTime());
					data.set(i, map);
					String sql = "update " + TABLE_NAME + " set " + COLUMN_TITLE + " = ?," + COLUMN_CONTENT + " = ?,"
							+ COLUMN_TYPE + " = ?," + COLUMN_TODO + " = ?," + COLUMN_LOVE + "=?," + COLUMN_TIME
							+ " = ? where " + COLUMN_ID + " = ?;";
					try {
						ppstatement = conn.prepareStatement(sql);
						ppstatement.setString(1, title);
						ppstatement.setString(2, content);
						ppstatement.setString(3, type);
						ppstatement.setString(4, complete);
						ppstatement.setString(5, love);
						ppstatement.setString(6, getTime());
						ppstatement.setString(7, id);
						int status = ppstatement.executeUpdate();
						System.out.println();
						System.out.println();
						if (status > 0) {
							System.out.println("###修改完成###");
						} else {
							System.out.println("###修改失败###");
						}

					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("###修改失败###");
					}

					return;
				}
			}

		}
	}

	/**
	 * @deleteNote 根据笔记id删除笔记
	 * @param id
	 */
	public static void deleteNote(String id) {
		if (!isInData(id)) {
			System.out.println("###序号id不合法###");
		} else {
			String sql = "delete from " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
			try {
				ppstatement = conn.prepareStatement(sql);
				ppstatement.setString(1, id);
				int status = ppstatement.executeUpdate();
				if (status > 0) {
					System.out.println("###删除成功###");
				} else {
					System.out.println("###删除失败###");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("###删除失败###");
			}
		}

	}

	/**
	 * @getAllMetaData 取出所有数据
	 */
	public static void getAllMetaData() {
		try {
			data.clear();
			ppstatement = conn.prepareStatement("select * from " + TABLE_NAME);
			resultSet = ppstatement.executeQuery();
			while (resultSet.next()) {
				Map<String, String> map = new HashMap<>();
				map.put(COLUMN_ID, resultSet.getString(COLUMN_ID));
				map.put(COLUMN_TITLE, resultSet.getString(COLUMN_TITLE));
				map.put(COLUMN_CONTENT, resultSet.getString(COLUMN_CONTENT));
				map.put(COLUMN_TODO, resultSet.getString(COLUMN_TODO));
				map.put(COLUMN_LOVE, resultSet.getString(COLUMN_LOVE));
				map.put(COLUMN_TYPE, resultSet.getString(COLUMN_TYPE));
				map.put(COLUMN_TIME, resultSet.getString(COLUMN_TIME));
				data.add(map);
			}
		} catch (SQLException e) {
		}
	}

	public static boolean hasId(String id) {
		getAllMetaData();
		if (data.size() == 0) {
			return false;
		}
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).get(COLUMN_ID).equals(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * showNote 展示所有笔记
	 * 
	 * @param show 为true时展示是否查看操作，为false时不展示
	 */
	public static void showNote(boolean show) {
		getAllMetaData();
		System.out.println();
		System.out.println("笔记(" + data.size() + ")");
		System.out.println("\t序号\t标题\t\t待办\t收藏\t内容\t分类\t最后修改时间");
		if (data.size() == 0) {
			System.out.println("\t无记录可查");
			System.out.print("输入任意内容后返回:");
			scanner.next();
			return;
		}
		for (int i = 0; i < data.size(); i++) {
			Map<String, String> map = data.get(i);
			String id = map.get(COLUMN_ID);
			String title = map.get(COLUMN_TITLE);
			String content = map.get(COLUMN_CONTENT);
			String complete = map.get(COLUMN_TODO).equals("1") ? "✔" : "□";
			String love = map.get(COLUMN_LOVE).equals("1") ? "♥" : "♡";
			String type = map.get(COLUMN_TYPE);
			String time = map.get(COLUMN_TIME);
			if (title.length() > 5) {
				title = title.substring(0, 5) + "...";
			}
			if (content.length() > 5) {
				content = content.substring(0, 5) + "...";
			}
			System.out.print("\t" + id + "\t" + title + "\t\t" + complete + "\t" + love + "\t" + content + "\t\t" + type
					+ "\t" + time);
			System.out.println();
		}
		if (show) {
			System.out.print("输入ID查看内容，输入0后返回:");
			String res = scanner.next();
			if (res.equals("0")) {
				return;
			} else {
				boolean find = false;
				for (int i = 0; i < data.size(); i++) {
					Map<String, String> map = data.get(i);
					String id = map.get(COLUMN_ID);
					if (id.equals(res)) {
						find = true;
						String title = map.get(COLUMN_TITLE);
						String content = map.get(COLUMN_CONTENT);
						System.out.println("###标题：" + title);
						System.out.println("###内容：" + content);
					} else {
						continue;
					}
				}
				if (!find) {
					System.out.println("###未找到此条信息###");
				}
			}
			System.out.print("###输入任意信息返回###");
			scanner.next();
			return;
		}

	}

	/**
	 * @createId 创建随机6位ID
	 * @return 返回ID字符串
	 */
	public static String createId() {
		String base = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		if (hasId(sb.toString())) {
			createId();
		}
		return sb.toString();
	}

	/**
	 * @createNote 创建新笔记
	 * 
	 */
	public static void createNote() {
		System.out.print("请输入标题：");
		String title = scanner.next();
		System.out.print("请输入内容：");
		String content = scanner.next();
		String id = createId();
		String time = getTime();
		String sql = "insert into " + TABLE_NAME + " values(?,?,?,?,?,?,?);";

		try {
			ppstatement = conn.prepareStatement(sql);
			ppstatement.setString(1, id);
			ppstatement.setString(2, title);
			ppstatement.setString(3, content);
			ppstatement.setString(4, "0");
			ppstatement.setString(5, "0");
			ppstatement.setString(6, "默认");
			ppstatement.setString(7, time);
			int status = ppstatement.executeUpdate();
			if (status > 0) {
				System.out.println("###提示：创建成功###");
			} else {
				System.out.println("###创建失败###");
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("###创建失败###");
		}

	}
}
