package edu.cn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.cn.pojo.User;
import edu.cn.pojo.UserDTO;
import edu.cn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/dologin.html")
    public String dologin(@RequestParam("userCode") String userCode, @RequestParam("userPassword") String userPassword, HttpServletRequest httpServletRequest){
        if (userCode != null && userPassword != null){
            User user = userService.selectUserByUserCodeAndUserPassword(userCode, userPassword);
            if (user != null){
                httpServletRequest.getSession().setAttribute("user", user);
                return "frame";
            }
        }
        return "error";
    }

    @RequestMapping("/logout.html")
    public String logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().removeAttribute("user");
        return "login";
    }

    @RequestMapping("/userlist.html")
    public String userlist(Map<String, Object> map, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum){
        PageHelper.startPage(pageNum, 4);
        List<UserDTO> userDTOList = userService.selectAllUser();
        PageInfo<UserDTO> pageInfo = new PageInfo<UserDTO>(userDTOList);

        logger.info("==============pageNum:" + pageNum);
        logger.info("controller层userlist，总数量：" + pageInfo.getTotal() + "，当前页码：" + pageInfo.getPageNum() +
                "，当前页的数量：" + pageInfo.getSize() + "，总页：" + pageInfo.getPages());

        if (userDTOList != null && userDTOList.size() > 0){
            map.put("userDTOList", userDTOList);
            map.put("totalCount", pageInfo.getTotal());
            map.put("currentPageNo", pageInfo.getPageNum());
            map.put("totalPageCount", pageInfo.getPages());
            return "userlist";
        }
        return "error";
    }

    @RequestMapping("/useradd.html")
    public String useradd(){
        return "useradd";
    }

    @RequestMapping("/useraddsave.html")
    public String useraddsave(@RequestParam("userCode") String userCode,
                              @RequestParam("userName") String userName,
                              @RequestParam("userPassword") String userPassword,
                              @RequestParam("ruserPassword") String ruserPassword,
                              @RequestParam("gender") Integer gender,
                              @RequestParam("birthday") String birthday,
                              @RequestParam("phone") String phone,
                              @RequestParam("address") String address,
                              @RequestParam("userRole") Long userRole) throws ParseException {

        logger.info("userCode:" + userCode + ", userName:" + userName + ", userPassword:" + userPassword +
                ", ruserPassword:" + ruserPassword + ", gender:" + gender + ", birthday:" + birthday +
                ", phone:" + phone + ", address:" + address + ", userRole:" + userRole);

        logger.info(new SimpleDateFormat("yyyy-mm-dd").parse(birthday).toString());

        if (userCode != null && userName != null && userPassword != null && ruserPassword != null &&
                gender != null && birthday != null && phone != null && address != null && userRole != null){
            User user = new User();
            user.setUserCode(userCode);
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            user.setGender(gender);
            user.setBirthday(new SimpleDateFormat("yyyy-mm-dd").parse(birthday));
            user.setPhone(phone);
            user.setAddress(address);
            user.setUserRole(userRole);
            int count = userService.insertSelective(user);
            if (count == 1){
                return "useradd";
            }
        }
        return "error";
    }

    @RequestMapping("/usermodifysave.html")
    public String usermodifysave(@RequestParam("id") Long id,
                                 @RequestParam("userName") String userName,
                                 @RequestParam("gender") Integer gender,
                                 @RequestParam("birthday") String birthday,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("address") String address,
                                 @RequestParam("userRole") Long userRole,
                                 HttpServletResponse httpServletResponse) throws ParseException, IOException {
        logger.info("controller层usermodifysave，" + "id:" + id + ", userName:" + userName + ", gender:" + gender +
                ", birthday:" + birthday + ", phone:" + phone + ", address:" + address + ", userRold:" + userRole);
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setGender(gender);
        user.setBirthday(new SimpleDateFormat("yyyy-mm-dd").parse(birthday));
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(userRole);
        int result = userService.updateByPrimaryKeySelective(user);
        if (result == 1){
            httpServletResponse.sendRedirect("/user/userlist.html");
        }
        return "error";
    }


}
