package com.springboot.zookeeper.springbootstarterzookeeper;


import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * zookeeper 客户端
 */
public class ZooKeeperConnection {

    private ZooKeeper zoo;
    private final int TIME_OUT_TIME = 5000;
    final CountDownLatch countDownLatch = new CountDownLatch(1);
    private String address;

    public ZooKeeper connect() throws Exception {

        zoo = new ZooKeeper(address, TIME_OUT_TIME, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    countDownLatch.countDown();
                }
            }
        });

        countDownLatch.await();
        return zoo;
    }

    public void close() throws Exception {
        zoo.close();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
