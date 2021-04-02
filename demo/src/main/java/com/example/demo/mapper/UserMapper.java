package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author  huangrn
 * @date  2020/11/29 18:17
 * @version 1.0
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteListUserById(List<Integer> ids);

    int insert(User record);

    int insertSelective(User record);

    int insertListSelective(@Param(value = "record") List<User> record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAllUsers();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteAllUser();

    @Select("select * from user limit #{limit}")
    Cursor<User> selectUsers(int limit);
}