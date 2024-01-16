package com.shuangti.dqnote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 
 * @笔记管理系统 具有增删查改的基本功能
 *
 */
public class NoteSysClass2 {
	// 具体笔记数据，用于储存
	static ArrayList<Note> noteData = new ArrayList<Note>();

	// 具体id数据，用于判断是否重复
	static ArrayList<String> idList = new ArrayList<String>();
	// 输入流和日历类
	static Scanner scanner = new Scanner(System.in);
	static Calendar calendar = new GregorianCalendar();

	public static void main(String[] args) {

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
		if (noteData.size() == 0) {
			System.out.println("\t###无记录可操作###");
			System.out.print("输入任意内容后返回:");
			scanner.next();
			return;
		}
		System.out.print("请输入分类名：");
		String ac = scanner.next();
		System.out.println("\t序列\t标题\t\t待办\t收藏\t内容\t分类\t最后修改时间");
		int count = 0;
		for (int i = 0; i < noteData.size(); i++) {
			if (noteData.get(i).getType().equals(ac)) {
				count++;
				String title = noteData.get(i).getTitle();
				if (title.length() > 5) {
					title = title.substring(0, 5) + "...";
				}
				String content = noteData.get(i).getContent();
				if (content.length() > 5) {
					content = content.substring(0, 5) + "...";
				}
				String complete = noteData.get(i).isComplete() == true ? "✔" : "□";
				String love = noteData.get(i).isLove() == true ? "♥" : "♡";
				System.out.print("\t" + noteData.get(i).getId() + "\t" + title + "\t\t" + complete + "\t" + love + "\t"
						+ content + "\t" + noteData.get(i).getType() + "\t" + noteData.get(i).getEditTime());
				System.out.println();
			}

		}

		System.out.println("###找到包含\"" + ac + "\"的共有" + count + "条数据###");
		System.out.print("输入任意内容后返回:");
		scanner.next();

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
			for (int i = 0; i < noteData.size(); i++) {
				if (noteData.get(i).getId().equals(id)) {
					count++;
					String title = noteData.get(i).getTitle();
					if (title.length() > 5) {
						title = title.substring(0, 5) + "...";
					}
					String content = noteData.get(i).getContent();
					if (content.length() > 5) {
						content = content.substring(0, 5) + "...";
					}
					String complete = noteData.get(i).isComplete() == true ? "✔" : "□";
					String love = noteData.get(i).isLove() == true ? "♥" : "♡";
					System.out.print("\t" + noteData.get(i).getId() + "\t" + title + "\t\t" + complete + "\t" + love
							+ "\t" + content + "\t" + noteData.get(i).getType() + "\t" + noteData.get(i).getEditTime());
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
		System.out.println("\t序列\t标题\t\t待办\t收藏\t内容\t分类\t最后修改时间");
		int count = 0;
		for (int i = 0; i < noteData.size(); i++) {
			if (noteData.get(i).getTitle().contains(titleFind)) {
				count++;
				String title = noteData.get(i).getTitle();
				if (title.length() > 5) {
					title = title.substring(0, 5) + "...";
				}
				String content = noteData.get(i).getContent();
				if (content.length() > 5) {
					content = content.substring(0, 5) + "...";
				}
				String complete = noteData.get(i).isComplete() == true ? "✔" : "□";
				String love = noteData.get(i).isLove() == true ? "♥" : "♡";
				System.out.print("\t" + noteData.get(i).getId() + "\t" + title + "\t\t" + complete + "\t" + love + "\t"
						+ content + "\t" + noteData.get(i).getType() + "\t" + noteData.get(i).getEditTime());
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
		for (int i = 0; i < noteData.size(); i++) {
			if (noteData.get(i).getTitle().contains(msg) || noteData.get(i).getId().contains(msg)
					|| noteData.get(i).getContent().contains(msg) || noteData.get(i).getType().contains(msg)) {
				count++;
				String title = noteData.get(i).getTitle();
				if (title.length() > 5) {
					title = title.substring(0, 5) + "...";
				}
				String content = noteData.get(i).getContent();
				if (content.length() > 5) {
					content = content.substring(0, 5) + "...";
				}
				String complete = noteData.get(i).isComplete() == true ? "✔" : "□";
				String love = noteData.get(i).isLove() == true ? "♥" : "♡";
				System.out.print("\t" + noteData.get(i).getId() + "\t" + title + "\t\t" + complete + "\t" + love + "\t"
						+ content + "\t" + noteData.get(i).getType() + "\t" + noteData.get(i).getEditTime());
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
		if (noteData.size() == 0) {
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

		if (noteData.size() == 0) {
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
	 * @return 当前时间字符串，如 2020-3-20 13:00
	 */
	public static String getTime() {
		return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":"
				+ calendar.get(Calendar.MINUTE);
	}

	/**
	 * @isInData id是否在数据中存在
	 * @param id 笔记id
	 * @return 返回 true 或 false
	 */
	public static boolean isInData(String id) {
		for (int i = 0; i < noteData.size(); i++) {
			if (noteData.get(i).getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @getIdInData 取数据中id当前的位置
	 * @param id 笔记id
	 * @return 返回位置，无则返回-1
	 */
	public static int getIdInData(String id) {
		for (int i = 0; i < noteData.size(); i++) {
			if (noteData.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @copyedNote 根据id复制笔记功能
	 * @param id 笔记id
	 */
	public static void copyedNote(String id) {
		if (!isInData(id)) {
			System.out.println("###序号id不合法###");
		} else {

			Note note_copyed = noteData.get(getIdInData(id));
			Note note_new = new Note();
			String idCreate = createId();
			note_new.setId(idCreate);
			note_new.setTitle(note_copyed.getTitle());
			note_new.setContent(note_copyed.getContent());
			note_new.setComplete(note_copyed.isComplete());
			note_new.setLove(note_copyed.isLove());
			note_new.setType(note_copyed.getType());
			note_new.setEditTime(getTime());
			noteData.add(note_new);
			idList.add(idCreate);
			System.out.println("###复制成功###");

		}
	}

	/**
	 * @editNote 根据笔记id修改笔记
	 * @param id
	 */
	public static void editNote(String id) {
		if (!isInData(id)) {
			System.out.println("###序列id不合法###");
		} else {
			Note note = noteData.get(getIdInData(id));
			System.out.println("###注意：输入no不修改，输入其他则视为修改###");
			System.out.print("正在修改标题[" + note.getTitle() + "]:");
			String title = scanner.next();
			System.out.print("正在修改内容[" + note.getContent() + "]:");
			String content = scanner.next();
			System.out.print("正在修改分类[" + note.getType() + "]:");
			String type = scanner.next();
			System.out.print("正在修改代办:T已办 或  F待办");
			String complete = scanner.next();
			System.out.print("正在修改收藏:T收藏 或  F不收藏");
			String love = scanner.next();

			if (!title.equals("no")) {
				note.setTitle(title);
			}
			if (!content.equals("no")) {
				note.setContent(content);
			}
			if (!type.equals("no")) {
				note.setType(type);
			}
			if (!complete.equals("no")) {
				if (complete.equals("T") || complete.equals("t")) {
					note.setComplete(true);
				} else if (complete.equals("F") || complete.equals("f")) {
					note.setComplete(false);
				}
			}
			if (!love.equals("no")) {
				if (love.equals("T") || love.equals("t")) {
					note.setLove(true);
				} else if (love.equals("F") || love.equals("f")) {
					note.setLove(false);
				}
			}
			note.setEditTime(getTime());
			System.out.println();
			System.out.println("###修改完成###");
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
			for (int i = 0; i < noteData.size(); i++) {
				if (noteData.get(i).getId().equals(id)) {
					noteData.remove(i);
					removeId(id);
					System.out.println("###删除成功###");
				}
			}
		}

	}

	/**
	 * @deleteNote 删除记录
	 * @param id
	 */
	public static void removeId(String id) {
		for (int i = 0; i < idList.size(); i++) {
			if (idList.get(i).equals(id)) {
				idList.remove(i);
			}
		}
	}

	/**
	 * showNote 展示所有笔记
	 * 
	 * @param show 为true时展示是否查看操作，为false时不展示
	 */
	public static void showNote(boolean show) {
		System.out.println();
		System.out.println("笔记(" + noteData.size() + ")");
		System.out.println("\t序号\t标题\t\t待办\t收藏\t内容\t分类\t最后修改时间");
		if (noteData.size() == 0) {
			System.out.println("\t无记录可查");
			System.out.print("输入任意内容后返回:");
			scanner.next();
			return;
		}

		for (int i = 0; i < noteData.size(); i++) {
			if (noteData.get(i) != null) {
				String title = noteData.get(i).getTitle();
				if (title.length() > 5) {
					title = title.substring(0, 5) + "...";
				}
				String content = noteData.get(i).getContent();
				if (content.length() > 5) {
					content = content.substring(0, 5) + "...";
				}
				String complete = noteData.get(i).isComplete() == true ? "✔" : "□";
				String love = noteData.get(i).isLove() == true ? "♥" : "♡";
				System.out.print("\t" + noteData.get(i).getId() + "\t" + title + "\t\t" + complete + "\t" + love + "\t"
						+ content + "\t" + noteData.get(i).getType() + "\t" + noteData.get(i).getEditTime());
				System.out.println();

			} else {
				break;
			}
		}
		if (show) {
			System.out.print("输入ID查看内容，输入0后返回:");
			String res = scanner.next();
			if (res.equals("0")) {
				return;
			} else {
				boolean find = false;
				for (int i = 0; i < noteData.size(); i++) {
					if (noteData.get(i).getId().equals(res)) {
						System.out.println("###标题：" + noteData.get(i).getTitle());
						System.out.println("###内容：" + noteData.get(i).getContent());
						find = true;
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
		for (int i = 0; i < idList.size(); i++) {
			if (idList.get(i).equals(sb.toString())) {
				createId();
			}
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
		Note note = new Note();
		String id = createId();
		String time = getTime();

		note.createNote(id, title, content, false, false, time, "默认");
		noteData.add(note);
		idList.add(id);
		System.out.println("###提示：创建成功###");
		System.out.println();

	}
}
