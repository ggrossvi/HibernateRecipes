package org.gloriavilla;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.gloriavilla.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    User user1;
    User user2;
    User user3;
    UserDAO userdao;
    List<User> users = new ArrayList<User>();

    @Before
    public void setUp() throws Exception {
        user1 = new User("ew@gmail","Ezra Williams","password","123 ABC Lane","GA","30294");
        user2 = new User("tony@stark.com" ,"Tony Stark", "IAmTheBest","Address1","NY", "22222");
        user3 = new User("hank@pym.com","Hank Pym","IAmTheBest","Address7", "CA", "22222");
        users.add(user2);
        users.add(user3);
        userdao = new UserDAO();
    }

    @Test
    public void testLogin() {
        //use assertEquals: used to determine if the login will return true
        assertEquals(true, userdao.login(user1.getEmail(), user1.getPassword()));
        //assertTrue(userdao.login(user1.getEmail(), user1.getPassword())); //if this returns true, the test passes
    }

    @Test
    public void testFindByEmail() {
        assertEquals(user2, userdao.findByEmail(user2.getEmail()));
        //assertSame(user2, userdao.findByEmail(user2.getEmail()));
    }

    @Test
    public void testFindUsersByZipcode() {
        assertEquals(users,userdao.findUsersByZipcode(user2.getZipcode()));
        //assertArrayEquals(users.toArray(),userdao.findUsersByZipcode(user2.getZipcode()).toArray());
    }

    //Negative test:
    @Test
    public void testNotEmail() {
        assertNotSame(user1.getEmail(), user2.getEmail());
    }

}
