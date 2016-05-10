package me.shaw.yoda.user.service.impl;

import me.shaw.yoda.common.exception.ServiceException;
import me.shaw.yoda.user.dto.UserDto;
import me.shaw.yoda.user.mapping.UserMapper;
import me.shaw.yoda.user.model.User;
import me.shaw.yoda.user.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yes on 7/5/16.
 */
@Service
public class UserServiceImpl implements UserService {

    public static final Log log = LogFactory.getLog(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    public UserDto getUserInfoById(String id) throws ServiceException {
        User user = userMapper.selectByPrimaryKey(Long.valueOf(id));
        try {
            userMapper.insertSelective(user);
        } catch (Exception e) {
            log.info("Repeated input");
        }
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
