package com.szpx.entity;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "User")
public class Yonghuguanli {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer user_id;
    private String user_name;
    private String user_phone;
    private String user_address;
    private String user_orders;

    public Yonghuguanli(Integer user_id, String user_name, String user_phone, String user_address, String user_orders) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.user_orders = user_orders;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_orders() {
        return user_orders;
    }

    public void setUser_orders(String user_orders) {
        this.user_orders = user_orders;
    }
}
