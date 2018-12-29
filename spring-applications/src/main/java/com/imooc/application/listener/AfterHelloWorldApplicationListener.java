package com.imooc.application.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * TODO
 *
 * @Author miaoo
 * @Date 2018/8/28
 */
public class AfterHelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent>,Ordered {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("After Hello world:"+ event.getApplicationContext().getId()
                +",timestamp: "+event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    public Character firstNotRepeating(String str,Boolean bool){
        if(str == null){
            return null;
        }
        char[] strChar = str.toCharArray();
        LinkedHashMap<Character,Integer> hash = new LinkedHashMap<Character,Integer>();

        if (bool) {
            for (char item : strChar) {
                if (hash.containsKey(item)) {
                    hash.put(item, hash.get(item) + 1);
                } else {
                    hash.put(item, 1);
                }
            }
        }else{
            for (char item : strChar) {
                if (((item > 65)&&(item<90))){
                    if (hash.containsKey(item+32)||hash.containsKey(item)){
                        hash.put(item, hash.get(item) + 1);
                    }
                }else if(((item > 97)&&(item<122))){
                    if (hash.containsKey(item-32)||hash.containsKey(item)){
                        hash.put(item, hash.get(item) + 1);
                    }
                }else {
                    hash.put(item, 1);
                }
            }
        }

        for(char key:hash.keySet()) {
            if(hash.get(key)== 1){
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 接收输入
        String line = sc.nextLine();
        sc.close();

        String arr[] = line.split(" ");
        String str = arr[0];
        Boolean flag = true;	// 默认是true
        if (arr.length == 2) {
            flag = (arr[1].equals("true")?true:false);
        }
        AfterHelloWorldApplicationListener main = new AfterHelloWorldApplicationListener();
        System.out.println(main.firstNotRepeating(str,flag));
    }
}
