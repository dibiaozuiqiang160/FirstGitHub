package com.itheima.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Messi
 * @date 2021/6/22-16:17
 */
public class JdbcTemplateTest {
    @Test
    public void JdbcTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.execute("create table account("+
                "id int primary key auto_increment,"+
                "username varchar(50),"+
                "balance double )");
        System.out.println("账户表account创建成功！！！");
    }

    @Test
    public void addAccountDaoTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =(AccountDao) applicationContext.getBean("accountDao");
        Account account =new Account();
        account.setUsername("LYX");
        account.setBalance(100000000.0);
        int num=accountDao.addAccount(account);

        Account account1 =new Account();
        account1.setUsername("LeoMessi");
        account1.setBalance(1234567.00);
        int num1=accountDao.addAccount(account1);

        int sum=num+num1;

        if(sum>0){
            System.out.println("成功插入了"+sum+"条数据！！");
        }
        else{
            System.out.println("插入执行失败！！");
        }
    }

    @Test
    public void updateAccountTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =(AccountDao) applicationContext.getBean("accountDao");
        Account account =new Account();
        account.setId(5);
        account.setUsername("KOBE");
        account.setBalance(4567890.0);
        int num=accountDao.updateAccount(account);

        account.setId(6);
        account.setUsername("JAVA");
        account.setBalance(789454613.0);
        int num1=accountDao.updateAccount(account);

        int sum=num+num1;
        if(sum>0){
            System.out.println("成功修改了"+sum+"条数据！！");
        }
        else{
            System.out.println("修改执行失败！！");
        }
    }

    @Test
    public void deleteAccountTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =(AccountDao) applicationContext.getBean("accountDao");
        int num=accountDao.deleteAccount(3);

        int num1=accountDao.deleteAccount(4);

        int sum=num+num1;
        if(sum>0){
            System.out.println("成功删除了"+sum+"条数据！！");
        }
        else{
            System.out.println("删除执行失败！！");
        }
    }

    @Test
    public void findByIdAccountTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =(AccountDao) applicationContext.getBean("accountDao");
        Account account =accountDao.findAccountById(1);
        System.out.println("account = " + account);
    }

    @Test
    public void findAllAccountTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =(AccountDao) applicationContext.getBean("accountDao");
        List<Account> account = accountDao.findAllAccount();
        for (Account account1 : account) {
            System.out.println("account1 = " + account1);
        }
    }
}
