package com.spdb.hrsys.service.impl;

import com.spdb.hrsys.mbg.mapper.TestMapper;
import com.spdb.hrsys.mbg.model.Test;
import com.spdb.hrsys.mbg.model.TestExample;
import com.spdb.hrsys.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {
        return testMapper.selectByExample(new TestExample());
    }
}
