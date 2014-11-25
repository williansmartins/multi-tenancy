package com.williansmartins.controller;
 
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.ImovelEntity;
 
@Path("/imovel")
public class Controller {
 
	@GET
	@Path("/todos")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public ImovelEntity todos(String msg) {
		ImovelDaoImpl dao = new ImovelDaoImpl();
		ImovelEntity o = dao.findById(70);
		return o;
	}
	
	@GET
	@Path("/2")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public ImovelEntity getMsg2(@PathParam("param") String msg) {
		
		ImovelEntity o = new ImovelEntity();
		o.setTitulo("Meu titulo2");
		o.setCidade("cidade2");
		o.setEndereco("Maria das Acácias2, 234 - Jd Rosalina - Cotia");
		
		return o;
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public ImovelEntity updade(@HeaderParam("nome") String msg) {
		
		ImovelEntity o = new ImovelEntity();
		o.setTitulo( msg  );
		o.setCidade("cidade2");
		o.setEndereco("Maria das Acácias2, 234 - Jd Rosalina - Cotia");
		
		return o;
	}
	
	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public ImovelEntity post(@PathParam("param") String msg) {
		
		ImovelEntity o = new ImovelEntity();
		o.setTitulo("Meu titulo2");
		o.setCidade("cidade2");
		o.setEndereco("Maria das Acácias2, 234 - Jd Rosalina - Cotia");
		
		return o;
	}
 
}