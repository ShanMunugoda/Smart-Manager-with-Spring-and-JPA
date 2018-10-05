package lk.ijse.comp.main;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("file:${user.dir}/resource/application.properties")
public class JpaConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
        lcemf.setDataSource(dataSource());
        lcemf.setJpaVendorAdapter(jpaVendorAdapter);
        lcemf.setPackagesToScan("lk.ijse.comp.entity");
        return lcemf;
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl(env.getRequiredProperty("javax.persistance.jdbc.username"));
        bds.setDriverClassName(env.getRequiredProperty("javax.persistance.jdbc.driver"));
        bds.setUrl(env.getRequiredProperty("javax.persistance.jdbc.url"));
        bds.setUsername(env.getRequiredProperty("javax.persistance.jdbc.username"));
        bds.setPassword(env.getRequiredProperty("javax.persistance.jdbc.password"));
        bds.setMaxIdle(env.getRequiredProperty("hibernate.max_idle",Integer.class));
        bds.setMaxTotal(env.getRequiredProperty("hibernate.max_total",Integer.class));
        bds.setInitialSize(env.getRequiredProperty("hibernate.init_size",Integer.class));
        return bds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        va.setDatabase(Database.MYSQL);
        va.setShowSql(env.getRequiredProperty("hibernate.show_sql",Boolean.class));
        va.setGenerateDdl(env.getRequiredProperty("hibernate.generate_ddl",Boolean.class));
        va.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));
        return va;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}

