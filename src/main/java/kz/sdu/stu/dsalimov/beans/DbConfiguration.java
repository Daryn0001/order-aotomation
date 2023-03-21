package kz.sdu.stu.dsalimov.beans;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import kz.sdu.stu.dsalimov.configs.DbConfig;
import kz.sdu.stu.dsalimov.dao.BeanConfigDao;
import kz.sdu.stu.dsalimov.db_beans.DbConfigForDebugServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@MapperScan(basePackageClasses = BeanConfigDao.class)
@Configuration
public class DbConfiguration {
    private final DbConfig dbConfig = new DbConfigForDebugServer();

    @Bean
    public DataSource dataSource() {
        var config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl(dbConfig.url());
        config.setUsername(dbConfig.username());
        config.setPassword(dbConfig.password());

        return new HikariDataSource(config);
    }
}
