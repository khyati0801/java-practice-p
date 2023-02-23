package com.file;

import java.io.File;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args) throws IOException {
		  File file = new File("javaFile123.txt");  
         System.out.println(file.exists()); 
          file.createNewFile();
          file.exists();
          

	}

}
