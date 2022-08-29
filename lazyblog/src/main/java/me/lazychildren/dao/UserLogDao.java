package me.lazychildren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.lazychildren.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLogDao extends BaseMapper<LoginLog> {
}
