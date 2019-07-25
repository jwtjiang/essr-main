package amq.webSocket;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2019/7/23.
 */
@ServerEndpoint(value = "/webSocket/{userid}")
@Component
public class WebsocketServer {

    private Session session;



    private static Map<String, Session> sessionPool = new ConcurrentHashMap<>();
    private static Map<String, String> sessionIds = new ConcurrentHashMap<>();

    /**
     * 用户连接时触发
     *
     * @param session session
     * @param userid  userid
     */
    @OnOpen
    public void open(Session session, @PathParam(value = "userid") String userid) {
        this.session = session;
        String id = session.getId();
        Map<String, Object> userProperties = session.getUserProperties();
        if (userProperties.size() > 0) {
            Set<Map.Entry<String, Object>> entries = userProperties.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                System.out.println(entry.getKey() + "----" + entry.getValue());
            }
        }
        System.out.println("id----->  " + id);
        sessionPool.put(userid, session);
        sessionIds.put(session.getId(), userid);
        System.out.println("当前在线人数  " + getOnlineNum());
        System.out.println(sessionIds);
    }

    /**
     * 收到信息时触发
     *
     * @param message message
     */
    @OnMessage
    public void onMessage(String message) {
        System.out.println("当前发送人sessionid为" + session.getId() + "发送内容为" + message);
    }

    /**
     * 连接关闭触发
     */
    @OnClose
    public void onClose() {
        sessionPool.remove(sessionIds.get(session.getId()));
        sessionIds.remove(session.getId());
        System.out.println(sessionIds);
    }

    /**
     * 发生错误时触发
     *
     * @param session session
     * @param error   error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 信息发送的方法
     *
     * @param message message
     * @param userId  userId
     */
    public void sendMessage(String message, String userId) {
        Session s = sessionPool.get(userId);
        //Session s = redisUtil.get(userId);
        if (s != null) {
            s.getAsyncRemote().sendText(message);
            System.out.println("已经接收到消息"+message);
        }
    }
    public void send (String msg){
        if(session!=null){
            session.getAsyncRemote().sendText(msg);
        }else{
            System.out.println("session失效了");
        }
        System.out.println("发送了");
    }
    /**
     * 获取当前连接数
     *
     * @return int
     */
    public static int getOnlineNum() {
        return sessionPool.size();
    }

    /**
     * 获取在线用户名以---------隔开
     *
     * @return userId
     */
    public String getOnlineUsers() {
        StringBuilder users = new StringBuilder();
        for (String key : sessionIds.keySet()) {
            users.append(sessionIds.get(key)).append("---------");
        }
        return users.toString();
    }

    /**
     * 信息群发
     *
     * @param msg msg
     */
    public void sendAll(String msg) {
        for (String key : sessionIds.keySet()) {
            sendMessage(msg, sessionIds.get(key));
        }
    }

    /**
     * 多个人发送给指定的几个用户
     *
     * @param msg     msg
     * @param persons 用户数组
     */

    public void sendMany(String msg, String[] persons) {
        for (String userid : persons) {
            sendMessage(msg, userid);
        }

    }
}
