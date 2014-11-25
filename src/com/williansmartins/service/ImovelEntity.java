package com.williansmartins.service;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="imovel")
public class ImovelEntity implements Serializable {

	private static final long serialVersionUID = 83908783713350043L;
	
	BigDecimal valor;
	String titulo;
	double metros;
	int dormitorios;
	int suites;
	int banheiros;
	int vagas;
	String cidade;
	String maps;
	String endereco;
	String descricaoCompleta;
	String descricaoQuadrante;
	String descricaoCarousel;
	String fotoGrande;
	String fotoCarousel;
	String fotoQuadrante;
	String recursos;
	String caracteristicas;
	boolean mostrarNoCarousel;
	boolean mostrarNaHome;
	boolean temValor;

	public ImovelEntity() {
		
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getMetros() {
		return metros;
	}

	public void setMetros(double d) {
		this.metros = d;
	}

	public int getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getMaps() {
		return maps;
	}
	
	public void setMaps(String maps) {
		this.maps = maps;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}

	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}

	public String getDescricaoQuadrante() {
		return descricaoQuadrante;
	}

	public void setDescricaoQuadrante(String descricaoQuadrante) {
		this.descricaoQuadrante = descricaoQuadrante;
	}

	public String getDescricaoCarousel() {
		return descricaoCarousel;
	}

	public void setDescricaoCarousel(String descricaoCarousel) {
		this.descricaoCarousel = descricaoCarousel;
	}

	public String getFotoCarousel() {
		return fotoCarousel;
	}

	public void setFotoCarousel(String fotoCarousel) {
		this.fotoCarousel = fotoCarousel;
	}

	public boolean isMostrarNoCarousel() {
		return mostrarNoCarousel;
	}

	public void setMostrarNoCarousel(boolean mostrarNoCarousel) {
		this.mostrarNoCarousel = mostrarNoCarousel;
	}

	public boolean isMostrarNaHome() {
		return mostrarNaHome;
	}

	public void setMostrarNaHome(boolean mostrarNaHome) {
		this.mostrarNaHome = mostrarNaHome;
	}

	public String getRecursos() {
		return recursos;
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getFotoGrande() {
		return fotoGrande;
	}

	public void setFotoGrande(String fotoGrande) {
		this.fotoGrande = fotoGrande;
	}

	public String getFotoQuadrante() {
		return fotoQuadrante;
	}

	public void setFotoQuadrante(String fotoQuadrante) {
		this.fotoQuadrante = fotoQuadrante;
	}

	public boolean isTemValor() {
		return temValor;
	}

	public void setTemValor(boolean temValor) {
		this.temValor = temValor;
	}

	public int getSuites() {
		return suites;
	}

	public void setSuites(int suites) {
		this.suites = suites;
	}

	public int getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(int banheiros) {
		this.banheiros = banheiros;
	}

	@Override
	public String toString() {
		return "ImovelEntity [valor=" + valor + ", titulo=" + titulo
				+ ", metros=" + metros + ", dormitorios=" + dormitorios
				+ ", suites=" + suites + ", banheiros=" + banheiros
				+ ", vagas=" + vagas + ", cidade=" + cidade + ", maps=" + maps
				+ ", endereco=" + endereco + ", descricaoCompleta="
				+ descricaoCompleta + ", descricaoQuadrante="
				+ descricaoQuadrante + ", descricaoCarousel="
				+ descricaoCarousel + ", fotoGrande=" + fotoGrande
				+ ", fotoCarousel=" + fotoCarousel + ", fotoQuadrante="
				+ fotoQuadrante + ", recursos=" + recursos
				+ ", caracteristicas=" + caracteristicas
				+ ", mostrarNoCarousel=" + mostrarNoCarousel
				+ ", mostrarNaHome=" + mostrarNaHome + ", temValor=" + temValor
				+ "]";
	}
	
	
}
