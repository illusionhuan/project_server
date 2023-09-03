package com.java.controller.admin;

import com.java.dto.DishDTO;
import com.java.dto.DishPageQueryDTO;
import com.java.entity.Dish;
import com.java.result.PageResult;
import com.java.result.Result;
import com.java.service.DishService;
import com.java.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/*
* 菜品管理
* */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
@Slf4j
public class DishController{

    @Autowired
    private DishService dishService;

    @PostMapping
    @ApiOperation("新增菜品接口")
    public Result<String> save(@RequestBody DishDTO dishDTO) {
        log.info("新增菜品:{}", dishDTO);
        dishService.saveWithFlavor(dishDTO);

        return Result.seccess();
    }
}