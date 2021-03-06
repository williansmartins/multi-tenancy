$(document).ready( function(){
	
	if($("body").hasClass("admin-imovel") ){
		//$('#myTab a:last').tab('show');
		var tab = GetURLParameter('tab');
		if(tab==undefined){
			$('#myTab #tab-home').tab('show');
		}else{
			$('#myTab #'+tab+'').tab('show');
		}
//		$("#myTab a").click(function(){
//			document.location.search = "tab="+$(this).attr('id');
//		});
	}
	
	if($("body").hasClass("clientes") ){
		$("#form-clientes\\:fixo").mask("(99) 9999-9999");
		$("#form-clientes\\:celular").focusout(function(){
	        var phone, element;
	        element = $(this);
	        element.unmask();
	        phone = element.val().replace(/\D/g, '');
	        if(phone.length > 10) {
	            element.mask("(99) 99999-999?9");
	        } else {
	            element.mask("(99) 9999-9999?9");
	        }
	    }).trigger('focusout');
	}
	    
	if($("body").hasClass("corretor") ){
		$("#form-corretor\\:fixo").mask("(99) 9999-9999");
		$("#form-corretor\\:celular").focusout(function(){
	        var phone, element;
	        element = $(this);
	        element.unmask();
	        phone = element.val().replace(/\D/g, '');
	        if(phone.length > 10) {
	            element.mask("(99) 99999-999?9");
	        } else {
	            element.mask("(99) 9999-9999?9");
	        }
	    }).trigger('focusout');
	}
	    
	//Bloquear o botao direito do mouse
	var mensagem = "Não copie, além de imoral é crime!";
	
//	if (document.layers) {
//		document.captureEvents(Event.MOUSEDOWN);
//		document.onmousedown = clickNS;
//	} else {
//		document.onmouseup = clickNS;
//		document.oncontextmenu = clickIE;
//	}
//	document.oncontextmenu = new Function("return false");
    
	$('#modal-cliente\\:interesse').val( $('.titulo').html() );
	$('#modal-cliente\\:imovel_id').val( $('#form-imovel\\:imovel_id_imovel').val() );
	
	if($("body").hasClass("home") ){
		
		$.ajax({
			type:"GET",
			url:"http://localhost:7070/jersey/rest/corretor/busca",
			async:false,
			dataType:"json",
			success: function( response ){
				if ( response.tipo == "erro" ){
					alert( "É triste dizer, mas houve um erro:" + response.mensagem );
				}else if ( response.tipo == "sucesso" ){
					$(".topo .telefone").valy( response.dado.telefone );
					$(".topo .email").valy( response.dado.email );
					
					$(".corretor .nome").valy( response.dado.nome );
					$(".corretor .telefone").valy( response.dado.telefone );
					$(".corretor .celular").valy( response.dado.celular );
					$(".corretor .email").valy( response.dado.email );
					
				}
			}
		});
	    
		//Permite o clique no quadrante chamando a tela do imovel especifico
		$(".imovel.quadrante").css( "cursor", "pointer" );
		$(".imovel.quadrante").click(function (){
			console.info($(this).attr("data-imovel-id"));
			window.location.replace("imovel.xhtml?imovel_id=" + $(this).attr("data-imovel-id") );
		});
		
		$('#slider').slider({
			formater: function(value) {
				return 'R$ ' + addCommas(value);
			}
		});
	}

	if($("body").hasClass("resultado")){
		
		//Permite o clique no quadrante chamando a tela do imovel especifico
		$(".imovel.quadrante").css( "cursor", "pointer" );
		$(".imovel.quadrante").click(function (){
			console.info($(this).attr("data-imovel-id"));
			window.location.replace("imovel.xhtml?imovel_id=" + $(this).attr("data-imovel-id") );
		});
		
	}
		
	if($("body").hasClass("imovel")){
		//$('.dropdown-toggle').dropdown();
		
		$('.show-image').click(function(){
			$('.imagem-grande').attr( 'src', 'img/' + $(this).attr('data-url') );
		});
		
		//Apresentaçao das caracteristicas e recursos em formato de lista
	    var arr = $("#caracteristicas").attr("data-valor").split(";");
	    for(var i = 0; i < arr.length; i++){
	    	$("#caracteristicas").append( "<li>" + arr[i] + "</li>" );
	    }
	    
	    var arr = $("#recursos").attr("data-valor").split(";");
	    console.info(arr);
	    for(var i = 0; i < arr.length; i++){
	    	$("#recursos").append( "<li>" + arr[i] + "</li>" );
	    }
	    
	    $(".telefone").mask("(99) 9999-9999");
	    $(".celular").focusout(function(){
	        var phone, element;
	        element = $(this);
	        element.unmask();
	        phone = element.val().replace(/\D/g, '');
	        if(phone.length > 10) {
	            element.mask("(99) 99999-999?9");
	        } else {
	            element.mask("(99) 9999-9999?9");
	        }
	    }).trigger('focusout');
	    
	}


    //$('#myTab a:first').tab('show');
    
//    $("input[name=radio-home]").prop("checked", true).trigger("click");
//    $("input[name=radio-carousel]").prop("checked", true).trigger("click");

    $("#option1").change(function (e){
    	$("#imovel-form\\:radio1").val(true);
    });
    $("#option2").change(function (e){
    	$("#imovel-form\\:radio1").val(false);
    });
    
    $("#option3").change(function (e){
    	$("#imovel-form\\:radio2").val(true);
    });
    $("#option4").change(function (e){
    	$("#imovel-form\\:radio2").val(false);
    });
    
    $("#option5").change(function (e){
    	$("#imovel-form\\:radio3").val(true);
    });
    $("#option6").change(function (e){
    	$("#imovel-form\\:radio3").val(false);
    });
    
    $(".popularImovel").click(function (e){
    	e.preventDefault();
    	$('#imovel-form\\:titulo').val("Residencial Ametista")
    	$('#imovel-form\\:valor').val("150000")
    	$('#imovel-form\\:dormitorios').val("2")
    	$('#imovel-form\\:metros').val("54.0")
    	$('#imovel-form\\:vagas').val("1")
    	$('#imovel-form\\:cidade').val("Cotia")
    	$('#imovel-form\\:fita').val("pre")
    	
    	$('#imovel-form\\:descricaoCompleta').val("descricaoCompleta")
    	$('#imovel-form\\:descricaoQuadrante').val("descricaoQuadrante")
    	$('#imovel-form\\:descricaoCarousel').val("descricaoCarousel")
    	
    	$('#imovel-form\\:caracteristicas').val("caracteristica1;caracteristica2;caracteristica2;caracteristica3")
    	$('#imovel-form\\:recursos').val("recurso1;recurso2;recurso2;recurso3")
    	
    	$('#imovel-form\\:maps').val("https://www.google.com/maps/embed?pb=!1m20!1m8!1m3!1d1829.4916250485917!2d-46.8514345!3d-23.4971128!3m2!1i1024!2i768!4f13.1!4m9!1i0!3e6!4m0!4m5!1s0x94cf023b1a960943%3A0xc7c573393bf1f502!2sAlphaville+Comercial%2C+Barueri+-+SP!3m2!1d-23.4970209!2d-46.851323699999995!5e0!3m2!1spt-PT!2sbr!4v1412624406079")
    	$('#imovel-form\\:endereco').val("Rua Amapá, 345 - Jardim Rosalina - Cotia - SP - 06608-430")
    });
    
});
function check(){
	var valores = $("input[name='preco']").val().split(",");
	$("input[name='min']").val( valores[0] );
	$("input[name='max']").val(valores[1]);
}

