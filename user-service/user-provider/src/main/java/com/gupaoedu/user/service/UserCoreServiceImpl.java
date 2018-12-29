package com.gupaoedu.user.service;

import com.alibaba.druid.util.StringUtils;
import com.gupaoedu.user.IUserCoreService;
import com.gupaoedu.user.ResponseCodeEnum;
import com.gupaoedu.user.dal.entity.User;
import com.gupaoedu.user.dal.persistence.UserMapper;
import com.gupaoedu.user.dto.UserLoginRequest;
import com.gupaoedu.user.dto.UserLoginResponse;
import com.gupaoedu.user.exception.ExceptionUtil;
import com.gupaoedu.user.exception.ServiceException;
import com.gupaoedu.user.exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userCoreService")
public class UserCoreServiceImpl implements IUserCoreService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private  UserMapper userMapper;

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        logger.info("login request : "+request);
        UserLoginResponse response = new UserLoginResponse();

        try {
            beforeValidate(request);
            User user = userMapper.getUserByUserName(request.getUserName());
            if (user == null|| !user.getPassword().equals(request.getPassword())){
                response.setCode(ResponseCodeEnum.USERORPASSWORD_ERROR.getCode());
                response.setMsg(ResponseCodeEnum.USERORPASSWORD_ERROR.getMsg());
            }
            response.setUid(user.getId());
            response.setAvatar(user.getAvatar());
            response.setCode(ResponseCodeEnum.SUCCESS.getCode());
            response.setMsg(ResponseCodeEnum.SUCCESS.getMsg());

        }catch (Exception e){
            ServiceException serviceException = (ServiceException) ExceptionUtil.handlerException4biz(e);
            response.setCode(serviceException.getErrorCode());
            response.setMsg(serviceException.getErrorMessage());
        }finally {
            logger.info("login response ->" +response);
        }
        return response;

    }

    private void beforeValidate(UserLoginRequest request)  {
        if (request == null){
            throw  new  ValidateException("请求对象为空");
        }
        if (StringUtils.isEmpty(request.getUserName())){
            throw  new ValidateException("用户名为空");
        }
        if (StringUtils.isEmpty(request.getPassword())){
            throw  new ValidateException("密码为空");
        }
    }
}
