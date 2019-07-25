package eley.service.imp;

import eley.service.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 放到ioc
 * Created by Administrator on 2019/7/22.
 */
@Component
public class SendMessageImp implements SendMessage {
    private static final Logger log = LoggerFactory.getLogger(SendMessageImp.class);
    @Override
    public void addMessage(Map map) {
        log.info("我是熔断器起作用了----------------------------------------------");
    }
}
