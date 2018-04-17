package util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;

/**
 * http请求
 */
@Slf4j
public class HttpUtil {

    public static String sendRequest(String url, String reqParam) throws Exception {
        HttpClient httpClient = new HttpClient();

        PostMethod method = new PostMethod(url);

        method.getParams().setParameter("http.protocol.content-charset", "UTF-8");
        method.addRequestHeader("http.protocol.content-charset", "UTF-8");

        StringRequestEntity entity = new StringRequestEntity(reqParam);

        method.setRequestEntity(entity);

        httpClient.executeMethod(method);

        String respResult = method.getResponseBodyAsString();

        method.releaseConnection();

        return respResult;
    }

    /**
     * 向指定URL发送GET方法的请求
     */
    public static String get(String url) {
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "GBK");
            in = new BufferedReader(isr);

            int length = -1 ;
            char[] buffer = new char[1024];
            StringBuffer sb = new StringBuffer();
            while((length = isr.read(buffer, 0, 1024) ) != -1){
                sb.append(buffer,0,length);
            }
//            data = new String(sb);

//            String line;
//            while ((line = in.readLine()) != null) {
//                sb.append(line);
//            }
            return new String(sb);
        } catch (Exception e) {
            log.error("Exception occur when send http get request!", e);
        } finally {// 使用finally块来关闭输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] a) throws Exception {
        String url = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query={0}&co=&resource_id=6004&t=1522660867271&ie=utf8&oe=gbk&cb=op_aladdin_callback&format=json&tn=baidu&cb=jQuery1102039513342791514106_1522660830766&_=1522660830773";
        url = MessageFormat.format(url, "18080918481");
        String retStr = get(url);
        retStr = new String(retStr.getBytes("ISO-8859-1"), "GBK");
        retStr = retStr.substring(retStr.indexOf("{"), retStr.lastIndexOf("}") + 1);
        JSONObject retData = (JSONObject) JSONObject.parseObject(retStr).getJSONArray("data").get(0);
        for (String str : retData.keySet()) {
            System.err.println(str + "=" + retData.get(str));
        }
    }
}
