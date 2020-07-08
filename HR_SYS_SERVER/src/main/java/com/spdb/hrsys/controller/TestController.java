package com.spdb.hrsys.controller;

import com.spdb.hrsys.mbg.model.Test;
import com.spdb.hrsys.service.MemberService;
import com.spdb.hrsys.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "测试Swagger")
@RestController
@RequestMapping("/hrsys")
public class TestController {
    @Autowired
    DataSource dataSource;

    @Autowired
    private TestService testService;

    @Autowired
    private MemberService memberService;
    @ApiOperation("测试数据库连接、MyBatis")
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ResponseEntity<?> test(){
        List<Test> list = new ArrayList<>();
        list = testService.findAllTest();

        try {
            //测试数据库连接
            System.out.println(dataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ResponseEntity.ok(list);
    }

    @ApiOperation("模拟获取手机验证码，测试redis")
    @RequestMapping(method = RequestMethod.GET, value = "/getAuthCode")
    public ResponseEntity<?> getAuthCode(@RequestParam String phone){
        String authCode =  memberService.generateAuthCode(phone);
        return ResponseEntity.ok(authCode);
    }

    @ApiOperation("模拟验证码是否正确，测试redis")
    @RequestMapping(method = RequestMethod.POST, value = "/verifyAuthCode")
    public ResponseEntity<?> verifyAuthCode(@RequestParam String phone, @RequestParam String authCode){
        boolean isRightCode =  memberService.verifyAuthCode(phone, authCode);
        return ResponseEntity.ok(isRightCode);
    }
}
