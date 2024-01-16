package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class text4 {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        //发送 GET 请求
//        String s=sendGet("https://tinywebdb.appinventor.space/webdb-mgusers-a46a5f05", "key=123&v=456");
//        System.out.println(s);
        String aString = "public_id=1234&upload_preset=mgupload&file=data:image/jpg;base64,data:image/jpg;base64,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";
        
        //发送 POST 请求
        String sr;
		try {
			sr = sendPost("https://api.cloudinary.com/v1_1/wfgmqhx/image/upload", URLEncoder.encode(aString, "UTF-8"));
			System.out.println(sr);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        String sr2=sendGet("http://tinywebdb.appinventor.space/api", "user=mgusers&secret=a46a5f05&action=get&tag=%E5%A5%A5%E7%89%B9%E6%9B%BC");
//        System.out.println(sr2);
    }
}