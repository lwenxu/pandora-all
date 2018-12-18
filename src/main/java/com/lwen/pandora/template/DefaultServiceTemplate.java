package com.lwen.pandora.template;

import com.lwen.pandora.entity.ResultEntity;
import com.lwen.pandora.enums.ResultEnum;
import com.lwen.pandora.handler.service.DefaultServiceTemplateHandler;
import com.lwen.pandora.handler.Handler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;

@AllArgsConstructor
public abstract class DefaultServiceTemplate<T> implements Template {
    private static Logger logger = null;
    private Handler handler = null;

    DefaultServiceTemplate(Logger logger) {
        this.logger = logger;
    }

    DefaultServiceTemplate(Logger logger, Handler handler) {
        this(logger);
        this.handler = handler;
    }

    private Handler defaultHandler() {
        return DefaultServiceTemplateHandler.builder().build();
    }

    public ResultEntity<T> execute() {
        ResultEntity<T> result = new ResultEntity<T>();
        try {
            result.setSuccess(true);
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMsg(ResultEnum.SUCCESS.getMsg());
            result.setData(invoke());
            return result;
        } catch (Exception e) {
            handleException(e,result,logger);
            return result;
        }
    }

    private void logException() {
        LogInfo logInfo = logInfo();
        if (logInfo != null) {
            if (logInfo.params==null){
                logger.error(logInfo.errorMessage);
            } else {
                logger.error(logInfo.errorMessage, logInfo.params);
            }
        }
    }

    protected abstract LogInfo logInfo();

    protected void handleException(Exception e, ResultEntity<T> result, Logger logger){
        logException();
        defaultHandler().handle(e, result, logger);
    }

    protected abstract T invoke();


    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    private class LogInfo {
        @NonNull
        private String errorMessage;
        private Object[] params;
    }
}