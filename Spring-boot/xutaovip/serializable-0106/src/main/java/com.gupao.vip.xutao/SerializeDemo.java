package main.java.com.gupao.vip.xutao;

import java.io.*;

public class SerializeDemo {

    public static void main(String[] args) {
        //序列化操作
        SerializePerson();
        Person.height = 66;
        //反序列化操作
        Person person = DeSerializePerson();
        System.out.println(Person.height);
    }

    private static void SerializePerson(){
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("Person")));
            Person person = new Person();
            person.setAge(18);
            person.setName("xutao");
            oo.writeObject(person);
            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person DeSerializePerson(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("Person")));
            Person person = (Person) ois.readObject();
            System.out.println(person);
            return person;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
