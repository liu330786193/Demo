package com.lyl.demo.service;

import com.lyl.demo.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> selectList();

    int truncateAccount();

    int insert(Account record);

}
