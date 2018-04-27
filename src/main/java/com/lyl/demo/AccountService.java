package com.lyl.demo;

import com.lyl.demo.dao.AccountDao;
import com.lyl.demo.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;


    public int truncateAccount(){
        return accountDao.truncateAccount();
    }

//    @Trace
    public int insert(Account record){
        return accountDao.insert(record);
    }
}
