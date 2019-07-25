package eley.controller;

import eley.service.GetRunInfoService;
import eley.service.SendMessage;
import eley.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Created by Administrator on 2019/7/16.
 */
@RestController
@RequestMapping("/eley")
public class GetRunInfo {
    private static final Logger log = LoggerFactory.getLogger(GetRunInfo.class);
    @Autowired
    GetRunInfoService service;

    @Autowired
    SendMessage message;

    @Autowired
    RedisUtil redis;

    @RequestMapping("/get")
    @ResponseBody
    public List get(@RequestBody Map param){
        //List list = JSOnO
        log.info(param.get("name")+"");
        List list = (List) param.get("name");
        Map map = (Map) list.get(2);
        map.put("value",4255);
        return list;
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(@RequestBody Map map){
        message.addMessage(map);
    }

    @RequestMapping("/getInfo")
    @ResponseBody
    public List getInfo(){
        redis.set("name","899999999");
        return service.get();
    }
}
