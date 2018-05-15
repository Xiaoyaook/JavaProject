package cn.ziliang.wxapp.config.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * created by ziliang on 18-5-12
 */
// 配置mybatis mapper扫描路径
@MapperScan("cn.ziliang.wxapp.dao")
@Configuration
public class DataSourceConfiguration {
    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUser;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        // 关闭连接后不自动提交
        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }
}
