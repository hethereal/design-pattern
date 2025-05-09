package com.thewang.create;

import lombok.Data;

/**
 * @program: design-pattern
 * @description: no
 * @author: wang
 * @create: 2025-05-09 16:52
 **/
@Data
public abstract class AbstractProduct
{
    private String name;

    public abstract void print();
}
