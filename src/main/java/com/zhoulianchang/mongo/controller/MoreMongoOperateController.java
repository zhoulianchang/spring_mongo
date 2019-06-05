package com.zhoulianchang.mongo.controller;

import com.zhoulianchang.mongo.entity.response.Result;
import com.zhoulianchang.mongo.service.MongoOperateService;
import com.zhoulianchang.mongo.service.MoreMongoOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZLC
 * @date 2019-06-05 17:50
 **/
@RestController
@RequestMapping("/v1")
public class MoreMongoOperateController {
    private final MoreMongoOperateService mongoOperateService;

    @Autowired
    public MoreMongoOperateController(MoreMongoOperateService mongoOperateService) {
        this.mongoOperateService = mongoOperateService;
    }

    @GetMapping("/user/name")
    public Result findByName(@RequestParam("name") String name) {
        return mongoOperateService.findByName(name);
    }
}