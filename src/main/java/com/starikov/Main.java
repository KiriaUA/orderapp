package com.starikov;

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
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Main());
        proxyFactory.addAdvice(new MyBeforeAdvice());
        Object proxy = proxyFactory.getProxy();
        ((Main) proxy).getDataFroDb(jdbcTemplate);

    }

    public void getDataFroDb(JdbcTemplate jdbcTemplate) {
        List<Contact> query = jdbcTemplate.query("SELECT * FROM contacts where id = ?", new Object[]{1l}, (resultSet, i) -> {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("ID"));
            contact.setFirstName(resultSet.getString("FIRST_NAME"));
            contact.setLastName(resultSet.getString("LAST_NAME"));
            return contact;
        });

        for (Contact contact : query) {
            System.out.println(contact);
        }
    }
}
