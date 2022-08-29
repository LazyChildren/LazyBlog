package me.lazychildren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.lazychildren.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {
}
