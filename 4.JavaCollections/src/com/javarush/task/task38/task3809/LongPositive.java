package com.javarush.task.task38.task3809;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME) // необходимо было указать время исполнения аннотации в RunTime
public @interface LongPositive {
}
