package br.com.bank.model;

public class Conta {

	private double saldo;
	private String cpf;
	private String nome;

	public Conta(String cpf, String nome, double saldo) {
		this.cpf = cpf;
		this.nome = nome;
		this.saldo = saldo;
	}

	public String getCpf() {
		return cpf;
	}

	public String getnome() {
		return nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
