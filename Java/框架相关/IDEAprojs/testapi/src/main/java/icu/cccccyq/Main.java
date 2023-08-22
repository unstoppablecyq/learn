package icu.cccccyq;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;
import com.unfbx.chatgpt.interceptor.OpenAILogger;
import com.unfbx.chatgpt.interceptor.OpenAiResponseInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class Main {
    public static void main(String[] args) {
        /**
         * 通过api key调用chatgpt-3.5
         */
        //国内访问需要做代理
        Proxy proxy = null;
        //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("ip地址//", 7890));
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                //自定义代理
                .proxy(proxy)
                //自定义日志输出
                .addInterceptor(httpLoggingInterceptor)
                //自定义返回值拦截
                .addInterceptor(new OpenAiResponseInterceptor())
                //自定义超时时间
                .connectTimeout(10, TimeUnit.SECONDS)
                //自定义超时时间
                .writeTimeout(30, TimeUnit.SECONDS)
                //自定义超时时间
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        //构建客户端，apiKey中填入获取到的OpenAI的key
        OpenAiClient openAiClient = OpenAiClient.builder()
                .apiKey(Arrays.asList("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"))
                .okHttpClient(okHttpClient)
                .build();

        List<Message> messages = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入对话内容：");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }
            //聊天模型：gpt-3.5
            Message message = Message.builder().role(Message.Role.USER).content(input).build();
            messages.add(message);

            ChatCompletion chatCompletion = ChatCompletion.builder().messages(messages).build();
//            ChatCompletionResponse chatCompletionResponse = openAiClient.chatCompletion(chatCompletion);
//            System.out.println(chatCompletionResponse);
              openAiClient.chatCompletion(chatCompletion).getChoices().forEach(e->{
                  System.out.println("gpt-3.5-turbo: " + e.getMessage().getContent());
              });
//            chatCompletionResponse.getChoices().forEach(e -> {
//                System.out.println("gpt-3.5-turbo: " + e.getMessage().getContent());
//            });
        }
    }

}


