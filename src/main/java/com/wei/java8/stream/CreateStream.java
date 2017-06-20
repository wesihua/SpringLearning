package com.wei.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

	/**
	 * ����Stream�ļ��ַ�ʽ
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] arrays = new String[]{"a","b","c"};
		//1
		Stream.of(arrays).forEach(System.out::println);
		//2
		Arrays.stream(arrays).forEach(x -> System.out.println(x));
		//3
		List<String> list = Arrays.asList(arrays);
		list.stream().forEach(System.out::println);
		
		
		/*************** IntStream ****************/
		IntStream.of(new int[]{1,2,3,3,4,5});
		//�´���int������0�����������������û��ϵ 
		IntStream.range(0, 3).forEach(System.out::print);
		System.out.println("");
		IntStream.rangeClosed(0, 3).forEach(System.out::print);
	}
}
