package com.luxoft.webstore.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
public class User {
    private int id;
    private String email;
    private String pass;
    private String sole;
}
