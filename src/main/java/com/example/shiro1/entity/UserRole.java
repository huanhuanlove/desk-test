package com.example.shiro1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (UserRole)实体类
 *
 * @author kang
 * @since 2020-07-17 22:41:12
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {
    private static final long serialVersionUID = -63235301964710387L;
    
    private int userId;
    
    private int roleId;


}