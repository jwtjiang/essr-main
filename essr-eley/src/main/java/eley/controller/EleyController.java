package eley.controller;

import eley.service.EleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2019/7/29.
 */
@RestController
@RequestMapping("/eley")
public class EleyController {

    @Autowired
    EleyService service;

    /**
     * 获取系统全部信息
     * @return
     */
    @RequestMapping("/getAllInfo")
    public void getAllInfo(){
        service.insert();
    }

    /**
     * 获取区域划分信息
     * @return
     */
    @RequestMapping("/getPartitionInfo")
    public Map getPartitionInfo() {
        service.insert();
        return null;
    }

    /**
     * 获取分区拓扑信息
     * @return
     */
    @RequestMapping("/getTopologyInfo")
    public Map getTopologyInfo() {
        service.insert();
        return null;
    }

    /**
     * 获取分区边界点信息
     * @return
     */
    @RequestMapping("/getBoundaryInfo")
    public Map getBoundaryInfo() {
        service.insert();
        return null;
    }

    /**
     * 获取分区负荷值与发电量统计信息
     * @return
     */
    @RequestMapping("/getItatisticsInfo")
    public Map getItatisticsInfo() {
        service.insert();
        return null;
    }

    /**
     * 获取分区发用电平衡监视信息
     * @return
     */
    @RequestMapping("/getMonitorInfo")
    public Map getMonitorInfo() {
        service.insert();
        return null;
    }

    /**
     * 获取分区热备用信息信息
     * @return
     */
    @RequestMapping("/getSpareInfo")
    public Map getSpareInfo() {
        service.insert();
        return null;
    }

    /**
     * 获取一次分区转负荷信息
     * @return
     */
    @RequestMapping("/getOneInfo")
    public Map getOneInfo() {
        service.insert();
        return null;
    }

    /**
     * 获取二次分区转负荷信息
     * @return
     */
    @RequestMapping("/getTwoInfo")
    public Map getTwoInfo() {
        service.insert();
        return null;
    }

    /**
     * 获取平衡交叉点及告警信息
     * @return
     */
    @RequestMapping("/getIntersectionInfo")
    public Map getIntersectionInfo() {
        return null;
    }
}
