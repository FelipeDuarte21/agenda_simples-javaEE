<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../cabecalho.jsp"></jsp:include>

	<div class="container-xl">
	
		<div class="row">
		
			<div class="col-12 mt-5">
			
				<div class="alert alert-success text-center">
				  <h4 class="alert-heading"><i class="far fa-smile mr-1"></i>Sucesso!</h4>
				  <p>Operação Realizada Com Sucesso!</p>
				</div>
			
			</div>
			
			<div class="col-12 mt-4">
				<p class="text-center">
					<a href="contato?acao=listar" class="btn btn-outline-secondary">
						<i class="far fa-list-alt mr-1"></i>Listar Contatos
					</a>
				</p>
			</div>
		
		</div>
	
	</div>


<jsp:include page="../rodape.jsp"></jsp:include>