package com.wust.spring.boot.standard.demo.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class User {
    private Integer id;
    private String userName;
    private String passWord;
}
