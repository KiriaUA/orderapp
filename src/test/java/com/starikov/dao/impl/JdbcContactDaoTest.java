package com.starikov.dao.impl;

import com.starikov.Contact;
import com.starikov.dao.ContactDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class JdbcContactDaoTest {

    @Mock
    private ContactDao contactDao;

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getContactById() throws Exception {
        long anyId = anyLong();
        when(contactDao.getContactById(anyId)).thenReturn(new Contact(anyId, "First", "Last"));
        contactDao.getContactById(anyLong());
        verify(contactDao, only()).getContactById(anyLong());
    }

}