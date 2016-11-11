package com.starikov.dao.impl;

import com.starikov.Contact;
import com.starikov.dao.ContactDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcContactDao implements ContactDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcContactDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Contact getContactById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM contacts where id = ?", (resultSet, i) -> {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("ID"));
            contact.setFirstName(resultSet.getString("FIRST_NAME"));
            contact.setLastName(resultSet.getString("LAST_NAME"));
            return contact;
        }, id);
    }
}
