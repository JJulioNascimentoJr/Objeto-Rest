package br.com.ex1.rest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/json")
public class JSONPessoa {
	
	@GET
	@Path("/get")
	@Produces("application/json")
	public String  getProductInJSON() throws IOException{
		String txt="";
		DecimalFormat df = new DecimalFormat("00.00");
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Alexia");
		pessoa.setIdade(22);
		pessoa.setLp("C#");
		pessoa.setAltura(1.67);
		pessoa.setPeso(58);
		
		txt="Eu " + pessoa.getNome() +" ,trabalho e estudo, tenho " + pessoa.getIdade() + " anos,"
			    + " e adoro programar em " + pessoa.getLp()+", Eu tenho " 
		        + pessoa.getAltura() + " de altura e tenho " + pessoa.getPeso() + " Kg"
			    +" e meu IMC: "+df.format(pessoa.getPeso()/(pessoa.getAltura()*pessoa.getAltura()))+ " do Peso";
		
		
		gravaStatus(txt);
		return txt;		    
	}
	
	
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createPessoaInJSON(Pessoa pessoa) throws IOException{
		String result=" Product created : \n\n"+pessoa;
		gravaStatus(result);
		return Response.status(201).entity(result).build();
	}
	
	public void gravaStatus(String msg) throws IOException{
		
		 FileWriter arq = new FileWriter("C:/Documents and Settings/Juninho/SD/EX1ObjetoRest/Registro/registro.txt",true);
	     PrintWriter gravarArq = new PrintWriter(arq);
	     
	       gravarArq.println(msg);
	       gravarArq.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	       gravarArq.println("");
	       gravarArq.flush();
	       gravarArq.close();
           
		
	}
}
