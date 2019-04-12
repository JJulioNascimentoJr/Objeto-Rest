package br.com.chama.servico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Ex2Servico {
		
public static void main(String[]args){
		
	    try {
				
				URL url = new URL("http://localhost:8080/Ex1Rest/rest/json/get");
						
				HttpURLConnection conn =(HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				
				if(conn.getResponseCode()!=200){
					throw new RuntimeException("Falied : HTTP erro code : " 
				                               + conn.getResponseCode());
				}
				
				BufferedReader br = new BufferedReader(new InputStreamReader(
						                               conn.getInputStream()));
				String output;
				System.out.println("Output from Server...: \n");
				while((output = br.readLine())!=null){
					  System.out.println(output);
				}
				
				conn.disconnect();
				
			} catch (MalformedURLException ex ){
				     ex.printStackTrace();
			
			}catch(IOException e){
				   e.printStackTrace();
			}
	}

	

}
