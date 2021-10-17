package net.snack;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ConfigDemo {
    public static void main(String[] args) throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resource);
        SqlSession session = build.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.listUser();
        userList.forEach(System.out::println);
        List<Map<String, Object>> dataList = mapper.listData();
        dataList.forEach(System.out::println);
    }
}
