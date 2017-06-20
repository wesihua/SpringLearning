package com.wei.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToCollections {

	public static void main(String[] args) {
		String[] strs = new String[]{"a","b","c","d","xxxxx"};
		/**
		
		//ת��������
		String[] datas = Stream.of(strs).toArray(String[]::new);
		System.out.println(datas.toString());
		//ת����list
		List<String> data2 = Stream.of(strs).collect(Collectors.toList());
		//or
		List<String> data3 = Stream.of(strs).collect(Collectors.toCollection(ArrayList::new));
		
		//ת��set
		Set<String> data4 = Stream.of(strs).collect(Collectors.toSet());
		//or
		Set<String> data5 = Stream.of(strs).collect(Collectors.toCollection(TreeSet::new));
		
		*/
		//ת���ַ���
		String str = Stream.of(strs).collect(Collectors.joining(",")).toString();
		System.out.println(str);
	}
}
