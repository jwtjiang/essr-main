package eley.service.imp;

import eley.dao.GetRunInfoDao;
import eley.service.EleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2019/7/29.
 */
@Service
public class EleyServiceImp implements EleyService {
    @Autowired
    GetRunInfoDao getRunInfodao;

    @Override
    public void insert() {
        getRunInfodao.insert();
    }

    /**
     * 获取系统全部信息
     * @return
     */
    @Override
    public Map getAllInfo() {
        return null;
    }

    /**
     * 获取区域划分信息
     * @return
     */
    @Override
    public Map getPartitionInfo() {
        return null;
    }
    /**
     * 获取分区拓扑信息
     * @return
     */
    @Override
    public Map getTopologyInfo() {
        return null;
    }

    /**
     * 获取分区边界点信息
     * @return
     */
    @Override
    public Map getBoundaryInfo() {
        return null;
    }

    /**
     * 获取分区负荷值与发电量统计信息
     * @return
     */
    @Override
    public Map getItatisticsInfo() {
        return null;
    }

    /**
     * 获取分区发用电平衡监视信息
     * @return
     */
    @Override
    public Map getMonitorInfo() {
        return null;
    }

    /**
     * 获取分区热备用信息信息
     * @return
     */
    @Override
    public Map getSpareInfo() {
        return null;
    }

    /**
     * 获取一次分区转负荷信息
     * @return
     */
    @Override
    public Map getOneInfo() {
        return null;
    }

    /**
     * 获取二次分区转负荷信息
     * @return
     */
    @Override
    public Map getTwoInfo() {
        return null;
    }

    /**
     * 获取平衡交叉点及告警信息
     * @return
     */
    @Override
    public Map getIntersectionInfo() {
        return null;
    }
}
