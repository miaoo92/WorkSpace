package com.gupaoedu.zookeeperdemo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class WatcherDemo {

    public static void main(String[] args) {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zookeeper = new ZooKeeper("192.168.159.129:2181", 4000, (watchedEvent) -> {
                if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                    System.out.println(watchedEvent.getType());
                    //如果收到了服务器响应事件，连接成功
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            zookeeper.create("/zk-persis-xt","2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            Stat stat =zookeeper.exists("/zk-persis-xt",
                (watchedEvent) ->{
                    System.out.println(watchedEvent.getType()+"->"+watchedEvent.getPath());
                    try {
                        //再一次绑定事件
                        zookeeper.exists("/zk-persis-xt",true);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            });


            stat = zookeeper.setData("/zk-persis-xt","3".getBytes(),stat.getVersion());
            Thread.sleep(1000);
            zookeeper.delete("/zk-persis-xt",stat.getVersion());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
