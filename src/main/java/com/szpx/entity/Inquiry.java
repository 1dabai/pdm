package com.szpx.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.sql.Time;

@Data
@Table(name = "Edi")
public class Inquiry {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer dd_id;
    private Integer user_id;
    private String fh_name;
    private String fh_dz;
    private Integer fh_dh;
    private Integer fh_yb;
    private String sh_name;
    private String sh_dz;
    private Integer sh_phone;
    private Integer sh_yb;
    private String bz;
    private String fkfs;
    private Double fkjg;
    private String huowu_name;
    private Integer huowu_sl;
    private Double huowu_zy;
    private Date sj;

    public Inquiry() {
        super();
    }

    public Inquiry(Integer dd_id, Integer user_id, String fh_name, String fh_dz, Integer fh_dh, Integer fh_yb, String sh_name, String sh_dz, Integer sh_phone, Integer sh_yb, String bz, String fkfs, Double fkjg, String huowu_name, Integer huowu_sl, Double huowu_zy, Date sj) {
        this.dd_id = dd_id;
        this.user_id = user_id;
        this.fh_name = fh_name;
        this.fh_dz = fh_dz;
        this.fh_dh = fh_dh;
        this.fh_yb = fh_yb;
        this.sh_name = sh_name;
        this.sh_dz = sh_dz;
        this.sh_phone = sh_phone;
        this.sh_yb = sh_yb;
        this.bz = bz;
        this.fkfs = fkfs;
        this.fkjg = fkjg;
        this.huowu_name = huowu_name;
        this.huowu_sl = huowu_sl;
        this.huowu_zy = huowu_zy;
        this.sj = sj;
    }


    public Integer getDd_id() {
        return dd_id;
    }

    public void setDd_id(Integer dd_id) {
        this.dd_id = dd_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFh_name() {
        return fh_name;
    }

    public void setFh_name(String fh_name) {
        this.fh_name = fh_name;
    }

    public String getFh_dz() {
        return fh_dz;
    }

    public void setFh_dz(String fh_dz) {
        this.fh_dz = fh_dz;
    }

    public Integer getFh_dh() {
        return fh_dh;
    }

    public void setFh_dh(Integer fh_dh) {
        this.fh_dh = fh_dh;
    }

    public Integer getFh_yb() {
        return fh_yb;
    }

    public void setFh_yb(Integer fh_yb) {
        this.fh_yb = fh_yb;
    }

    public String getSh_name() {
        return sh_name;
    }

    public void setSh_name(String sh_name) {
        this.sh_name = sh_name;
    }

    public String getSh_dz() {
        return sh_dz;
    }

    public void setSh_dz(String sh_dz) {
        this.sh_dz = sh_dz;
    }

    public Integer getSh_phone() {
        return sh_phone;
    }

    public void setSh_phone(Integer sh_phone) {
        this.sh_phone = sh_phone;
    }

    public Integer getSh_yb() {
        return sh_yb;
    }

    public void setSh_yb(Integer sh_yb) {
        this.sh_yb = sh_yb;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getFkfs() {
        return fkfs;
    }

    public void setFkfs(String fkfs) {
        this.fkfs = fkfs;
    }

    public Double getFkjg() {
        return fkjg;
    }

    public void setFkjg(Double fkjg) {
        this.fkjg = fkjg;
    }

    public String getHuowu_name() {
        return huowu_name;
    }

    public void setHuowu_name(String huowu_name) {
        this.huowu_name = huowu_name;
    }

    public Integer getHuowu_sl() {
        return huowu_sl;
    }

    public void setHuowu_sl(Integer huowu_sl) {
        this.huowu_sl = huowu_sl;
    }

    public Double getHuowu_zy() {
        return huowu_zy;
    }

    public void setHuowu_zy(Double huowu_zy) {
        this.huowu_zy = huowu_zy;
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }


}
