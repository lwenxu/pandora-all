package com.lwen.pandora.util;

import com.lwen.pandora.entity.ResultEntity;
import com.lwen.pandora.enums.ResultEnum;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResultEntityUtils<T> {
    public static<T> ResultEntity success() {
        return new ResultEntity<T>(
                ResultEnum.SUCCESS.getCode(),
                ResultEnum.SUCCESS.getMsg(),
                true);
//        return ResultEntity.builder()
//                .code(ResultEnum.SUCCESS.getCode())
//                .msg(ResultEnum.SUCCESS.getMsg())
//                .success(true);
    }

    public static <T> ResultEntity success(@NonNull T data) {
        ResultEntity<T> result=success();
        result.setData(data);
        return result;
    }

    public static <T> ResultEntity failed(ResultEnum resultEnum) {
        return new ResultEntity<T>(
                resultEnum.getCode(),
                resultEnum.getMsg(),
                false);
    }
}
