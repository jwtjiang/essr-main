package eley.scheduled;

import eley.webSocket.WebsocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Administrator on 2019/7/29.
 */
@Component
public class EleyScheduled {
    private static  final Logger log = LoggerFactory.getLogger(EleyScheduled.class);

    @Autowired
    WebsocketServer websocketServer;

    @Scheduled(cron = "0 */1 * * * ?")
    public void first() throws IOException{
        log.info("-----------------五分钟间隔开始执行定时任务---------------------------");
        websocketServer.sendAll("定时任务信息");
        log.info("定时任务已发送信息------------------------------------------------");
    }
}
