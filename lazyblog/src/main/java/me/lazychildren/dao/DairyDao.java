package me.lazychildren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.lazychildren.entity.Dairy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DairyDao extends BaseMapper<Dairy> {
}
