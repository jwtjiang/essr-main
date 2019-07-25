package amq.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2019/7/22.
 */
@RestController
@RequestMapping("/amq")
public class SendMessage {
    private static  final Logger log = LoggerFactory.getLogger(SendMessage.class);

    @Autowired
    amq.service.SendMessage message;

    @RequestMapping("/addMessage")
    public void addMessage(@RequestBody Map map){
        log.info("参数：----------"+map);
        String type = String.valueOf( map.get("type"))+"_mq";
        String msg = JSON.toJSONString(map);
        message.sendTwoTypeMessage(msg);
    }
}
