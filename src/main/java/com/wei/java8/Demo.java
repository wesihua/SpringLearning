package com.wei.java8;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Arrays.asList("a","b","c").forEach(a -> System.out.print(a));
		System.out.println("");
		Arrays.asList("a","b","c").forEach(a -> {
			System.out.print(a);
			System.out.print("^_^");
		});
	}

}
