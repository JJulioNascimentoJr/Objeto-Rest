package br.com.ex1.rest;

import java.text.DecimalFormat;

public class Pessoa {
    
	private String nome;
	private int idade;
	private String lp;
	
	private double altura;
	private int peso;
	
	public Pessoa() {
		
	}
    
	DecimalFormat df = new DecimalFormat("00.00");
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getLp() {
		return lp;
	}

	public void setLp(String lp) {
		this.lp = lp;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Eu" + nome +",trabalho e estudo, tenho " + idade + " anos,"
			    + " e adoro programar em " + lp
				+ "\n Eu tenho " + altura + " de altura e tenho " + peso + " Kg"
				+" e meu IMC: "+df.format(peso/(altura*altura))+ " do Peso";
	}
	
	
}
