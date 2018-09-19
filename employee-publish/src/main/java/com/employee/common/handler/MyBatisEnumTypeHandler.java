package com.employee.common.handler;

import com.tan.kit.constant.MyBatisEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Tanlian
 * @create 2018-09-16 19:54
 **/
@MappedTypes(MyBatisEnum.class)
public class MyBatisEnumTypeHandler<E extends Enum<E> & MyBatisEnum> extends BaseTypeHandler<E> {

    private Class<E> type;
    private final E[] enums;

    public MyBatisEnumTypeHandler(Class<E> type) {
        if (type == null){
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.enums = type.getEnumConstants();
        if (!type.isInterface() && this.enums == null){
            throw new IllegalArgumentException(type.getSimpleName()
                    + " does not represent an enum type.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter,
                                    JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.getValue());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        Object value = rs.getObject(columnName);
        if (rs.wasNull() || value == null) {
            return null;
        }
        for (E e : enums) {
            if (value == e.getValue()) {
                return e;
            }
        }
        throw new IllegalArgumentException("Cannot convert "
                + value + " to " + type.getSimpleName());
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        Object value = rs.getObject(columnIndex);
        if (rs.wasNull() || value == null) {
            return null;
        }
        for (E e : enums) {
            if (value == e.getValue()) {
                return e;
            }
        }
        throw new IllegalArgumentException("Cannot convert "
                + value + " to " + type.getSimpleName());
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        Object value = cs.getObject(columnIndex);
        if (cs.wasNull() || value == null) {
            return null;
        }
        for (E e : enums) {
            if (value == e.getValue()) {
                return e;
            }
        }
        throw new IllegalArgumentException("Cannot convert "
                + value + " to " + type.getSimpleName());
    }

}
