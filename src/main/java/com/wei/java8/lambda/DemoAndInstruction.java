package com.wei.java8.lambda;

public class DemoAndInstruction {

	/**
	1.Lambda表达式的形式化表示如下所示

	Parameters -> an expression 
	2.如果Lambda表达式中要执行多个语句块,需要将多个语句块以{}进行包装，如果有返回值，需要显示指定return语句，如下所示:

	Parameters -> {expressions;};
	3.如果Lambda表达式不需要参数，可以使用一个空括号表示，如下示例所示

	() -> {for (int i = 0; i < 1000; i++) doSomething();};
	4.Java是一个强类型的语言，因此参数必须要有类型，如果编译器能够推测出Lambda表达式的参数类型，则不需要我们显示的进行指定，如下所示，
	在Java中推测Lambda表达式的参数类型与推测泛型类型的方法基本类似，至于Java是如何处理泛型的，此处略去

	String []datas = new String[] {"peng","zhao","li"};
	Arrays.sort(datas,(String v1, String v2) -> Integer.compare(v1.length(), v2.length()));
	上述代码中 显示指定了参数类型Stirng，其实不指定，如下代码所示，也是可以的，因为编译器会根据Lambda表达式对应的函数式接口Comparator<String>进行自动推断

	String []datas = new String[] {"peng","zhao","li"};;
	Arrays.sort(datas,(v1, v2) -> Integer.compare(v1.length(), v2.length()));
	5.如果Lambda表达式只有一个参数，并且参数的类型是可以由编译器推断出来的，则可以如下所示使用Lambda表达式,即可以省略参数的类型及括号

	Stream.of(datas).forEach(param -> {System.out.println(param.length());});
	6.Lambda表达式的返回类型，无需指定，编译器会自行推断，说是自行推断

	*/
	public static void main(String[] args) {
		//启动一个线程
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("hello world");
			}
		}).start();
		
		//java8方式
		new Thread(() -> System.out.println("hello java8")).start();
	}
}
