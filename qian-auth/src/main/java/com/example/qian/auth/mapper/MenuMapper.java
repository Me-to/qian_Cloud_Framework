package com.example.qian.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.qian.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> findUserPermissions(String username);
}