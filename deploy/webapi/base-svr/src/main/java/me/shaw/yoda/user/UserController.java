package me.shaw.yoda.user;

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
    class User{
        String name;
        String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
    @RequestMapping("/ping")
    public
    @ResponseBody
    User ping() {
        return new User("Shaw","26");
    }

}
