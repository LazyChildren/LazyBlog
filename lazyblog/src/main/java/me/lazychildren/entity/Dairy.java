package me.lazychildren.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.sql.Date;

import static me.lazychildren.util.GloabalUtil.TIME_FORMAT;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dairy {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    private String content;

    @JsonFormat(pattern = TIME_FORMAT, locale = "zh", timezone = "GMT+8")
    private String date;

    private int userid;


}
