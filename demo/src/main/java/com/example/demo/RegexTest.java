package com.example.demo;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) throws Exception {
        String regex = ".+";
        String fileName = "C:\\Users\\Abel\\Desktop\\learn-regex_README-cn.md at master · ziishaned_learn-regex.txt";
        File file = new File(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        char bb[] = new char[1024];
        StringBuilder sb = new StringBuilder();
        while (inputStreamReader.read(bb, 0, bb.length - 1) > 1) {

            sb.append(String.valueOf(bb));
        }
        String regex1 = "(<.+?>|</.+?>)";
        String[] ss = {"3120 De la Cruz Boulevard", "1180 Bordeaux Drive", "345 sdfd sdf sdf", "sdfs sdfs sdf"};

        ss = sb.toString().replaceAll(regex1,"") .split("\\n");
        for (String s1 : ss) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(s1);
            if (m.find()) {
                System.out.println(m.group(0));
            }
        }

    }
}
