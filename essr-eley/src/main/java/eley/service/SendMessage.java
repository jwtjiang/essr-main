package eley.service;

import eley.service.imp.SendMessageImp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Administrator on 2019/7/22.
 */
@FeignClient(value = "essr-amq",fallback = SendMessageImp.class)
public interface SendMessage {

    @RequestMapping(value = "/amq/addMessage",method = RequestMethod.POST)
    public void  addMessage(Map map);
}
