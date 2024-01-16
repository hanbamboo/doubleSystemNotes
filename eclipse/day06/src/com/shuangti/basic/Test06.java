package com.shuangti.basic;

public class Test06 {
	public static void main(String[] args) {
		String s = "这些年一个人风也过雨也走有过泪有过错真爱过才会懂会寂寞会回首终有梦终有你在心中朋友一生一起走那些日子不再有一句话一辈子一生情一杯酒朋友不曾孤单过一声朋友你会懂还有伤还有痛还要走还有我这些年一个人风也过雨也走有过泪有过错还记得坚持什么真爱过才会懂会寂寞会回首终有梦终有你在心中朋友一生一起走那些日子不再有一句话一辈子一生情一杯酒朋友不曾孤单过一声朋友你会懂还有伤还有痛还要走还有我朋友一生一起走那些日子不再有一句话一辈子一生情一杯酒朋友不曾孤单过一声朋友你会懂还有伤还有痛还要走还有我朋友一生一起走那些日子不再有一句话一辈子一生情一杯酒朋友不曾孤单过一声朋友你会懂还有伤还有痛还要走还有我一句话一辈子一生情一杯酒";
		int count = 0;
		
//		for (int i = 0; i < s.length(); i++) {
//			int index = s.lastIndexOf("朋友");
//			if (index==0) {
//				continue;
//			}else {
//				s = s.substring(5, index);
//				System.out.println(s);
//				count++;
//			}	
//		}
//		
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '朋' && s.charAt(i + 1) == '友') {
				count++;
			}
		}
		System.out.println(count);

	}
}
