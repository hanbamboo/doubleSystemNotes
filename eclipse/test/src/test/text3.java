package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class text3 {
public static void main(String[] args) {
        
        Map<String,Object> map = new HashMap<>(3);
        map.put("name","С��");
        map.put("sex","n@?@");
        map.put("age","16");
        //MapתString
        System.out.println("map"+map);
        String str1 = getMapToString(map);
        System.out.println("::"+str1);
        try {
           //Stringתmap
           Map<String, Object> map1 = getStringToMap(str1);
           System.out.println(map1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
    *
    * MapתString
    * @param map
    * @return
    */
   public static String getMapToString(Map<String,Object> map){
       Set<String> keySet = map.keySet();
       //��set����ת��Ϊ����
       String[] keyArray = keySet.toArray(new String[keySet.size()]);
       //����������(����)
       Arrays.sort(keyArray);
       //��ΪStringƴ��Ч�ʻ�ܵ͵ģ�����ת��StringBuilder
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < keyArray.length; i++) {
           // ����ֵΪ�գ��򲻲���ǩ�� �������trim()��ȥ�ո�
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
    * Stringתmap
    * @param str
    * @return
    */
   public static Map<String,Object> getStringToMap(String str){
       //���ݶ��Ž�ȡ�ַ�������
       String[] str1 = str.split("!@");
       //����Map����
       Map<String,Object> map = new HashMap<>();
       //ѭ������map����
       for (int i = 0; i < str1.length; i++) {
           //����":"��ȡ�ַ�������
           String[] str2 = str1[i].split("@@");
           System.out.println("ddd"+str2[1]);
   
           //str2[0]ΪKEY,str2[1]Ϊֵ
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