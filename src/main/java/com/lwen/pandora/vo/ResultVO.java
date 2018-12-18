package com.lwen.pandora.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ResultVO<T> {
    @NonNull
    private Integer code;
    @NonNull
    private String msg;
    @NonNull
    private Boolean success;
    private T data;
}
