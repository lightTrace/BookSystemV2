package cn.com.controller;

import cn.com.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * ${DESCRIPTION}
 *
 * @author lightTrace
 * @create 2017-10-28 11:23
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String login(User user, HttpServletRequest request) {
//        String password =  user.getPassword();
//        System.out.println(password);
//        String result = null;
//        if(password.equals("123")){
//            result ="list";
//        }else {
//            result ="login";
//        }
//        return result;
//    }

    @RequestMapping("/login")
    public String login(User user,HttpServletRequest request){
        logger.debug(user.getUserName());
        System.out.println("进入login");
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try{
            subject.login(token);
            Session session=subject.getSession();
            System.out.println("sessionId:"+session.getId());
            System.out.println("sessionHost:"+session.getHost());
            System.out.println("sessionTimeout:"+session.getTimeout());
            session.setAttribute("info", "session的数据");
            return "list";
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "用户名或密码错误！");
            return "login";
        }
    }
}
