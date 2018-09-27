package com.employee.back.dao;

import com.employee.entity.UserEntity;
import com.employee.param.UserQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-16 12:06
 **/
public interface UserDAO {

    @Insert({"INSERT INTO employee_user(uid, username, phone, password, public_key)",
            "VALUES(#{entity.uid}, #{entity.username}, #{entity.phone},",
            "#{entity.password}, #{entity.publicKey})"})
    int add(@Param("entity") UserEntity employeeEntity);

    @Update({"UPDATE employee_user",
            "SET username=#{entity.username}, phone=#{entity.phone}",
            "WHERE status = 1",
    })
    int update(@Param("entity") UserEntity employeeEntity);

    @Update({"<script>",
            "UPDATE employee_user SET status= 0",
            "WHERE employee_user_id IN",
            "<foreach item='id' collection='ids' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"})
    int updateById(@Param("ids") Set<Integer> employeeUserIds);

    @Select({"<script>",
            "SELECT username, phone, password, public_key, status, create_time",
            "FROM employee_user",
            "WHERE status IN(0,1)",
            "<if test='username!= null'>",
            "AND username LIKE CONCAT('%',#{username},'%')",
            "</if>",
            "<if test='phone!= null'>",
            "AND phone LIKE CONCAT('%', #{phone},'%')",
            "</if>",
            "<if test='uids != null and uids.size() > 0 '>",
            "<foreach item='uid' collection='uids' open='AND uid IN(' separator=',' close=')'>",
            "#{uid}",
            "</foreach>",
            "</if>",
            "ORDER BY create_time DESC",
            "<if test='needPagination == true'>",
            "LIMIT #{page},#{pageSize}",
            "</if>",
            "</script>"
    })
    List<UserEntity> query(UserQueryParam queryParam);

    @Select({"<script>",
            "SELECT count(1)",
            "FROM employee_user",
            "WHERE status IN(0,1)",
            "<if test='uids != null and uids.size() > 0 '>",
            "<foreach item='uid' collection='uids' open='AND uid IN(' separator=',' close=')'>",
            "#{uid}",
            "</foreach>",
            "</if>",
            "<if test='username != null'>",
            "AND username LIKE CONCAT('%',#{username},'%')",
            "</if>",
            "<if test='phone!= null'>",
            "AND phone LIKE CONCAT('%',#{phone},'%')",
            "</if>",
            "ORDER BY create_time DESC",
            "</script>"
    })
    int count(UserQueryParam queryParam);
}