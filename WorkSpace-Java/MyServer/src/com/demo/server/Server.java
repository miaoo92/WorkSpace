package com.demo.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {

		ServerSocket ss = new  ServerSocket(8080);
		while(true){
			Socket s = ss.accept();
			
			InputStream is = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String str = br.readLine();
			System.out.println("客户端说："+ str);
			
			br.close();
			is.close();
			s.close();
			
		}
		
	}

}
