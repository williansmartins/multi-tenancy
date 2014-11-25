package com.williansmartins.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.FotoEntity;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.enums.Tipo;
import com.williansmartins.massa.ImovelMassa;

@SuppressWarnings("deprecation")
public class ImovelTest {
	ImovelDaoImpl dao;
	ImovelEntity entityMockada1;
	ImovelEntity entityMockada2;
	
	public ImovelTest(){
		dao = new ImovelDaoImpl();
	}

	@Test
	public void buscarUm(){
		List<ImovelEntity> all = dao.findAll();
		Assert.assertEquals(true, dao.findById( all.get(0).getId() ) != null);
	}
	
	
	@Test
	public void inserirERemoverEntity() throws Exception {
		ImovelEntity entityMockada1 = new ImovelEntity();
		entityMockada1 = new ImovelMassa().getImovel1();

		dao.insert(entityMockada1);

		ImovelEntity entityBanco = dao.findById(entityMockada1.getId());
		
		//Testar se inseriu mesmo
		Assert.assertNotNull(entityBanco );
		
		//Testar se as caracteristicas foram inseridas
		Assert.assertTrue(  entityBanco.getCaracteristicas().equals("caracteristica1;caracteristica2;caracteristica3;") );
		
		//Testar se as fotos foram inseridas
		Assert.assertEquals(true, entityBanco.getFotos().size() == 3);
		Assert.assertEquals(false, entityBanco.getFotos().size() == 2);
		Assert.assertEquals(false, entityBanco.getFotos().size() == 4);
		
		//Testar se cadastrou o "mostrar no carousel"
		Assert.assertTrue( entityBanco.isMostrarNoCarousel() );
		
		//Testar se cadastrou o "mostrar na home"
		Assert.assertTrue( entityBanco.isMostrarNaHome() );

		//Testar se removeu a entidade	
		dao.delete(entityMockada1.getId());
		Assert.assertNull(dao.findById(entityMockada1.getId()));
		
		//Testar se insere somente com t�tulo
		entityMockada1 = new ImovelEntity();
		entityMockada1.setTitulo( "Titulo" );
		dao.insert(entityMockada1);
		Assert.assertNotNull(dao.findById(entityMockada1.getId()));

		//Testar se removeu a entidade	
		dao.delete(entityMockada1.getId());
		Assert.assertNull(dao.findById(entityMockada1.getId()));
		

	}

	@Test
	public void listarEntities() throws Exception {
		List<ImovelEntity> listaEntities = new ArrayList<ImovelEntity>();

		// Inserir 10 entities
		for (int cont = 0; cont < 10; cont++) {
			ImovelEntity entityMockada1 = new ImovelEntity();
			entityMockada1 = new ImovelMassa().getImovel1();
			listaEntities.add(entityMockada1);
		}

		dao.insertAll(listaEntities);

		// Testar se inseriu as 10
		Assert.assertTrue(dao.findAll().size() > 9);
		Assert.assertNotNull(dao.findById(listaEntities.get(0).getId()));
		Assert.assertNotNull(dao.findById(listaEntities.get(9).getId()));

		// Remover as entities
		for (ImovelEntity entity : listaEntities) {
			dao.delete(entity.getId());
		}

		// Verificar se elas realmente não estão no banco
		Assert.assertNull(dao.findById(listaEntities.get(0).getId()));
		Assert.assertNull(dao.findById(listaEntities.get(9).getId()));

	}

