package com.example.androidbanking;

/**
 * Created by admin on 12/6/14.
 */
public class AccountItem {

    public String accountType;
    public int balance;

    public AccountItem(String acctType, int money) {
        accountType = acctType;
        balance = money;
    }
}
