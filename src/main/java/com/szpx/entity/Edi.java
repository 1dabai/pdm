package com.szpx.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Table;

/**
 * Edi
 * 这是一个数据库实现类，由数据库实现，能完成修改，添加，查找，删除
 */
@Data
@Table(name = "Edi")
public class Edi {
    private Integer ddId;

    private Integer userId;

    private String fhName;

    private String fhDz;

    private Integer fhDh;

    private Integer fhYb;

    private String shName;

    private String shDz;

    private Integer shPhone;

    private Integer shYb;

    private String bz;

    private String fkfs;

    private Double fkjg;

    private String huowuName;

    private Integer huowuSl;

    private Double huowuZy;

    private Date sj;

    public Integer getName() {
        return userId;
    }

}