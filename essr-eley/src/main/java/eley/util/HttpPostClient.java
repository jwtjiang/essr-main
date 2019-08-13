package eley.util;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * Created by Administrator on 2019/8/1.
 */
public class HttpPostClient {

    /**
     * http方式调用其他外部接口
     * @param url
     * @param jsonString
     * @return
     */
    public String sendString(String url,String jsonString){
        String result = "0000";
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        try {
            StringEntity stringEntity = new StringEntity(jsonString,"application/json","utf-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json;charset=utf-8");
            post.addHeader("Contest-type","application/json;charset=utf-8");
            post.setHeader("Accept","application/json");
            post.setEntity(stringEntity);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                 result = EntityUtils.toString(res.getEntity());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
