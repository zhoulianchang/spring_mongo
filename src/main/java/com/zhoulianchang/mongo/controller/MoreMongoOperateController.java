package com.zhoulianchang.mongo.controller;

import com.zhoulianchang.mongo.entity.response.Result;
import com.zhoulianchang.mongo.service.MongoOperateService;
import com.zhoulianchang.mongo.service.MoreMongoOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("/user/name/age")
    public Result findByName(@RequestParam("name") String name,
                             @RequestParam("age") Integer age) {
        return mongoOperateService.findByNameAndAge(name,age);
    }

    @DeleteMapping("/user/name")
    public Result deleteByName(@RequestParam("name") String name) {
        return mongoOperateService.deleteByName(name);
    }
}
