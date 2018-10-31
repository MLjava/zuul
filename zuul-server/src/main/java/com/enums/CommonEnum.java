package com.enums;

import lombok.Getter;

/**
 * @author：linma
 * @date: 2018/10/30 17:30
 * @email: linma@homeinns.com
 **/
@Getter
public enum CommonEnum {

    /**
     *
     */
    SERVER_IS_ERROR(500, "糟糕啦，服务出错了！");

    private Integer code;

    private String message;

    CommonEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
