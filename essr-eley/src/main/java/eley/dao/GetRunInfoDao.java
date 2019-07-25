package eley.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Administrator on 2019/7/18.
 */
@Repository
public interface GetRunInfoDao {

    @Select("select * from demo.SYS_USER where id = '5555'")
    Map get();
}
