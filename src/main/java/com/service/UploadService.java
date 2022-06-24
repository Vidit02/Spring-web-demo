package com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {
	public static String path = "/Users/vidit/Documents/Royal/Spring Boot/FirstProject/src/main/resources/static/";
	
	
	public boolean profilePicUpload(MultipartFile file , String email) {
		File rootdir = new File(path);
		File emaildir = new File(rootdir,email);
		emaildir.mkdir();
		
		File p = new File(emaildir,file.getOriginalFilename());
		try {
			byte b[] = file.getBytes();
			FileOutputStream fos = new FileOutputStream(p);
			fos.write(b);
			fos.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
