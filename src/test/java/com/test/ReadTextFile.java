package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadTextFile {
	
	public static void main(String [] args) throws IOException
	{
		String usrdir=System.getProperty("user.dir");
		InputStream in = null;
		try {
			in=new FileInputStream(usrdir+"\\src\\test\\resources\\Size.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte [] buffer= new byte[8192];
		int line=in.read(buffer, 0, 8192);
		String bu=buffer.toString();
		String newstr=new String(buffer);
		System.out.println(bu);
		System.out.println(newstr);
		
	}

}
