package com.yuanwj.repository;

import com.yuanwj.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bmk on 18-1-4.
 */
public interface UserMapper {
    List<User> findByEmail(String email);
}
