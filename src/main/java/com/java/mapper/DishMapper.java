package com.java.mapper;

import com.github.pagehelper.Page;
import com.java.annotation.AutoFill;
import com.java.dto.DishPageQueryDTO;
import com.java.entity.Dish;
import com.java.enumeration.OperationType;
import com.java.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DishMapper {

    /**
     * 插入菜品数据
     *
     * @param dish
     */
    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);
}
