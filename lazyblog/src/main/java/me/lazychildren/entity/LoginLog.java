package me.lazychildren.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.lazychildren.util.GloabalUtil;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("userlog")
public class LoginLog implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer user_id;

    private String state;

    @TableField(value = "time")
    @JsonFormat(pattern = GloabalUtil.TIME_FORMAT, locale = "zh", timezone = "GMT+8")
    private String date;


    public LoginLog(User user,boolean online)
    {
        user_id=user.getId();
        state = online?"on":"off";
        this.date = GloabalUtil.getTime();

    }

}
