package com.springtest.study.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoResponse {
    private Long id;
    private String task;
    private boolean completed;
}
