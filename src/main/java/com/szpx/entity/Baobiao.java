package com.szpx.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "BaoBiao")
public class Baobiao {
    @Id
    @KeySql(useGeneratedKeys = true)
    private String name;
    private String jinhuo;
    private String chuhuo;
    private Float neibu;
    private Integer shoujian;
    private Integer paijian;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJinhuo() {
        return jinhuo;
    }

    public void setJinhuo(String jinhuo) {
        this.jinhuo = jinhuo;
    }

    public String getChuhuo() {
        return chuhuo;
    }

    public void setChuhuo(String chuhuo) {
        this.chuhuo = chuhuo;
    }

    public Float getNeibu() {
        return neibu;
    }

    public void setNeibu(Float neibu) {
        this.neibu = neibu;
    }

    public Integer getShoujian() {
        return shoujian;
    }

    public void setShoujian(Integer shoujian) {
        this.shoujian = shoujian;
    }

    public Integer getPaijian() {
        return paijian;
    }

    public void setPaijian(Integer paijian) {
        this.paijian = paijian;
    }

    @Override
    public String toString() {
        return "BaoBiao{" +
                "name='" + name + '\'' +
                ", jinhuo='" + jinhuo + '\'' +
                ", chuhuo='" + chuhuo + '\'' +
                ", neibu=" + neibu +
                ", shoujian=" + shoujian +
                ", paijian=" + paijian +
                '}';
    }
}

