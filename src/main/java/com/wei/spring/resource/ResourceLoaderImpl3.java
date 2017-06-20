package com.wei.spring.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.Resource;

/**
 * 只能用xml的方式配置
 * @author Administrator
 *
 */
public class ResourceLoaderImpl3 {

	private Resource resource;
	
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}


	/**
	 * 展示resource内容
	 * @return
	 * @throws IOException 
	 */
	public String showResource(){
		StringBuilder sb = new StringBuilder();
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
