package me.lazychildren.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private Integer code;
    private String message;
    private Object data;
    public static Integer RESULT_ERROR=400;
    public static Integer RESULT_SUCCESS=200;
    public static Integer RESULT_IDENTITY_ERROR=401;
    public static Result fail(String mess,int code)
    {
        return new Result(code, mess,null);
    }
    public static Result succ(Object obj)
    {
        return new Result(RESULT_SUCCESS,"success",obj);
    }
}
