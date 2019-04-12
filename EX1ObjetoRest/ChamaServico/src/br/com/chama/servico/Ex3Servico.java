package br.com.chama.servico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Ex3Servico {
	
public static void main(String[] args) {
		
		try {
			
			URL url = new URL("http://localhost:8080/Ex1Rest/rest/json/post");
					
			HttpURLConnection conn =(HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type","application/json");
			
			String input="{\"nome\":\" Carlos\",\"idade\": 43,\"lp\":\" Java\",\"altura\":1.83,\"peso\":97 }";
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if(conn.getResponseCode()!= HttpURLConnection.HTTP_CREATED){
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