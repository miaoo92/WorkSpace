package com.gupaoedu.zookeeperdemo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ConnectionDemo {

    public static void main(String[] args) {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zookeeper = new ZooKeeper("192.168.159.129:2181", 4000, (watchedEvent) ->{
                if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()){
                    //如果收到了服务器响应事件，连接成功
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            //添加节点
            zookeeper.create("/zk-persis","0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            Thread.sleep(1000);
            Stat stat = new Stat();
            //得到当前节点的值
            byte[] bytes = zookeeper.getData("/zk-persis",null,stat);
            System.out.println(new String(bytes));
            //修改当前节点的值，乐观锁
            zookeeper.setData("/zk-persis","1".getBytes(),stat.getVersion());

            byte[] bytes1 = zookeeper.getData("/zk-persis",null,stat);
            System.out.println(new String(bytes1));
            zookeeper.delete("/zk-persis",stat.getVersion());
            zookeeper.close();
            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
