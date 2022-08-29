package me.lazychildren.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserInfo implements Serializable {
    Integer user_id;
    String gender;
    String intro;
    String pro_photo;
}
