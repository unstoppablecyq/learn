package com.cccccyq.Test20230731;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author cccccyq
 * @date 2023/7/31 14:36
 */
public class BufferedReader_Test {
    public static void main(String[] args) throws IOException {
        //创建
        String filepath = "d:\\test.java";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
        //读取
        String line;//按行读取效率高
        //bufferedReader.readLine() 按行读取文件
        while ((line = bufferedReader.readLine()) != null) {
            System.out.print(line);
        }
        //关闭流只需要关闭BufferedReader，因为底层的文件会关闭节点流
        bufferedReader.close();
    }
}
//test