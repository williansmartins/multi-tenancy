package com.williansmartins.enums;

import java.util.ArrayList;
import java.util.List;

public enum Tipo {
	APARTAMENTO("Apartamento"), CASA("Casa"), QUALQUER("Qualquer"), SALA_COMERCIAL("Sala comercial"), TERRENO("Terreno");
	
	private String label;
	
	private Tipo(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
	
	public static Tipo get(String tipo){
		Tipo retorno = null;
		for (Tipo t : Tipo.values()) {
			if( t.getLabel() == tipo ){
				retorno = t;
			}
		}
		return retorno;
	}
	
	public static List<String> getLabels(){
		List<String> lista = new ArrayList<String>();
		for (Tipo t : Tipo.values()) {
			lista.add( t.getLabel() );
		}
		return lista;
	}
	
	@Override
    public String toString() {
        return this.getLabel();
    }
}
