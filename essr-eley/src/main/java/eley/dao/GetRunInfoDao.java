package eley.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Administrator on 2019/7/18.
 */
@Repository
public interface GetRunInfoDao {

    @Select("select * from KD_PAS.ACLINE")
    Map get();

    @Insert("insert into KD_PAS.ACLINE (id , RECORD_APP , code ) values ('3','6','我的家')")
    void insert();
}
