package com.utils;

import lombok.Data;

/**
 * @author：linma
 * @date: 2018/10/30 17:17
 * @email: linma@homeinns.com
 **/
@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T date;
}
