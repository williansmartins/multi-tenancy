package com.williansmartins.utils;

import javax.ws.rs.core.Response;

public class Responses {
	public Response retorno(Object jsonReturn) {
		return Response.ok().entity(jsonReturn)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS").build();
	}
}
