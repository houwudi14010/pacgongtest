package com.test.service;


import com.test.dao.TestDao;
import com.test.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao TestDao;

    @Override
    public int addPaper(Test paper) {
        return TestDao.addPaper(paper);
    }

    @Override
    public int deletePaperById(long id) {
        return TestDao.deletePaperById(id);
    }

    @Override
    public int updatePaper(Test paper) {
        return TestDao.updatePaper(paper);
    }

    @Override
    public Test queryById(long id) {
        return TestDao.queryById(id);
    }

    @Override
    public List<Test> queryAllPaper() {
        return TestDao.queryAllPaper();
    }

}