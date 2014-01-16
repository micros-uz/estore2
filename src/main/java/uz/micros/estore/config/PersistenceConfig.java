package uz.micros.estore.config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
//import com.google.common.base.Preconditions;

@Configuration
@EnableTransactionManagement
//@PropertySource({ "classpath:persistence-mysql.properties" })
//@ComponentScan({ "org.baeldung.spring.persistence" })
public class PersistenceConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(new String[] { "uz.micros.estore.entity" });
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource restDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        //dataSource.setUrl(env.getProperty("jdbc.url"));
        //dataSource.setUsername(env.getProperty("jdbc.user"));
        //dataSource.setPassword(env.getProperty("jdbc.pass"));

        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/estore");
        dataSource.setUsername("postgres");
        dataSource.setPassword("dev1234");

        return dataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties hibernateProperties() {
        return new Properties() {
            {

                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
                setProperty("hibernate.globally_quoted_identifiers", "true");
            }
        };
    }
}