package com.lwen.pandora.entity;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ResultEntity<T> implements Serializable {
    @NonNull
    private Integer code;
    @NonNull
    private String msg;
    @NonNull
    private Boolean success;
    private Exception exception;
    private T data;
}
