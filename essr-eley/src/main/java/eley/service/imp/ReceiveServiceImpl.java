package eley.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/22.
 */
@Service
public class ReceiveServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(GetRunInfoServiceImp.class);

    @JmsListener(destination = "ticop_mq")
    public void receiveMessage(String message) throws JMSException {
        System.out.println("收到：" + message);
    }


    @JmsListener(destination = "springboot.queue")
    public void onQueueMessage(String msg) {
        log.info("接收到的消息：--------"+msg);
    }
}
