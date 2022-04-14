package com.middleware.mobile.web;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@Configuration
public class DBConfig implements ApplicationRunner {


    private final String HOST;
    private final int PORT;
    private final DataSource dataSource;

    public DBConfig(@Value("${spring.redis.host}") String host,@Value("${spring.redis.port}") int port, DataSource dataSource) {
        this.HOST = host;
        this.PORT = port;
        this.dataSource = dataSource;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()){
            log.info("DB CONNECTING SUCCESS!!");
        }
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
        sessionFactoryBean.setTypeAliasesPackage("com.middleware.mobile.domain.dto");

        return sessionFactoryBean.getObject();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(HOST);
        configuration.setPort(PORT);
        return new LettuceConnectionFactory(configuration);
    }
}
