package org.sqlist;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sqlist.pojo.HelloWorldBean;
import org.sqlist.pojo.MyClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author sqlist
 * @createTime 2022/3/4 11:22 周五
 */
public class HelloWorldTest {

	@Test
	public void helloWorld() {
		// ApplicationContext ac = new ClassPathXmlApplicationContext("spring-${USER}.xml");
		ApplicationContext ac = new MyClassPathXmlApplicationContext("spring-${USER}.xml");
		HelloWorldBean bean = ac.getBean(HelloWorldBean.class);
		System.out.println("--------");
		System.out.println(bean);
		System.out.println("--------");
	}
}
