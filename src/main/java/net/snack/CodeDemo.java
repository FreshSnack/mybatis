package net.snack;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.List;

public class CodeDemo {
    public static void main(String[] args) {
        // 构建数据库连接池
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        // 构建数据库事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        // 创建数据库运行环境
        Environment environment = new Environment("dev", transactionFactory, dataSource);
        // 构建Configuration对象
        Configuration configuration = new Configuration(environment);
        // 注册一个mybatis上下文别名
        configuration.getTypeAliasRegistry().registerAlias("user", User.class);
        // 加入一个映射器
        configuration.addMapper(UserMapper.class);
        // 构建SqlSession
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(configuration);
        // 打开session
        SqlSession session = build.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.listUser2();
        userList.forEach(System.out::println);
    }
}
