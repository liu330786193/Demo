package com.lyl.demo.service.impl;

import com.lyl.demo.dao.AccountDao;
import com.lyl.demo.entity.Account;
import com.lyl.demo.plugin.annotation.Trace;
import com.lyl.demo.service.AccountService;
import com.lyl.skywalking.context.ContextManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@ComponentScan
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Trace
    @Override
    public List<Account> selectList() {
//        ContextManager.createLocalSpan("selectList");
        List<Account> list = accountDao.selectList();
//        ContextManager.stopSpan();
        return list;
    }

    @Override
    public int truncateAccount() {
        return accountDao.truncateAccount();
    }

    @Override
    public int insert(Account record) {
        ContextManager.createLocalSpan("insert");
        int a = accountDao.insert(record);
        selectList();
        ContextManager.stopSpan();
        return a;
    }
}
