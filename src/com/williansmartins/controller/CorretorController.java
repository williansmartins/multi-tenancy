package com.williansmartins.controller;
 
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.entity.CorretorEntity;
import com.williansmartins.vo.JSONReturn;
 
@Path("/corretor")
public class CorretorController {
 
	CorretorDaoImpl dao;
	
	public CorretorController(){
		dao = new CorretorDaoImpl();
	}
	
	@GET
	@Path("entidade")
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello() {
		List<CorretorEntity> lista = dao.findAll();
		CorretorEntity corretor = lista.get(0);
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("mensagem nova");
		jsonReturn.setDado( corretor );
		jsonReturn.setTipo( "sucesso" );
		
	    return Response.ok().entity(jsonReturn)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}
 
}