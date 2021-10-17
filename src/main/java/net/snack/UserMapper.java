package net.snack;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> listUser();
    List<Map<String, Object>> listData();
    @Select("select * from user")
    List<User> listUser2();
}
