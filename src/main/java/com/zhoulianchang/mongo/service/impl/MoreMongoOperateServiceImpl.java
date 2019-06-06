package com.zhoulianchang.mongo.service.impl;

import com.zhoulianchang.mongo.entity.mongo.User;
import com.zhoulianchang.mongo.entity.response.Result;
import com.zhoulianchang.mongo.repository.MongoOperateRepository;
import com.zhoulianchang.mongo.service.MoreMongoOperateService;
import com.zhoulianchang.mongo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZLC
 * @date 2019-06-05 17:52
 **/
@Service
public class MoreMongoOperateServiceImpl implements MoreMongoOperateService {
    private final MongoOperateRepository mongoOperateRepository;

    @Autowired
    public MoreMongoOperateServiceImpl(MongoOperateRepository mongoOperateRepository) {
        this.mongoOperateRepository = mongoOperateRepository;
    }

    @Override
    public Result findByName(String name) {
        List<User> userList = mongoOperateRepository.findByName(name);
        return ResultUtils.success(userList);
    }

    @Override
    public Result findByNameAndAge(String name, Integer age) {
        List<User> userLists = mongoOperateRepository.findByNameAndInfo_Age(name, age);
        return ResultUtils.success(userLists);
    }

    @Override
    public Result deleteByName(String name) {
        if(mongoOperateRepository.existsByName(name)) {
            mongoOperateRepository.deleteByName(name);
            return ResultUtils.success();
        } else {
            return ResultUtils.failed("用户名不存在");
        }
    }
}
