package com.gupaoedu.user.dal.persistence;

import com.gupaoedu.user.dal.entity.User;

public interface UserMapper {

    /**
     *
     * @return
     */
    public  User getUserByUserName(String userName);
}
