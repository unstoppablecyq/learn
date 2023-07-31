package com.cccccyq.Test20230731;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author cccccyq
 * @date 2023/7/31 14:46
 */
public class BufferedWriter_Test {
    public static void main(String[] args) throws IOException {
        String filepath = "d:\\test.txt";
        //覆盖方式
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));
        //加一个true表示追加模式
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath,true));
        bufferedWriter.write("我测，丁真");
        bufferedWriter.newLine();//插入一个和系统相关的换行符
        bufferedWriter.write("just because you so beautiful");
        bufferedWriter.close();
    }
}
//test