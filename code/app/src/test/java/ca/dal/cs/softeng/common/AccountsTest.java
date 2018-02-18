package ca.dal.cs.softeng.common;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by agagne on 18/02/18.
 */
public class AccountsTest {
    @BeforeClass
    public static void setUp() {
        Accounts.init();
    }

    @Test
    public void checkPassword() throws Exception {
        assertTrue(Accounts.checkPassword("fred123","password"));
        assertFalse(Accounts.checkPassword("nonExist","nothing"));
        assertFalse(Accounts.checkPassword("fred123","wrongPassword"));
    }

    @Test
    public void addUser() throws Exception {
        assertTrue(Accounts.addUser("test1","password"));
        assertFalse(Accounts.addUser("test1","addexisting"));
        assertTrue(Accounts.addUser("test2","addsecond"));
    }

}