package scheduled.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/8/1.
 */
@RequestMapping("/test")
@RestController
public class testCon {

    @RequestMapping("/test1")
    public String test(@RequestBody  String json){
        System.out.println("----------------------------------------aaaaaaaaaaaaaaaaaaaaaaaaaaaa---------------------------");
        System.out.println(json);
        return json;
    }
}
