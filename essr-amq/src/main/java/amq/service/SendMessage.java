package amq.service;


/**
 * Created by Administrator on 2019/7/22.
 */
public interface SendMessage {
    /**
     *
     * @param destination 消息类型
     */
    void sendOneTypeMessage(String destination ,Object obj);

    /**
     *
     * @param obj 消息内容
     */
    void sendTwoTypeMessage(Object obj);

}
