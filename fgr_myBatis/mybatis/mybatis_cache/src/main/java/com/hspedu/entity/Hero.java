package com.hspedu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    /**
     id INT PRIMARY KEY AUTO_INCREMENT,
     nickname VARCHAR(32) NOT NULL DEFAULT '',
     skill VARCHAR(32) NOT NULL DEFAULT '',
     rank INT NOT NULL DEFAULT 0,
     salary DOUBLE NOT NULL DEFAULT 0,
     entry DATE NOT NULL
     */

    private Integer id;
    private String nickname;
    private String skill;
    private Integer rank;
    private double salary;
    private Date entry;


}
