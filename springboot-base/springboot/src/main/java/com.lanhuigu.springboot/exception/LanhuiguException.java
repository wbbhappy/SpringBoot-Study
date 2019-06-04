package com.lanhuigu.springboot.exception;

/**
 * 自定义异常
 *
 * @auther: yihonglei
 * @date: 2019-06-03 14:26
 */
public class LanhuiguException extends RuntimeException {
    private Integer code;

    private String msg;

    public LanhuiguException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public LanhuiguException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {

        return code;
    }

    public String getMsg() {

        return msg;
    }
}
