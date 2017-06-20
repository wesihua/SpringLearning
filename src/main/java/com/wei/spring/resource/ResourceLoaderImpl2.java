package com.wei.spring.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourceLoaderImpl2 {

	@Autowired
	private ResourceLoader resourceLoader;
	
	/**
	 * 展示resource内容
	 * @return
	 * @throws IOException 
	 */
	public String showResource(){
		StringBuilder sb = new StringBuilder();
		String path = "classpath:app.properties";
		ClassPathResource resource = (ClassPathResource) resourceLoader.getResource(path);
		String fileName = resource.getFilename();
		String description = resource.getDescription();
		sb.append("文件的名称是：").append(fileName).append("\n");
		sb.append("文件的描述为：").append(description).append("\n");
		sb.append("文件里的内容为：").append("\n");
		InputStream in = null;
		try {
			in = resource.getInputStream();
			//将流转换为String
			BufferedReader bf = new BufferedReader(new InputStreamReader(in,"utf-8"));
			String line = null;
			while((line = bf.readLine()) != null){
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return sb.toString();
	}
}
