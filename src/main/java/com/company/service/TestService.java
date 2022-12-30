package com.company.service;

import com.company.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {


    @Autowired
    TestMapper testMapper;

    public String test(){
        System.out.println("testService" + testMapper.test());

        return "test";
    }
}
