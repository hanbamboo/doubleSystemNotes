package test;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TTT {
	final String[] name = { "段  慧", "于龙慧", "余焕冬", "秦会松", "李思阳", "吴晓慧", "王文龙", "李俊涛", "秦浩轩", "李雪亮", "杨鹏飞", "曲程锦", "陈凤林",
			"刘秋丽", "马庆鹏", "亓玉帆", "曾永智", "徐东浩", "马金龙", "邢金涛", "杨际乾", "张迎鑫", "赵建龙", "刘志远", "王  鹏", "王文峰", "白建新", "韩光昌",
			"李运祥", "王道凯", "李  爽", "刘建岭","任龙生老师" };

	public static void main(String[] args) {

		JFrame title = new JFrame("抽签小程序");
		JLabel label = new JLabel();
		JButton button = new JButton("开始抽签");
		final JTextField textField = new JTextField();
		final JLabel label2 = new JLabel(); 
		title.setSize(500, 360);
		title.setLocation(200, 200);
		title.setLayout(new FlowLayout());
		textField.setPreferredSize(new Dimension(150, 40));
		
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String text = textField.getText();
				int num = Integer.parseInt(text);
				String[] res = new String[num];

				if (text.equals("") || text == null) {
					JOptionPane.showMessageDialog(null, "输入错误");
				} else {
					JOptionPane.showMessageDialog(null, "获奖的号码为\n" + text + "所以您没有中奖");

				}
			}
		});
		label2.setLocation(500, 500);
		label2.setText("222");
		title.add(label);
		title.add(label2);

		title.add(textField);
		title.add(button);
		title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		title.setVisible(true);
	}
}