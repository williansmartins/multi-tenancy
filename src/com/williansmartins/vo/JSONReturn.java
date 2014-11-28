package com.williansmartins.vo;

public class JSONReturn {

	private String tipo;     //sucesso, erro, alerta
	private String mensagem; //mensagem complementar
	private Object dado;     //objeto a retornar para a view

	public JSONReturn( ) {
		super();
	}
	
	public JSONReturn(String tipo, String mensagem, Object dado) {
		super();
		this.tipo = tipo;
		this.mensagem = mensagem;
		this.dado = dado;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Object getDado() {
		return dado;
	}
	public void setDado(Object dado) {
		this.dado = dado;
	}
	
	
}
