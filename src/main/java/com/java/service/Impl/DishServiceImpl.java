package com.java.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.java.constant.MessageConstant;
import com.java.constant.StatusConstant;
import com.java.dto.DishDTO;
import com.java.dto.DishPageQueryDTO;
import com.java.entity.Dish;
import com.java.entity.DishFlavor;
import com.java.entity.Setmeal;
import com.java.exception.DeletionNotAllowedException;
import com.java.mapper.DishFlavorMapper;
import com.java.mapper.DishMapper;
import com.java.mapper.SetmealDishMapper;
import com.java.mapper.SetmealMapper;
import com.java.result.PageResult;
import com.java.service.DishService;
import com.java.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    @Transactional
    public void saveWithFlavor(DishDTO dishDTO){
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);

        //往菜品表dish里面插入一条数据
        dishMapper.insert(dish);
        //获取菜品的主键
        Long dishId = dish.getId();

        List<DishFlavor> flavors = dishDTO.getFlavors();
        if(flavors != null && flavors.size() > 0){
            //往口味表dish_flavor里面插入n条
            flavors.foreach(dishFlavor -> {
                dishFlavor.setDishId(dishId);
            });
            //批量插入
            dishFlavorMapper.insertBatch(flavors);
        }
    }
}