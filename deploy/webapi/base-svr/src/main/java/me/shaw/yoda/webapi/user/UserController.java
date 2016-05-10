package me.shaw.yoda.webapi.user;

import me.shaw.yoda.common.exception.ServiceException;
import me.shaw.yoda.user.dto.UserDto;
import me.shaw.yoda.user.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yes on 5/5/16.
 */
@Controller
@RequestMapping("/shaw")
public class UserController {
    private static final Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/ping")
    public
    @ResponseBody
    UserDto
    getUserInfo() throws ServiceException {
        log.info("get user info");
        return userService.getUserInfoById("1");
    }

}
