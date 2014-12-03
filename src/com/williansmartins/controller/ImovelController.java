package com.williansmartins.controller;
 
import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.enums.Tipo;
import com.williansmartins.utils.Constantes;
import com.williansmartins.utils.Responses;
import com.williansmartins.vo.JSONReturn;
 
@Path("/imovel")
public class ImovelController {
 
	ImovelDaoImpl dao;
	
	public ImovelController(){
		dao = new ImovelDaoImpl();
	}
	
	@GET
	@Path("/todos")
	@Produces(Constantes.JSON)
	public Object todos( ) {
		List<ImovelEntity> lista = dao.findAll();
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("mensagem nova");
		jsonReturn.setDado(lista);
		jsonReturn.setTipo("sucesso");
		return new Responses().retorno(jsonReturn);
	}
	
	@GET
	@Path("/{id}")
	@Produces(Constantes.JSON)
	public Object get(@PathParam("id")Integer id) {
		ImovelEntity entity = dao.findById(id);
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("mensagem nova");
		jsonReturn.setDado(entity);
		jsonReturn.setTipo("sucesso");
		return new Responses().retorno(jsonReturn);
	}
	
	@GET
	@Path("/quadrantes")
	@Produces(Constantes.JSON)
	public Object quadrantes( ) {
		List<ImovelEntity> lista = dao.buscarImoveisQueApresentamNaHome();
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("mensagem nova");
		jsonReturn.setDado(lista);
		jsonReturn.setTipo("sucesso");
		return new Responses().retorno(jsonReturn);
	}
	
	@GET
	@Path("/carousel")
	@Produces(Constantes.JSON)
	public Object carousel( ) {
		List<ImovelEntity> lista = dao.findCarousel();
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("mensagem nova");
		jsonReturn.setDado(lista);
		jsonReturn.setTipo("sucesso");
		return new Responses().retorno(jsonReturn);
	}
	
	@GET
	@Path("/cidades")
	@Produces(Constantes.JSON)
	public Object cidades( ) {
		List<String> lista = dao.findCityes();
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("mensagem nova");
		jsonReturn.setDado(lista);
		jsonReturn.setTipo("sucesso");
		return new Responses().retorno(jsonReturn);
	}
	
	@GET
	@Path("/tipos")
	@Produces(Constantes.JSON)
	public Object tipos( ) {
		List<String> lista = Tipo.getLabels();
		
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("mensagem nova");
		jsonReturn.setDado(lista);
		jsonReturn.setTipo("sucesso");
		return new Responses().retorno(jsonReturn);
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
		return new Responses().retorno(jsonReturn);
	}
	
	@GET
	@Path("/busca/{tipo}/{cidade}/{min}/{max}")
	@Produces(Constantes.JSON)
	public Object completa( @PathParam("tipo") String tipo, 
			@PathParam("cidade") String cidade,
			@PathParam("min") String min,
			@PathParam("max") String max) {
		
		BigDecimal minB = null;
		BigDecimal maxB = null;
		
		if( !min.equals("undefined") ){ minB = new BigDecimal(min); }
		if( !max.equals("undefined") ){ maxB = new BigDecimal(max); }
		
		List<ImovelEntity> lista = dao.find(Tipo.get(tipo), cidade, minB, maxB);
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("mensagem nova");
		jsonReturn.setDado(lista);
		jsonReturn.setTipo("sucesso");
		return new Responses().retorno(jsonReturn);
	}
	
	@DELETE
	@Path("/delete")
	@Produces(Constantes.JSON)
	public Object delete( @HeaderParam("id") Integer id ) {
		dao.delete( id );
		JSONReturn jsonReturn = new JSONReturn();
		jsonReturn.setMensagem("Item excluído com sucesso");
		jsonReturn.setDado(new ImovelEntity());
		jsonReturn.setTipo("sucesso");
		return new Responses().retorno(jsonReturn);
	}
			
	@PUT
	@Path("/update")
	@Produces(Constantes.JSON)
	public ImovelEntity updade(@HeaderParam("nome") String msg) {
//		ImovelEntity o = new ImovelEntity();
//		o.setTitulo( msg  );
//		o.setCidade("cidade2");
//		o.setEndereco("Maria das Acácias2, 234 - Jd Rosalina - Cotia");
		return null;
	}
	
	@POST
	@Path("/post")
	@Produces(Constantes.JSON)
	public ImovelEntity post(@PathParam("param") String msg) {
//		ImovelEntity o = new ImovelEntity();
//		o.setTitulo("Meu titulo2");
//		o.setCidade("cidade2");
//		o.setEndereco("Maria das Acácias2, 234 - Jd Rosalina - Cotia");
		return null;
	}
 
}