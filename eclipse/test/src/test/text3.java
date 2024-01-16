package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class text3 {
public static void main(String[] args) {
        
        Map<String,Object> map = new HashMap<>(3);
        map.put("name","小明");
        map.put("sex","n@?@");
        map.put("age","16");
        //Map转String
        System.out.println("map"+map);
        String str1 = getMapToString(map);
        System.out.println("::"+str1);
        try {
           //String转map
           Map<String, Object> map1 = getStringToMap(str1);
           System.out.println(map1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
    *
    * Map转String
    * @param map
    * @return
    */
   public static String getMapToString(Map<String,Object> map){
       Set<String> keySet = map.keySet();
       //将set集合转换为数组
       String[] keyArray = keySet.toArray(new String[keySet.size()]);
       //给数组排序(升序)
       Arrays.sort(keyArray);
       //因为String拼接效率会很低的，所以转用StringBuilder
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < keyArray.length; i++) {
           // 参数值为空，则不参与签名 这个方法trim()是去空格
           if ((String.valueOf(map.get(keyArray[i]))).trim().length() > 0) {
               sb.append(keyArray[i]).append("@@").append(String.valueOf(map.get(keyArray[i])).trim());
           }
           if(i != keyArray.length-1){
               sb.append("!@");
           }
       }
       return sb.delete(sb.length()-3,sb.length()).toString();
   }
   
   /**
    * 
    * String转map
    * @param str
    * @return
    */
   public static Map<String,Object> getStringToMap(String str){
       //根据逗号截取字符串数组
       String[] str1 = str.split("!@");
       //创建Map对象
       Map<String,Object> map = new HashMap<>();
       //循环加入map集合
       for (int i = 0; i < str1.length; i++) {
           //根据":"截取字符串数组
           String[] str2 = str1[i].split("@@");
           System.out.println("ddd"+str2[1]);
   
           //str2[0]为KEY,str2[1]为值
           //map.put(str2[0],str2[1]);
           if (str2.length == 2){
                map.put(str2[0].trim(),str2[1]);
            }else{
                map.put(str2[0].trim(),"");
            }
      } 
      return map; 
   } 
}