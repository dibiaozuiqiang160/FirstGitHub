package com.itheima.jdbc;

import java.util.List;

/**
 * @author Messi
 * @date 2021/6/22-16:31
 */
public interface AccountDao {
    public int addAccount(Account account);

    public int deleteAccount(int id);

    public int updateAccount(Account account);

    //通过id查询
    public Account findAccountById(int id);

    //查询所有账户
    public List<Account> findAllAccount();

    public void trnsfer(String outUser,String inUser,Double money);

    public void trnsfer2(String outUser,String inUser,Double money);
}
