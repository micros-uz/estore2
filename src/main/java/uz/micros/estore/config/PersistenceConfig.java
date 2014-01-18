package uz.micros.estore.config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@Profile("openshift")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "uz.micros.estore.repository.impl")
public class PersistenceConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setJpaVendorAdapter(jpaVendorAdapter());
        lef.setJpaProperties(additionalProperties());
        lef.setPackagesToScan("uz.micros.estore.entity");
        lef.setDataSource(dataSource());
        lef.afterPropertiesSet();

        return lef.getObject();
    }

    @Bean
    public Properties additionalProperties() {
        return new Properties() {
            {  // Hibernate Specific:
                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
                setProperty("hibernate.show_sql", "true");
                //setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JTATransactionFactory");

                //setProperty("hibernate.jta.UserTransaction", "javax.transaction.UserTransaction");
            }
        };
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jva = new HibernateJpaVendorAdapter();
        jva.setShowSql(true);
        jva.setGenerateDdl(true);
        jva.setDatabase(Database.POSTGRESQL);
        return jva;
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        String username = System.getenv("OPENSHIFT_POSTGRESQL_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_POSTGRESQL_DB_PASSWORD");
        String host = System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");
        String databaseName = System.getenv("OPENSHIFT_APP_NAME");

        if (host == null) {
            host = "127.0.0.1";
            port = "5432";
            username = "postgres";
            password = "dev1234";
            databaseName = "estore";
        }

        String url = "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        dataSource.setValidationQuery("SELECT version()");



        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());

        return transactionManager;
    }

/*
    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
*/

}
