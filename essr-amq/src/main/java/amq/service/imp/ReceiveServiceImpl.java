package amq.service.imp;

import amq.util.JmsConfig;
import amq.webSocket.WebsocketServer;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/22.
 */
@Service
public class ReceiveServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(ReceiveServiceImpl.class);

    @Autowired
    WebsocketServer websocket;

    @JmsListener(destination = "ticop_mq")
    public void receiveMessage(String msg) throws JMSException {
        log.info("接收到的消息：--------"+msg);
        Map<String,Object> map = JSON.parseObject(msg);
        log.info("接收到的消息：--------"+map);
        String message = String.valueOf(map.get("message"));
        String userid = String.valueOf(map.get("userid"));
        log.info(message+":---------------------------"+userid);
        websocket.sendMessage(message,userid);
    }

    //@JmsListener(destination = JmsConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
    public void onTopicMessage(String msg) {
        log.info("接收到的消息aaaa：--------"+msg);
        Map<String,Object> map = JSON.parseObject(msg);
        log.info("接收到的消息aaaaaa：--------"+map);
        String message = String.valueOf(map.get("message"));
        String userid = String.valueOf(map.get("userid"));
        log.info(message+":---aaaaaaaaaaa------------------------"+userid);
        websocket.sendMessage(message,userid);
    }

    @JmsListener(destination = JmsConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage(String msg) {
        log.info("接收到的消息：--------"+msg);
        Map<String,Object> map = JSON.parseObject(msg);
        log.info("接收到的消息：--------"+map);
        String message = String.valueOf(map.get("message"));
        String userid = String.valueOf(map.get("userid"));
        log.info(message+":---------------------------"+userid);
        websocket.sendAll(message);
    }
}
