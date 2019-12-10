package com.controller;

import com.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author zmf
 * @version 1.0
 * @ClassName UserController
 * @Description: 用户控制层
 * @date 2019/12/10 20:30
 */
@Api(tags = "用户相关接口", description = "提供用户相关的 Rest API")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "查找用户接口", notes = "接口的详细描述")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "用户Id", dataType = "int")
    )
    @GetMapping("/find/{id}")
    public User findById(@PathVariable("id") int id) {
        return new User();
    }

    @ApiOperation("新增用户接口")
    @PostMapping("/add")
    public boolean addUser(@RequestBody User user) {
        return false;
    }

    @ApiOperation("修改用户接口")
    @PutMapping("/update")
    public boolean update(@RequestBody User user) {
        return true;
    }

    @ApiOperation("删除用户接口")
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return true;
    }
}
