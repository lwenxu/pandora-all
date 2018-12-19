package com.lwen.pandora.util;

import com.lwen.pandora.enums.ResultVOEnum;
import com.lwen.pandora.vo.ResultVO;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResultVOUtils<T> {
    public static <T> ResultVO success() {
        return new ResultVO<T>(
                ResultVOEnum.SUCCESS.getCode(),
                ResultVOEnum.SUCCESS.getMsg(),
                true);
    }

    public static <T> ResultVO success(String msg) {
        return new ResultVO<T>(
                ResultVOEnum.SUCCESS.getCode(),
                msg,
                true);
    }

    public static <T> ResultVO success(@NonNull T data) {
        ResultVO<T> result = success();
        result.setData(data);
        return result;
    }

    public static <T> ResultVO failed(ResultVOEnum ResultVOEnum) {
        return new ResultVO<T>(
                ResultVOEnum.getCode(),
                ResultVOEnum.getMsg(),
                false);
    }
}
