package com.williansmartins.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.williansmartins.dao.entity.CorretorDaoImpl;
import com.williansmartins.entity.CorretorEntity;
import com.williansmartins.utils.Constantes;
import com.williansmartins.utils.Responses;
import com.williansmartins.vo.JSONReturn;

@Path("/corretor")
public class CorretorController extends Responses {

	CorretorDaoImpl dao;

	public CorretorController() {
		dao = new CorretorDaoImpl();
	}

	@GET
	@Path("entidade")
	@Produces(Constantes.JSON)
	public Response hello() {
		List<CorretorEntity> lista = dao.findAll();
		CorretorEntity corretor = lista.get(0);
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("mensagem nova");
		jsonReturn.setDado(corretor);
		jsonReturn.setTipo("sucesso");

		return retorno(jsonReturn);
	}

	@GET
	@Path("entidade2")
	@Produces(Constantes.JSON)
	public CorretorEntity entidade2() {
		List<CorretorEntity> lista = dao.findAll();
		CorretorEntity corretor = lista.get(0);
		return corretor;
	}

	@POST
	@Produces(Constantes.JSON)
	@Path("/consumidor")
	public Response post(@FormParam("nome") String nome,
			@FormParam("telefone") String telefone,
			@FormParam("email") String email) {
		System.out.println(nome);
		CorretorEntity entity = dao.findAll().get(0);
		return Response
				.ok()
				.entity(entity)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/consumidor1")
	public Response post1( ) {
		CorretorEntity entity = dao.findAll().get(0);
		return Response
				.ok()
				.entity(entity)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/consumidor2")
	public Response post2( CorretorEntity c ) {
		System.out.println(c);
		CorretorEntity entity = dao.findAll().get(0);
		return Response
				.ok()
				.entity(entity)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	@GET
	@Produces(Constantes.JSON)
	@Path("/get")
	public Response gett() {
		CorretorEntity entity = dao.findAll().get(0);
		return Response
				.ok()
				.entity(entity)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

}
