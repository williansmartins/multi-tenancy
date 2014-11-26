package com.williansmartins.enums;

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
	
	@Override
    public String toString() {
        return this.getLabel();
    }
}
