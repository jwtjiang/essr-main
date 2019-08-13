package eley.service;

import java.util.Map;

/**
 * Created by Administrator on 2019/7/29.
 */
public interface EleyService {

    void insert();

    /**
     * 获取系统全部信息
     * @return
     */
    Map getAllInfo();

    /**
     * 获取区域划分信息
     * @return
     */
    Map getPartitionInfo();

    /**
     * 获取分区拓扑信息
     * @return
     */
    Map getTopologyInfo();

    /**
     * 获取分区边界点信息
     * @return
     */
    Map getBoundaryInfo();

    /**
     * 获取分区负荷值与发电量统计信息
     * @return
     */
    Map getItatisticsInfo();

    /**
     * 获取分区发用电平衡监视信息
     * @return
     */
    Map getMonitorInfo();

    /**
     * 获取分区热备用信息信息
     * @return
     */
    Map getSpareInfo();

    /**
     *获取一次分区转负荷信息
     * @return
     */
    Map getOneInfo();

    /**
     * 获取二次分区转负荷信息
     * @return
     */
    Map getTwoInfo();

    /**
     * 获取平衡交叉点及告警信息
     * @return
     */
    Map getIntersectionInfo();
}
