package com.gupaoedu.vip.pattern.proxy.staticed;

public class Father {

    private Person person;

    public Father(Person person){
        this.person = person;
    }

    //目标对象的引用，必须拿到
    public void findLover(){
        System.out.println("根据孩子的要求物色合适的对象");
        person.findLover();
        System.out.println("双方父母是否同意");
    }
}
