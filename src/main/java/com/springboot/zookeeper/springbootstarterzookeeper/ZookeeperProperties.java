package com.springboot.zookeeper.springbootstarterzookeeper;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "zookeeper.address")
public class ZookeeperProperties {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
