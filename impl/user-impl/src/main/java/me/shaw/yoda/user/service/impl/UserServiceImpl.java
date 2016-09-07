package me.shaw.yoda.user.service.impl;

import me.shaw.yoda.common.exception.ServiceException;
import me.shaw.yoda.user.dto.UserDto;
import me.shaw.yoda.user.mapping.UserMapper;
import me.shaw.yoda.user.model.User;
import me.shaw.yoda.user.service.FakeUserService;
import me.shaw.yoda.user.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;


import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

/**
 * Created by yes on 7/5/16.
 */
@Service
public class UserServiceImpl implements UserService,FakeUserService{

    public static final Log log = LogFactory.getLog(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    private User buildUser(String namePrefix,String emailPrefix) {
        User user = new User();
        user.setName(namePrefix + UUID.randomUUID().toString());
        user.setEmail(emailPrefix + UUID.randomUUID().toString());
        return user;
    }

    @Transactional
    public void testNotSupport() throws ServiceException {
        System.out.println("in");
        int i = 1 / 0;
        userMapper.insertSelective(buildUser("1.","1."));
        notSupportedMethod();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void notSupportedMethod() throws ServiceException {
        userMapper.insertSelective(buildUser("2.","2."));
        throw new ServiceException("");
    }

    public UserDto getUserInfoById(String id) throws ServiceException {
        User user = new User();
        user.setName("shaa");
        user.setAge(24);
        System.out.println(userMapper.updateByNameSelective(user));
        return null;
    }

    private void trueTransaction() throws ServiceException{
        User user = new User();
        user.setPhone("123456789");
        try {
            userMapper.insertSelective(user);
        } catch (Exception e){
            throw new ServiceException("");
        }

        try{
            userMapper.insertSelective(user);
        } catch (Exception e){
            throw new ServiceException("");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void twoInsertAndThrow() {
        Random random = new Random();
        User user = new User();
        user.setAge(21);
        Integer phone = random.nextInt(100000000);
        user.setEmail("12837@qq.com");
        user.setPhone(phone.toString());
        userMapper.insertSelective(user);

        phone = random.nextInt(100000000);
        user.setPhone(phone.toString());
        user.setName("shaw");
        userMapper.insertSelective(user);

        throw new RuntimeException("");
    }

    public void twoInsertAndThrowWrapper() {
        twoInsertAndThrow();
    }

    @Transactional(rollbackFor=Exception.class)
    public void testTransaction() throws ServiceException {
        log.info("testTransaction");
        try {
            trueTransaction();
        } catch (Exception e){
            log.error("Error",e);
            throw new ServiceException("");
        }
    }

    public void printFakeUser() {
        System.out.println("printFakeUser");
    }

    public String getById(Long id) throws ServiceException {
        User user = userMapper.selectByPrimaryKey(id);
        return user.getName();
    }

}
