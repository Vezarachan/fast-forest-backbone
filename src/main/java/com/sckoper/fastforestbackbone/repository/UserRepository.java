package com.sckoper.fastforestbackbone.repository;

import com.sckoper.fastforestbackbone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Leon Croft
 * 用户操作类
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名寻找并且获得用户
     * @param username 用户名
     * @return User
     */
    public User findUserByUserName(String username);

    /**
     * 根据用户Id寻找并获得账户
     * @param userId 用户Id
     * @return User
     */
    public User findUserByUserId(Integer userId);

    /**
     * 根据某个字符串匹配用户
     * @param username 用户名字符串
     * @return List
     */
    public List<User> findUsersByUserNameContaining(String username);

    /**
     * 根据注册时的手机号码获得账户
     * @param phonenumber 用户手机号
     * @return User
     */
    public User findUserByPhoneNumber(String phonenumber);

    /**
     * 根据用户名删除账户
     * @param username 用户名
     */
    public void deleteUserByUserName(String username);

    /**
     * 根据用户Id删除账户
     * @param userId 用户Id
     */
    public void deleteUserByUserId(Integer userId);

    /**
     * 根据手机号删除账户
     * @param phoneNumber 用户手机号
     */
    public void deleteUserByPhoneNumber(String phoneNumber);

    /**
     * 更新用户密码
     * @param userName 用户名
     * @param newPassword 新密码
     */
    @Query(value = "UPDATE user_tbl SET password = ?2 WHERE username = ?1", nativeQuery = true)
    @Modifying
    public void updatePasswordByUserName(String userName, String newPassword);
}
