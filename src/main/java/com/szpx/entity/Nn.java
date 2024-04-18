package com.szpx.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name ="nn")
public class Nn {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String strat;
    private String end;
    private float price;
}
