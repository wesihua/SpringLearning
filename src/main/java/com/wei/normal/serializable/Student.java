package com.wei.normal.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = -7326809432899628835L;

	private int id;
	
	private String username;
	
	/*
	 * transient关键字！ 它的意思是“不要麻烦你（指自动机制）保存或恢复它了——我会自己处理的”
	 */
	private transient String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Student() {}
	
	public Student(String username, String password) {
		this.id = 10;
		this.username = username;
		this.password = password;
	}
	
	public String toString() {
		String s = "Student:\r\n"+
				"username: "+username+"\r\n"+
				"password: "+password+"\r\n"+
				"id: "+id;
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("开始写入Object...");
		Student s = new Student("weisihua", "123465");
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("d:/student.txt"));
		out.writeObject(s);
		out.close();
		
		int seconds = 5;
		long t = System.currentTimeMillis() + seconds * 1000;
		if(System.currentTimeMillis() < t) {
			System.out.println("开始读取Object...");
			ObjectInput in = new ObjectInputStream(new FileInputStream("d:/student.txt"));
			Student s2 = (Student) in.readObject();
			System.out.println(s2);
			in.close();
		}
		
	}
	
}