	@Test
	public void buscarPorTudo( ) throws Exception{
		List<ImovelEntity> lista;
				
		entityMockada1 = new ImovelMassa().getImovel1();
		dao.insert( entityMockada1 );
		entityMockada2 = new ImovelMassa().getImovel2();
		dao.insert( entityMockada2 );

		ImovelEntity entityBanco1 = dao.findById( entityMockada1.getId() );
		ImovelEntity entityBanco2 = dao.findById( entityMockada2.getId() );
		
		//Testar se inseriu mesmo
		Assert.assertNotNull( entityBanco1 );
		Assert.assertNotNull( entityBanco2 );
		
		//Teste passa porque existe
		lista = dao.find(Tipo.APARTAMENTO, "cotia", new BigDecimal(120000), new BigDecimal(160000));
		Assert.assertTrue( lista.size() > 0 );
		
		//Teste passa raspando no preco
		lista = dao.find(Tipo.APARTAMENTO, "cotia", new BigDecimal(150000), new BigDecimal(150000));
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa falha por tipo 
		lista = dao.find(Tipo.CASA, "cotia", new BigDecimal(120000), new BigDecimal(160000) );
		Assert.assertNull( lista );
		
		//Testa falha por cidade 
		lista = dao.find(Tipo.APARTAMENTO, "jaguariuna", new BigDecimal(120000), new BigDecimal(160000) );
		Assert.assertNull( lista );
		
		//Testa falha por preco
		lista = dao.find(Tipo.APARTAMENTO, "cotia", new BigDecimal(120000), new BigDecimal(100000) );
		Assert.assertNull( lista );
		
		//Testa passa com cidade nulla
		lista = dao.find(Tipo.APARTAMENTO, "", new BigDecimal(120000), new BigDecimal(150000) );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa passa com cidade nulla
		lista = dao.find(Tipo.APARTAMENTO, null, new BigDecimal(120000), new BigDecimal(150000) );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa passa com tipo nulla
		lista = dao.find( null, "cotia", new BigDecimal(120000), new BigDecimal(150000) );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa passa com tipo e cidade forem null
		lista = dao.find( null, null, new BigDecimal(120000), new BigDecimal(150000) );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa se passa com somente tipo
		lista = dao.find( Tipo.APARTAMENTO, null, null, null );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa se passa com somente cidade
		lista = dao.find( null, "cotia", null, null );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa se passa com somente max
		lista = dao.find( null, null, new BigDecimal(200000), null );
		Assert.assertTrue( lista.size() > 0 );
		
		//Testa se passa com somente mmin
		lista = dao.find( null, null, null, new BigDecimal(200000) );
		Assert.assertTrue( lista.size() > 0 );
		
		
		//Testar se removeu a entidade	
		dao.delete(entityMockada1.getId());
		dao.delete(entityMockada2.getId());
		Assert.assertNull( dao.findById(entityMockada1.getId()) );
		Assert.assertNull( dao.findById(entityMockada2.getId()) );
	}
	
	@Test
	public void buscarPorTitulo( ) throws Exception{
		ImovelEntity entityMockada1 = new ImovelEntity();
		List<ImovelEntity> lista;
		
		entityMockada1 = new ImovelMassa().getImovel1();
		
		dao.insert( entityMockada1 );
		
		ImovelEntity entityBanco = dao.findById( entityMockada1.getId() );
		
		//Testar se inseriu mesmo
		Assert.assertNotNull( entityBanco );
		
		//Testar se existe encontra o item procurado
		lista = dao.find("Ametista");
		Assert.assertTrue( lista.size() > 0 );
		
		//Testar inverso
		lista = dao.find("asdfg" );
		Assert.assertNull( lista );
		
		//Testar se removeu a entidade	
		dao.delete(entityMockada1.getId());
		Assert.assertNull( dao.findById(entityMockada1.getId()) );
	}

	@Test
	public void buscarSomenteCidades(){
		List<String> cidades = new ArrayList<String>();
		cidades = dao.findCityes();
		Assert.assertEquals(true, cidades.size() == 4);
	}
	
	@Test
	public void buscarImoveisDoCarousel(){
		List<ImovelEntity> lista = dao.findCarousel();
		Assert.assertEquals(true, lista.size() == 3);
	}
	
	@Test
	public void buscarImoveisDaHome(){
		List<ImovelEntity> lista = dao.buscarImoveisQueApresentamNaHome();
		Assert.assertEquals(true, lista.size() == 2);
	}
	
	@Test
	public void testeComFotos(){
		//criar um imovel
		ImovelEntity entity = new ImovelMassa().getImovel1();
		
		//enviar para o banco a entity
		dao.insert( entity );
		
		System.out.println(">>>>" + entity.getId());
		System.out.println(">>>>" + entity.getFotos().get(0).getId());
		System.out.println(">>>>" + entity.getFotos().get(1).getId());
		System.out.println(">>>>" + entity.getFotos().get(2).getId());
		System.out.println("----------");
		
		//remover fotos e atualizar imovel
		entity.getFotos().remove(1);
		dao.update(entity);
		
		System.out.println(">>>>" + entity.getId());
		System.out.println(">>>>" + entity.getFotos().get(0).getId());
		System.out.println(">>>>" + entity.getFotos().get(1).getId());
		
		entity.getFotos().add(new FotoEntity());

		
		System.out.println("----------");
		System.out.println(">>>>" + entity.getId());
		System.out.println(">>>>" + entity.getFotos().get(0).getId());
		System.out.println(">>>>" + entity.getFotos().get(1).getId());
		System.out.println(">>>>" + entity.getFotos().get(2).getId());
	}
	
}