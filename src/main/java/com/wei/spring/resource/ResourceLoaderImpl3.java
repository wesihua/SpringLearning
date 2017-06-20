package com.wei.spring.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.Resource;

/**
 * ֻ����xml�ķ�ʽ����
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
	 * չʾresource����
	 * @return
	 * @throws IOException 
	 */
	public String showResource(){
		StringBuilder sb = new StringBuilder();
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
