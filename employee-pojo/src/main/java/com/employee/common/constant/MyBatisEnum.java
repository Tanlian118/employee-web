package com.employee.common.constant;

public interface MyBatisEnum<E> {
    /**
     * Enum -> db value
     */
    Object getValue();

     /**
     * db value -> Enum
     */
    E getSelf(Object value);
}
