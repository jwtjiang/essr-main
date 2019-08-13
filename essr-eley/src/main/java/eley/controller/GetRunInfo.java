package eley.controller;

import eley.service.GetRunInfoService;
import eley.service.SendMessage;
import eley.util.HttpPostClient;
import eley.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


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

//    @RequestMapping("/add")
//    @ResponseBody
//    public void add(@RequestBody Map map){
//        message.addMessage(map);
//    }

    @RequestMapping("/getInfo")
    @ResponseBody
    public List getInfo(){
        redis.set("name","899999999");
        return service.get();
    }

    @RequestMapping("/httpClientInfo")
    @ResponseBody
    public String httpClientInfo(){
//        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//        System.out.println(names);
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });
//        System.out.println(names);
        HttpPostClient c = new HttpPostClient();
        return c.sendString("http://localhost:8084/test/test1","我来了");
    }
}
