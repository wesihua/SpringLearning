package com.wei.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wei.spring.bean.Person;

/**
 * 同 forEach 但是可以多次调用，forEach只能用一次
 * @author Administrator
 *
 */
public class Peek {

	public static void main(String[] args) {
//		Stream.of("one","two","three","four")
//		.filter(n -> n.length()>3)
//		.peek(n ->System.out.println("filter value:"+n))
//		.map(String::toUpperCase)
//		.peek(n ->System.out.println("map value:"+n))
//		.collect(Collectors.toList());
		
		
//		List<String> list = (List<String>) Stream.of("one", "two", "three", "four")
//        .filter(e -> e.length() > 3)
//        .peek(e -> System.out.println("Filtered value: " + e))
//        .map(String::toUpperCase)
//        .peek(e -> System.out.println("Mapped value: " + e))
//        .collect(Collectors.toList());
//		System.out.println(list);
//		
		
		Person p = new Person();
		p.setName("weisihua");
		Person p2 = new Person();
		p2.setName("weisihua");
		Person p3 = new Person();
		p3.setName("weisihua");
		List<Person> data = new ArrayList<Person>();
		data.add(p);
		data.add(p2);
		data.add(p3);
		
		List<String> names = data.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
		System.out.println(names);
		
	}
}
