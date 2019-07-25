package eley.dao;

import eley.model.sysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface sysUserMapper {
    int insert(sysUser record);

    int insertSelective(sysUser record);
}