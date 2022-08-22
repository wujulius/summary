package Utils;

import com.SensitiveWordFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WordInUtils {
    //定义一个获取敏感词文档的工具类
    //将其读入list集合中
    //步骤：
    //步骤一：
    //创建一个list集合
    //创建一个字符流将获取的对象读入
    public static InputStream in = null;
    public static List<String> list = new ArrayList<>();
    public static List<String> getList(){

        in = WordInUtils.class.getClassLoader().getResourceAsStream("SensitiveWord.txt");

        //判断敏感词是否读完
  /*      System.out.println(br);*/
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
           String word = br.readLine();
           list.add(word);
            while (word!=null){
                  word= br.readLine();
                if (word!=null&&word.length()>0){
                    list.add(word);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;

    }
    //书写敏感词替代方法
    public static String replaceWord(String value,List<String> list){
        for (int i = 0; i < list.size(); i++) {
         /*   System.out.println("开始替换");*/
          /*  System.out.println(list.get(i));*/
            if (list.get(i).equals(value)){
                value = "******";
                /*System.out.println("2");*/
            }
   /*         System.out.println("1");*/
        }
       /* System.out.println(value);*/
        return value;
    }
}
