package com.demo.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost",8080);
		
		OutputStream os = s.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		
		bw.write("my lord");
		bw.close();
		os.close();
		s.close();
		
	}

}
