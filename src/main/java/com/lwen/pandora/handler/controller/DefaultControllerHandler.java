package com.lwen.pandora.handler.controller;

import com.lwen.pandora.config.DevConfig;
import com.lwen.pandora.enums.ResultVOEnum;
import com.lwen.pandora.exception.UnauthorizedException;
import com.lwen.pandora.util.ResultVOUtils;
import com.lwen.pandora.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class DefaultControllerHandler {
    @Autowired
    DevConfig devConfig;

    @ExceptionHandler(Exception.class)
    public ResultVO serviceExecExceptionHandler(Exception e) {
        if (devConfig.getAppDebug()) {
            e.printStackTrace();
        }
        return ResultVOUtils.failed(ResultVOEnum.SERVICE_ERROR);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResultVO unauthorizedExceptionHandler(Exception e) {
        if (devConfig.getAppDebug()) {
            e.printStackTrace();
        }
        return ResultVOUtils.failed(ResultVOEnum.Unauthorized_ERROR);
    }
}
