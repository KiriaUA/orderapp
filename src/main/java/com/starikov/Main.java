package com.starikov;

import com.starikov.dao.impl.JdbcContactDao;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
        JdbcContactDao dao = context.getBean("jdbcContactDao", JdbcContactDao.class);
        System.out.println(dao.getContactById(1L));
    }
}
