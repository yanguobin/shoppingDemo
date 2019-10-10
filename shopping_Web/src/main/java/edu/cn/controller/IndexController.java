package edu.cn.controller;

import edu.cn.pojo.User;
import edu.cn.pojo.UserDTO;
import edu.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/jsp/user.do")
    @ResponseBody
    public String user(){
        return "balabala";
    }

    @RequestMapping("/user/view.do")
    public String userview(@RequestParam("uid") Long uid, Map<String, Object> map){
        UserDTO userDTO = userService.selectUserById(uid);
        map.put("user", userDTO);
        return "userview";
    }

    @RequestMapping("/user/modify.do")
    public String usermodify(@RequestParam("uid") Long uid, Map<String, Object> map){
        UserDTO userDTO = userService.selectUserById(uid);
        map.put("user", userDTO);
        return "usermodify";
    }

    @RequestMapping("/user/delete.do")
    public String userdelete(@RequestParam("uid") Long uid, HttpServletResponse httpServletResponse) throws IOException {
        int result = userService.deleteByPrimaryKey(uid);
        if (result == 1){
            httpServletResponse.sendRedirect("/user/userlist.html");
        }
        return "error";
    }

}
