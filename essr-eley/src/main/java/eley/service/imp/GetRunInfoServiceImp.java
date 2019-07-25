package eley.service.imp;

import eley.dao.GetRunInfoDao;
import eley.dao.sysUserMapper;
import eley.model.sysUser;
import eley.service.GetRunInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2019/7/18.
 */
@Service
public class GetRunInfoServiceImp implements GetRunInfoService {
    private static final Logger log = LoggerFactory.getLogger(GetRunInfoServiceImp.class);

    @Autowired
    GetRunInfoDao getRunInfodao;

    @Autowired
    sysUserMapper dao;

    @Override
    public List<Map> get() {
        log.info(getRunInfodao.get()+"");
        sysUser user = new sysUser(String.valueOf(new Date().getTime()).substring(String.valueOf(new Date().getTime()).length()-8,String.valueOf(new Date().getTime()).length()),"张康","20");
        log.info(user+"-----------------------------------");
        dao.insert(user);
        List list = new ArrayList();
        list.add(getRunInfodao.get());
        return list;
    }
}
