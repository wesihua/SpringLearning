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
	 * չʾresource����
	 * @return
	 * @throws IOException 
	 */
	public String showResource(){
		StringBuilder sb = new StringBuilder();
		String path = "classpath:app.properties";
		ClassPathResource resource = (ClassPathResource) resourceLoader.getResource(path);
		String fileName = resource.getFilename();
		String description = resource.getDescription();
		sb.append("�ļ��������ǣ�").append(fileName).append("\n");
		sb.append("�ļ�������Ϊ��").append(description).append("\n");
		sb.append("�ļ��������Ϊ��").append("\n");
		InputStream in = null;
		try {
			in = resource.getInputStream();
			//����ת��ΪString
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
