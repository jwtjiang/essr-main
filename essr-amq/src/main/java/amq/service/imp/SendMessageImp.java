package amq.service.imp;

import amq.service.SendMessage;
import amq.util.JMSProducer;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;


/**
 * Created by Administrator on 2019/7/22.
 */
@Service
public class SendMessageImp implements SendMessage {

    @Autowired
    private JMSProducer jmsProducer;
    @Autowired
    private Topic topic;
    @Autowired
    private Queue queue;

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
