package amq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * Created by Administrator on 2019/7/22.
 */
@Component
public class JMSProducer {

    @Autowired

    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, Object obj) {
        jmsMessagingTemplate.convertAndSend(destination,obj);
    }
}
