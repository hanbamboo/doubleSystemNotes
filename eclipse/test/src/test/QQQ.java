package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QQQ {
	public static void main(String[] args) {
		Map map = new HashMap();

		map.put(1, 1);
		map.put(3, "fafs");
		map.put("da", "ac");
		map.put(4, 2453645);

		Set<Object> set = map.keySet();
		for (Object key : set) {
			System.out.println(key + "  --  " + map.get(key));
		}
		set = map.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object + "  --  " + map.get(object));
		}
		
		Iterator<Object> keys = map.keySet().iterator();
		while (keys.hasNext()) {
			Object k = keys.next();
			System.out.println(k + " -- " + map.get(k));
		}
		
		Iterator<Map<Object,Object>> keeeey = map.entrySet().iterator();
		while (keeeey.hasNext()) {
			Map<Object, Object> map2 = (Map<java.lang.Object, java.lang.Object>) keeeey.next();
			System.out.println(map2);
		}

	}
}
