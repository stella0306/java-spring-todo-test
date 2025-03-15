package com.springtest.study.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoRequest {
    private String task;
    private Boolean completed; // completed 필드 추가
}
