package eley.service.imp;

import eley.activeMQ.JMSProducer;
import eley.service.SendMessage;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Map;

/**
 * 放到ioc
 * Created by Administrator on 2019/7/22.
 */
@Component
public class SendMessageImp implements SendMessage {
    private static final Logger log = LoggerFactory.getLogger(SendMessageImp.class);
    @Autowired
    private JMSProducer jmsProducer;
    @Autowired
    private Topic topic;
    @Autowired
    private Queue queue;

    @Override
    public void addMessage(Map map) {
        log.info("我是熔断器起作用了----------------------------------------------");
    }

    @Override
    public void sendOneTypeMessage(String destination, Object obj) {
        Destination destinationType = new ActiveMQTopic(destination);
        jmsProducer.sendMessage(destinationType,String.valueOf(obj));
    }

    @Override
    public void sendTwoTypeMessage( Object obj) {
        jmsProducer.sendMessage(topic,obj);
        jmsProducer.sendMessage(queue,obj);
    }
}
