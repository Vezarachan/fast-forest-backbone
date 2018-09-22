package com.sckoper.fastforestbackbone.apicontroller;

import com.sckoper.fastforestbackbone.entity.User;
import com.sckoper.fastforestbackbone.service.UserServiceImpl;
import com.sckoper.fastforestbackbone.utils.ResponseMessage;
import com.sckoper.fastforestbackbone.utils.ResultUtil;
import com.sckoper.fastforestbackbone.utils.enums.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 * @author Leon Croft
 */
@Api(value = "用户", description = "用户api")
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserServiceImpl userService;

    /**
     * 注入用户服务
     * @param userService 用户服务
     */
    @Autowired
    private UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 返回所有的用户
     * @return Map
     */
    @ApiOperation("获取所有用户")
    @GetMapping("/")
    public Map<String, Object> getUserList() {
        List<User> userList = userService.findAllUsers();
        Map<String, Object> map = new HashMap<>();
        map.put("users", userList);
        return map;
    }

    /**根据姓名获取
     * @param userName 用户名
     * @return User
     */
    @ApiOperation("根据用户名获取用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @GetMapping("/{userName}")
    public User getUser(@PathVariable(name = "userName") String userName) {
        return userService.findUserByUserName(userName);
    }

    /**
     * 根据用户Id获取
     * @param userId 用户Id
     * @return User
     */
    @ApiOperation("根据用户Id获取用户")
    @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "Integer")
    @GetMapping("/{userId}")
    public User getUser(@PathVariable(name = "userId") Integer userId) {
        return userService.findUserByUserId(userId);
    }

    /**
     * 注册用户
     * @param user 用户信息
     * @return  user
     */
    @ApiOperation("用户注册")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/signup")
    @ResponseBody
    public ResponseMessage addUser(@Valid @RequestBody User user) {
        User is_user = userService.findUserByUserName(user.getUserName());
        ResponseMessage responseMessage;
        if (is_user != null) {
            responseMessage = ResultUtil.error(ResultEnum.USER_HAS_EXISTED);
        }
        else {
            responseMessage = ResultUtil.success();
            userService.addUser(user);
        }
        return responseMessage;
    }

    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @PostMapping("/login")
    public ResponseMessage login(@RequestParam(value = "userName", required = true) String userName, @RequestParam(value = "password", required = true) String password) {
        User user = userService.findUserByUserName(userName);
        if (user == null) {
            return ResultUtil.error(400, "用户名不存在");
        }

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean is_password = encoder.matches(password, user.getPassword());
        if (!is_password) {
            return ResultUtil.error(400, "密码错误");
        }
        return ResultUtil.success(user);
    }

    /**
     * 根据用户名删除用户
     * @param userName 用户名
     */
    @ApiOperation("根据用户名删除用户")
    @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String")
    @DeleteMapping("/{userName}")
    public void deleteUser(@PathVariable(name = "userName") String userName) {
        userService.deleteUserByUserName(userName);
    }

    /**
     * 根据用户id删除用户
     * @param userId 用户ID
     */
    @ApiOperation("根据用户Id删除用户")
    @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "Integer")
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable(name = "userId") Integer userId) {
        userService.deleteUserByUserId(userId);
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
