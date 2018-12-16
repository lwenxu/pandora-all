package com.lwen.pandora.entity;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class ResultEntity<T> {
    @NonNull
    private Integer code;
    @NonNull
    private String msg;
    @NonNull
    private Boolean success;
    private T data;
}
