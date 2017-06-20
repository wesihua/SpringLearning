package com.wei.java8.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysTest {

	public static void main(String[] args) {
		String[] datas = new String[]{"weisihua","zhangsan","lisixxxxx"};
		//���ֶ�����
		Arrays.sort(datas);
		//�ַ�����������
		Arrays.sort(datas,(v1,v2) -> Integer.compare(v1.length(), v2.length()));
		Stream.of(datas).forEach(param -> System.out.println(param));
		//��������
		Arrays.stream(datas).forEach(System.out::println);
	}
}
