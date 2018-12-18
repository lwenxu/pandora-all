package com.lwen.pandora.handler.service;

import com.lwen.pandora.entity.ResultEntity;
import com.lwen.pandora.enums.ResultEnum;
import com.lwen.pandora.handler.Handler;
import lombok.Builder;
import lombok.NonNull;
import org.slf4j.Logger;

@Builder(toBuilder = true)
public class DefaultServiceTemplateHandler implements Handler {

    @Override
    public void handle(@NonNull Exception e,@NonNull ResultEntity result,@NonNull Logger logger) {
        logger.error(logger.getName() + " Error occurred ! Reason :" + e.getMessage());
        result.setSuccess(false);
        result.setCode(ResultEnum.SERVICE_ERROR.getCode());
        result.setMsg(ResultEnum.SERVICE_ERROR.getMsg());
        result.setException(e);
    }
}
