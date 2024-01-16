package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ZuoWeiHao {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < n; i++) {
			String[] msg = br.readLine().split(" ");
			String res = msg[0] + " " + msg[2];
			map.put(msg[1], res);
		}
		int m = Integer.parseInt(br.readLine());

		String[] list = br.readLine().split(" ");

		for (int i = 0; i < m; i++) {
			System.out.println(map.get(list[i]));
		}
	}
}
