package br.com.chama.servico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Ex1Servico {
	
	public static void show(String nome,int idade, String lgpr){
		
		  try {
				
				URL url = new URL("http://localhost:8080/Ex1Rest/rest/ex1Rest/show/"
				+nome+"/"+idade+"/"+lgpr);

				HttpURLConnection conn=(HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				
				if(conn.getResponseCode()!=200){
					throw new RuntimeException("Erro: " + conn.getResponseCode());
				}
				
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String output;
				System.out.println("Saida: \n");
				while((output=br.readLine())!=null){
					  System.out.println(output);
				}
				
				conn.disconnect();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void imc(float altura, int peso){
		
		  try {
				
				URL url = new URL("http://localhost:8080/Ex1Rest/rest/ex1Rest/imc"
						+ "/"+altura+"/"+peso+"");
				HttpURLConnection conn=(HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				
				if(conn.getResponseCode()!=200){
					throw new RuntimeException("Erro: " + conn.getResponseCode());
				}
				
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String output;
				System.out.println("Saida: \n");
				while((output=br.readLine())!=null){
					  System.out.println(output);
				}
				
				conn.disconnect();
				
			} catch (MalformedURLException e ){
				     e.printStackTrace();
			
			}catch(IOException e){
				   e.printStackTrace();
			}
		
	}
	
	public static void main(String[] args){
		show("Leticia",36,"Phaton");
		imc((float) 1.73,62);
	}
}