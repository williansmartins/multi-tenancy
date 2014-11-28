package com.bethecoder.tutorials.flexjson.common;

import java.util.Date;

import flexjson.JSONSerializer;

public class PrettyPrintTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JSONSerializer serializer = new JSONSerializer().prettyPrint(true); 
		Estudante stud = new Estudante("Sriram", "Kasireddi", 2, new Date());
		
		String jsonStr = serializer.serialize(stud);
		System.out.println(jsonStr);
	}

}
