package com.wei.java8.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysTest {

	public static void main(String[] args) {
		String[] datas = new String[]{"weisihua","zhangsan","lisixxxxx"};
		//简单字段排序
		Arrays.sort(datas);
		//字符串长度排序
		Arrays.sort(datas,(v1,v2) -> Integer.compare(v1.length(), v2.length()));
		Stream.of(datas).forEach(param -> System.out.println(param));
		//方法引用
		Arrays.stream(datas).forEach(System.out::println);
	}
}
