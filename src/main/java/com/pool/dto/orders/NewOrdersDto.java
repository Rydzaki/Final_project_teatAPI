package com.pool.dto.orders;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Builder

public class NewOrdersDto {

    private Integer userId;
    private double summa;
    private Integer itemsCount;
    private String date;

}
