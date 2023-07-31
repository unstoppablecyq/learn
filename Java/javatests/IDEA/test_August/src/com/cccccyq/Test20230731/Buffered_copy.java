package com.cccccyq.Test20230731;

import java.io.*;

/**
 * @author cccccyq
 * @date 2023/7/31 14:52
 */
public class Buffered_copy {
    public static void main(String[] args) {
        String srcFilePath = "d:\\原文件.txt";
        String destFilePath = "d:\\目标文件.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            //
            while ((line = br.readLine()) != null){
                //读一行就写入，readLine只读取一行内容，但是没有换行
                bw.write(line);
                bw.newLine();
            }
            System.out.println("ok");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            try {
                if (br != null){
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
//test