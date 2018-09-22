package com.sckoper.fastforestbackbone.service;

import com.sckoper.fastforestbackbone.entity.User;

import java.util.List;

public interface IUserService {

    /**
     * 创建用户
     * Id自动生成
     * @param userDetailes 用户信息
     */
    public User addUser(User userDetailes);

    /**
     * 更新用户信息
     * @param user 用户名
     */
    public void updateUser(User user);

    /**
     * 根据用户名更新密码
     * @param userName 用户名
     * @param newPassword 密码
     */
    public void updatePasswordByUserName(String userName, String newPassword);

    /**
     * 根据用户名删除用户
     * @param userName 用户名
     */
    public void deleteUserByUserName(String userName);

    /**
     * 根据用户Id删除用户
     * @param userId 用户Id
     */
    public void deleteUserByUserId(Integer userId);

    /**
     * 根据用户名找到用户
     * @param userName 用户名
     * @return User
     */
    public User findUserByUserName(String userName);

    /**
     * 根据用户Id找到用户
     * @param userId 用户Id
     * @return User
     */
    public User findUserByUserId(Integer userId);

    /**
     * 找到所有的用户
     * @return List
     */
    public List<User> findAllUsers();

}
