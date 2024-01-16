package test;

import java.util.Scanner;

public class FlowerTest {
	public static void main(String[] args) {
		int index = 0;
		Flower[] flowerArr = new Flower[100];
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1.添加 2.查看收藏");
			int action = scanner.nextInt();
			if (action == 1) {
				System.out.print("输入一朵花");
				String name = scanner.next();
				System.out.print("是否收藏");
				int shoucang = scanner.nextInt();

				Flower huahua = new Flower();
				huahua.setId(index);
				huahua.setName(name);
				huahua.setShoucang(shoucang);
				flowerArr[index] = huahua;
				index++;

				System.out.println("添加成功");

			}
			if (action == 2) {
				System.out.println("\t名字\t是否收藏");
				for (Flower flower : flowerArr) {
					if (flower != null) {
						System.out.println("\t" + flower.getName() + "\t" + flower.getShoucang());
					}
				}
				System.out.println("以下是收藏的花花");
				for (Flower flower : flowerArr) {
					if (flower != null && flower.getShoucang() == 1) {
						System.out.println("\t" + flower.getName() + "\t" + flower.getShoucang());
					}
				}
			}

		}

	}
}
