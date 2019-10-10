package edu.cn.service.Impl;

import edu.cn.dao.UserMapper;
import edu.cn.pojo.User;
import edu.cn.pojo.UserDTO;
import edu.cn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUserCodeAndUserPassword(String userCode, String userPassword) {
        User user = userMapper.selectUserByUserCodeAndUserPassword(userCode, userPassword);
        if (user != null){
            return user;
        }
        return null;
    }

    @Override
    public List<UserDTO> selectAllUser(){
        List<UserDTO> userDTOList = userMapper.selectAllUser();
        logger.info("service层selectAllUser，查看一下生日格式：" + userDTOList.get(0).getBirthday());
        for (UserDTO userDTO : userDTOList){
            // TODO: 2019/9/10 出生日期到年龄的转换
            userDTO.setAge(10000);
        }
        return userDTOList;
    }

    @Override
    public int insertSelective(User user){
        logger.info("service层，userName:" + user.getUserName() + ", phone:" + user.getPhone() + ", address:" + user.getAddress());
        return userMapper.insertSelective(user);
    }

    @Override
    public UserDTO selectUserById(Long id){
        UserDTO userDTO = userMapper.selectUserById(id);
        logger.info("service层selectUserById, " + userDTO);
        return userDTO;
    }

    @Override
    public int updateByPrimaryKeySelective(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }
}
