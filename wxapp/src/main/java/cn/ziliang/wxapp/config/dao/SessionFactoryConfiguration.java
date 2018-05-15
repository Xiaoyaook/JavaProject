package cn.ziliang.wxapp.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * created by ziliang on 18-5-12
 */
@Configuration
public class SessionFactoryConfiguration {
    @Value("${mybatis.config.path}")
    private String myBatisConfigPath;
    @Value("${mapper.xml.config.path}")
    private String mapperXMLConfigPath;
    @Value("${mapper.package.path}")
    private String mapperPackagePath;
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactoryBean createSqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageXMLConfigPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperXMLConfigPath;

        // 设置MyBatis 配置文件的路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(myBatisConfigPath));
        // 设置mapper 对应的XML 文件的路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageXMLConfigPath));
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置mapper 接口所在的包
        sqlSessionFactoryBean.setTypeAliasesPackage(mapperPackagePath);

        return sqlSessionFactoryBean;
    }
}
