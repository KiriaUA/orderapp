package com.starikov;

import com.starikov.dao.impl.JdbcContactDao;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
        JdbcContactDao dao = context.getBean("jdbcContactDao", JdbcContactDao.class);
        System.out.println(dao.getContactById(1L));
    }
}
