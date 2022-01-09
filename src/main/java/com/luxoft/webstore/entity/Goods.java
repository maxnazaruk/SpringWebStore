package com.luxoft.webstore.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Builder
public class Goods {
    private int id;
    private String name;
    private int price;
    private LocalDateTime date;
}
