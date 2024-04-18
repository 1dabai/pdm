package com.szpx.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//lombok @Data是自动的生成Get Set ToString方法

@Data
@Table(name = "serializable")
public class Dispatch {

    @Id
    @KeySql(useGeneratedKeys = true)
    private String order_number;
    private String courier_name;
    private String courier_phone;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sent_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date delivered_time;

}
