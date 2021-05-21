package com.atguigu.even.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Even
 * @Date 2021/5/20 14:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Long id;

    private String serial;

}
