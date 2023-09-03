package com.java.service;

@Service
public interface EmployeeService {


    /**
     * 功能描述:新增菜品
     *
     * @param dishDTO
     * @return
     * @date 2023/09/03
     */

    void saveWithFlavor(DishDTO dishDTO);
}