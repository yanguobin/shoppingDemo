package edu.cn.service;

import edu.cn.pojo.User;
import edu.cn.pojo.UserDTO;

import java.util.List;

public interface UserService {

    public User selectUserByUserCodeAndUserPassword(String userCode, String userPassword);

    public List<UserDTO> selectAllUser();

    public int insertSelective(User user);

    public UserDTO selectUserById(Long id);

    public int updateByPrimaryKeySelective(User user);

    public int deleteByPrimaryKey(Long id);
}
