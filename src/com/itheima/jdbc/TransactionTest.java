package com.itheima.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author Messi
 * @date 2021/6/22-20:00
 */
public class TransactionTest {
    @Test
    public void Transaction(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =(AccountDao) applicationContext.getBean("accountDao");
        accountDao.trnsfer("JAVA","LYX",10000055.0);
        System.out.println("转账成功！！！");
    }

    //基于Annotation（注解）方式的声明式事务
    @Test
    public void annotationTransaction(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
        AccountDao accountDao =(AccountDao) applicationContext.getBean("accountDao");
        accountDao.trnsfer("LYX","JAVA",22200055.0);
        System.out.println("转账成功！！！");
    }
}
