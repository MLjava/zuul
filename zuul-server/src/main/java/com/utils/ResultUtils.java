package com.utils;

import com.constant.CommonConstant;
import com.exception.HomeinnsException;

/**
 * @author：linma
 * @date: 2018/10/30 17:16
 * @email: linma@homeinns.com
 **/
public class ResultUtils {

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(CommonConstant.REQUEST_OK);
        resultVO.setMessage(CommonConstant.Message.REQUEST_OK_MESSAGE);
        resultVO.setDate(data);
        return resultVO;
    }

    public static ResultVO failure(HomeinnsException e) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(e.getCode());
        resultVO.setMessage(e.getMessage());
        return resultVO;
    }


}
