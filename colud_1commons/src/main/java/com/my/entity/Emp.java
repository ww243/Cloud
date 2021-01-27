package com.my.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/27 15:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp implements Serializable {
    private String id;
    private String name;
    private Boolean sex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bir;
}
