package com.sckoper.fastforestbackbone.service;

import com.sckoper.fastforestbackbone.entity.User;
import com.sckoper.fastforestbackbone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) { //, BCryptPasswordEncoder bCryptPasswordEncoder
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User addUser(User userDetails) {
        userDetails.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        return userRepository.save(userDetails);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserByUserName(String userName) {
        userRepository.deleteUserByUserName(userName);
    }

    @Override
    public User findUserByUserName(String userName) throws UsernameNotFoundException {
        User user =  userRepository.findUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }

    @Override
    public User findUserByUserId(Integer userId) { return userRepository.findUserByUserId(userId); }

    @Override
    public void deleteUserByUserId(Integer userId) {
        userRepository.deleteUserByUserId(userId);
    }

    @Override
    public void updatePasswordByUserName(String userName, String password) { userRepository.updatePasswordByUserName(userName, password); }

    @Override
    public List<User> findAllUsers() throws UsernameNotFoundException {
        List<User> userList = userRepository.findAll();
        if (userList == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return userList;
    }

}
