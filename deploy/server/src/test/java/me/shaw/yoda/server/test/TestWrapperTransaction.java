package me.shaw.yoda.server.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.shaw.yoda.common.exception.ServiceException;
import me.shaw.yoda.user.mapping.UserMapper;
import me.shaw.yoda.user.model.User;
import me.shaw.yoda.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.UUID;

/**
 * Created by yes on 27/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class TestWrapperTransaction {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Test
    public void testWrapperTransaction() throws ServiceException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = userService.getById(6L);
        WrapJson wrapJson = new WrapJson();
        wrapJson.setJson(json);
        String wrappedJson = om.writeValueAsString(wrapJson);
        System.out.println(wrappedJson);
    }

    static class WrapJson {
        String json;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("WrapJson{");
            sb.append("json='").append(json).append('\'');
            sb.append('}');
            return sb.toString();
        }

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }
    }


    @Test
    public void testWithoutTransaction() throws ServiceException {
        userService.getUserInfoById("1");
    }


    @Test
    public void testNotSupport() throws ServiceException {
        System.out.println("Method in.");
        userService.testNotSupport();
    }

    @Test
    public void testMethodInvoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("Before invoke method");
        TestWrapperTransaction testWrapperTransaction = new TestWrapperTransaction();
        Method method = TestWrapperTransaction.class.getMethod("printHello", String.class);
        method.invoke(testWrapperTransaction, "a");
        System.out.println("After invoke method");
    }

    void printHello(String a) {
        System.out.println("Hello" + a);
    }
}
