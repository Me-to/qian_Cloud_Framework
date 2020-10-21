package com.example.qian.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.qian.entity.SystemUser;

public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}