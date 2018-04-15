package com.demo.test;

import com.demo.entity.student;
import com.demo.service.impl.StudentInfoServiceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @Description :
 * Created by miaoo on 2016/8/14.
 */
public class testWriter {

    private String desFile = "f:\\test\\testBufferedWriter.bcp";

    public static void main(String[] args) {
        StudentInfoServiceImpl service = new StudentInfoServiceImpl();
        List<student> list = service.findAllStudent();
        System.out.println(list);
    }

    public static void forBufferedWriter(String string, String desFile) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(desFile)));
            bufferedWriter.write(string.toString());
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