function clickIE() {
	if (document.all) {
		(mensagem);
		return false;
	}
}
function clickNS(e) {
	if ( document.layers ) {
		if (e.which == 2 || e.which == 3) {
			alert(mensagem);
			return false;
		}
	}
}

function mostrar( item ){
	//$('#myTab a:last').tab('show');
	$(item).parent().first().hide();
}

function GetURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++)

    {
        var sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] == sParam)
        {
            return sParameterName[1];
        }
    }
}
function addCommas(nStr)
{
    nStr += '';
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + '.' + '$2');
    }
    return x1 + x2;
}

function validaFormCliente(){
	if( $("#modal-cliente\\:interesse").val() == "" ){
		alert("Favor preencher o campo de interesse");
		return false;
	}else{
		if( $("#modal-cliente\\:nome").val() == "" ){
			alert("Favor preencher o campo de nome");
			return false;
		}else{
			if( $("#modal-cliente\\:email").val() == "" ){
				alert("Favor preencher o campo de email");
				return false;
			}else{
				if( !validateEmail( $("#modal-cliente\\:email").val() )  ){
					alert("Email em formato incorreto, por favor corrigir");
					return false;
				}else{
					if( $("#modal-cliente\\:telefone").val() == "" ){
						alert("Favor preencher o campo de telefone");
						return false;
					}else{
						if( $("#modal-cliente\\:celular").val() == "" ){
							alert("Favor preencher o campo de celular");
							return false;
						}else{
							alert('Mensagem enviada com sucesso!');
							return true;
						}
					}
				}
			}
		}
	}
}

function validateEmail(email) 
{
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
}

function imovelController($scope,$http) {
  	$http.get("http://localhost:7070/jersey/rest/imovel/quadrantes")
  		.success(function(response) {
  			$scope.tipo = response.tipo;
  			$scope.imoveis = response.dado;
  			$scope.mensagem = response.mensagem;

  			if (response.tipo == "erro"){
				alert("É uma pena, mas um erro ocorreu... e a única coisa que posso te falar é: " + response.mensagem);
			}
  			
  		})
  		.error(function(data, status, headers, config) {
	  	    alert("É uma pena, mas um erro ocorreu... e foi na hora de buscar um tal de Jason");
	  	});
}

function imovelCarouselControler($scope,$http) {
	$http.get("http://localhost:7070/jersey/rest/imovel/carousel")
	.success(function(response) {
		$scope.tipo = response.tipo;
		$scope.imoveis = response.dado;
		$scope.mensagem = response.mensagem;
		
		if (response.tipo == "erro"){
			alert("É uma pena, mas um erro ocorreu... e a única coisa que posso te falar é: " + response.mensagem);
		}
		
	})
	.error(function(data, status, headers, config) {
		alert("É uma pena, mas um erro ocorreu... e foi na hora de buscar um tal de Jason");
	});
}
