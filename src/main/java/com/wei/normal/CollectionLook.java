package com.wei.normal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import com.wei.spring.bean.Person;

public class CollectionLook {

	Vector v = new Vector();
	Hashtable<String, String> ht = new Hashtable<String, String>();
	
	final Map<String, String> map = new HashMap<String, String>();
	
	final int a = 100;
	
	ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<String, String>();
	
	public CollectionLook() {
		map.put("1", "1");
	}
	
	public Map<String, String> getMap(){
		return map;
	}
	
	
	public static void main(String[] args) {
		CollectionLook l = new CollectionLook();
		System.out.println(l.getMap());
	}
}
