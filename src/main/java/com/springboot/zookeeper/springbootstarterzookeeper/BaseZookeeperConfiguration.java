package com.springboot.zookeeper.springbootstarterzookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ZookeeperProperties.class)
@ConditionalOnClass(ZooKeeperConnection.class)
@ConditionalOnProperty(value = "zookeeper.address")
public class BaseZookeeperConfiguration {

    @Autowired
    private ZookeeperProperties zookeeperProperties;

    @Bean
    @ConditionalOnMissingBean(ZooKeeperConnection.class)
    public ZooKeeperConnection zooKeeperConnection(){
        ZooKeeperConnection connection = new ZooKeeperConnection();
        connection.setAddress(zookeeperProperties.getAddress());
        return connection;
    }
}
