package com.firefly.captcha.config;

import com.firefly.captcha.CaptchaWebApplication;
import com.firefly.captcha.model.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


/**
 * Created by rodion on 29.01.2017.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = CaptchaWebApplication.class)
public class JpaConfig implements TransactionManagementConfigurer {

//    @Bean
//    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {
//?        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
////        entityManagerFactoryBean.setDataSource(configureDataSource());
////        entityManagerFactoryBean.setPackagesToScan("com.firefly.captcha");
////        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
////
////        Properties jpaProperties = new Properties();
////        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
////        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
////        entityManagerFactoryBean.setJpaProperties(jpaProperties);
//
//        return entityManagerFactoryBean;
//    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }

}