package com.lwen.pandora.handler.controller;

import com.lwen.pandora.enums.ResultVOEnum;
import com.lwen.pandora.util.ResultEntityUtils;
import com.lwen.pandora.util.ResultVOUtils;
import com.lwen.pandora.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class DefaultControllerHandler {
    @ExceptionHandler(Exception.class)
    public ResultVO serviceExecExceptionHandler(Exception e) {
        return ResultVOUtils.failed(ResultVOEnum.SERVICE_ERROR);
    }
}
