package net.snack;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author dingmingxuan
 * @date 2021/10/19
 */
public class PageDemo {

    public static void main(String[] args) throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resource);
        SqlSession session = build.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        PageHelper.startPage(2, 2);
        List<Map<String, Object>> maps = mapper.listData();
        maps.forEach(System.out::println);
    }
}
