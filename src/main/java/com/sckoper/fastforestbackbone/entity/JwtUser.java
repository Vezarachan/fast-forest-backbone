package com.sckoper.fastforestbackbone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {

    private final Integer userId;
    private final String userName;
    private final String password;
    private final String sex;
    private final Integer age;
    private final String occupation;
    private final String phoneNumber;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Date lastPasswordResetDate;

    public JwtUser(
            Integer userId,
            String userName,
            String password,
            String sex,
            Integer age,
            String occupation,
            String phoneNumber,
            Collection<? extends GrantedAuthority> authorities,
            Date lastPasswordResetDate) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @JsonIgnore
    public Integer getUserId() {
        return userId;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    /**
     * 账户是否未过期
     * @return 是否未过期
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     * @return 是否未锁定
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     * @return 是否未过期
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否激活
     * @return 是否激活
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * 返回上次密码重置时间
     * @return 密码重置时间
     */
    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
