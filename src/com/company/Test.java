package com.company;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface Test {
    int a();
    int b();
}