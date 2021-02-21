package com.tl.demo3.account.service;

import com.tl.demo3.account.dao.AccountDao;

public class AccountService {

    public boolean transfer(String outUser, String inUser, int money) {
        AccountDao ad = new AccountDao();
        try {
            // 转出
            ad.out(outUser, money);
            // 转入
            ad.in(inUser, money);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
