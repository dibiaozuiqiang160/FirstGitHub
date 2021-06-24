package com.itheima.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Messi
 * @date 2021/6/22-16:33
 */
public class AccountDaoImpl implements AccountDao{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addAccount(Account account){
        String sql="insert into account(username,balance) values(?,?)";
        Object[] object=new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        int num=this.jdbcTemplate.update(sql,object);
        return num;
    }

    @Override
    public int updateAccount(Account account){
        String sql="update account set username=?,balance=? where id=?";
        Object[] o=new Object[]{
                account.getUsername(),
                account.getBalance(),
                account.getId()
        };
        int num=this.jdbcTemplate.update(sql,o);
        return num;
    }

    @Override
    public int deleteAccount(int id){
        String sql="delete from account where id=?";
        int num=this.jdbcTemplate.update(sql,id);
        return num;
    }

    @Override
    public Account findAccountById(int id){
        String sql="select * from account where id=?";
        RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public List<Account> findAllAccount(){
        String sql="select * from account";
        RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void trnsfer(String outUser,String inUser,Double money){
        this.jdbcTemplate.update("update account set balance = balance +?"
                +"where username =?",money,inUser);
        //模拟系统运行时的突发性问题
//        int i=1/0;

        this.jdbcTemplate.update("update account set balance = balance -?"
                +"where username =?",money,outUser);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    @Override
    public void trnsfer2(String outUser,String inUser,Double money){
        this.jdbcTemplate.update("update account set balance = balance +?"
                +"where username =?",money,inUser);
        //模拟系统运行时的突发性问题
//        int i=1/0;

        this.jdbcTemplate.update("update account set balance = balance -?"
                +"where username =?",money,outUser);
    }
}
