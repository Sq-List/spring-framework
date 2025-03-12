package org.sqlist.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.PropertySource;

/**
 * TODO
 *
 * @author sqlist
 * @createTime 2022/3/12 17:53 周六
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

	/**
	 * Create a new ClassPathXmlApplicationContext, loading the definitions
	 * from the given XML file and automatically refreshing the context.
	 *
	 * @param configLocation resource location
	 * @throws BeansException if context creation failed
	 */
	public MyClassPathXmlApplicationContext(String configLocation) throws BeansException {
		super(configLocation);
	}

	/**
	 * <p>Replace any stub property sources with actual instances.
	 *
	 * @see PropertySource.StubPropertySource
	 * @see org.springframework.web.context.support.WebApplicationContextUtils#initServletPropertySources
	 */
	@Override
	protected void initPropertySources() {
		System.out.println("执行initPropertySources");
		getEnvironment().setRequiredProperties("USER");
	}

	/**
	 * Customize the internal bean factory used by this context.
	 * Called for each {@link #refresh()} attempt.
	 * <p>The default implementation applies this context's
	 * {@linkplain #setAllowBeanDefinitionOverriding "allowBeanDefinitionOverriding"}
	 * and {@linkplain #setAllowCircularReferences "allowCircularReferences"} settings,
	 * if specified. Can be overridden in subclasses to customize any of
	 * {@link DefaultListableBeanFactory}'s settings.
	 *
	 * @param beanFactory the newly created bean factory for this context
	 * @see DefaultListableBeanFactory#setAllowBeanDefinitionOverriding
	 * @see DefaultListableBeanFactory#setAllowCircularReferences
	 * @see DefaultListableBeanFactory#setAllowRawInjectionDespiteWrapping
	 * @see DefaultListableBeanFactory#setAllowEagerClassLoading
	 */
	@Override
	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
		super.setAllowCircularReferences(false);
		super.setAllowBeanDefinitionOverriding(false);
		super.customizeBeanFactory(beanFactory);
	}
}
