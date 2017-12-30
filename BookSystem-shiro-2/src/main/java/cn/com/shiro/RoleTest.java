package cn.com.shiro;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * ${DESCRIPTION}
 *
 * @author lightTrace
 * @create 2017-12-09 23:22
 **/
public class RoleTest extends BaseTest{
    @Test
    public void testHasRole() {
        login("classpath:shiro/shiro-role.ini", "zhang", "123");
        //判断拥有角色：role1
        Assert.assertTrue(subject().hasRole("role1"));
        //判断拥有角色：role1 and role2
        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
    }
}
