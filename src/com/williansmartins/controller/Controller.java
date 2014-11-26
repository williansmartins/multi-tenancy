package com.williansmartins.controller;
 
import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.enums.Tipo;
import com.williansmartins.utils.Constantes;
 
@Path("/imovel")
public class Controller {
 
	ImovelDaoImpl dao;
	
	public Controller(){
		dao = new ImovelDaoImpl();
	}
	
	@GET
	@Path("/todos")
	@Produces(Constantes.JSON)
	public List<ImovelEntity> todos( ) {
		return dao.findAll();
	}
	
	@GET
	@Path("/quadrantes")
	@Produces(Constantes.JSON)
	public List<ImovelEntity> quadrantes( ) {
		return dao.buscarImoveisQueApresentamNaHome();
	}
	
	@GET
	@Path("/carousel")
	@Produces(Constantes.JSON)
	public List<ImovelEntity> carousel( ) {
		return dao.findCarousel();
	}
	
	@GET
	@Path("/busca/{param}")
	@Produces(Constantes.JSON)
	public Object carousel( @PathParam("param") String param ) {
		List<ImovelEntity> lista = dao.find( param );
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("mensagem nova");
		jsonReturn.setDado(lista);
		jsonReturn.setTipo("sucesso");
		return jsonReturn;
	}
	
	@GET
	@Path("/busca/completa")
	@Produces(Constantes.JSON)
	public List<ImovelEntity> buscaCompleta( 
			@QueryParam("tipo") String tipo,
			@QueryParam("cidade") String cidade,
			@QueryParam("min") String min,
			@QueryParam("max") String max) {
		
		return dao.find(Tipo.get(tipo), cidade, new BigDecimal(min), new BigDecimal(max));
	}
	
	@PUT
	@Path("/update")
	@Produces(Constantes.JSON)
	public ImovelEntity updade(@HeaderParam("nome") String msg) {
		
		ImovelEntity o = new ImovelEntity();
		o.setTitulo( msg  );
		o.setCidade("cidade2");
		o.setEndereco("Maria das Acácias2, 234 - Jd Rosalina - Cotia");
		
		return o;
	}
	
	@POST
	@Path("/post")
	@Produces(Constantes.JSON)
	public ImovelEntity post(@PathParam("param") String msg) {
		
		ImovelEntity o = new ImovelEntity();
		o.setTitulo("Meu titulo2");
		o.setCidade("cidade2");
		o.setEndereco("Maria das Acácias2, 234 - Jd Rosalina - Cotia");
		
		return o;
	}
 
}