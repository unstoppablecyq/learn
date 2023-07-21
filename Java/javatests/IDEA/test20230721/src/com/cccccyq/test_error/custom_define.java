package com.cccccyq.test_error;

/**
 * @author cccccyq
 * @date 2023/7/21 10:29
 */
public class custom_define {
    public static void main(String[] args) {

    }
}
//test
//自定义异常wtf
class wtfException extends RuntimeException{
    public wtfException(String message) {//构造器
        super(message);
    }
}