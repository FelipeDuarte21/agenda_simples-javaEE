<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../cabecalho.jsp"></jsp:include>

	<div class="container-xl">
		
		<div class="row mt-5 mt-md-3">
			
			<div class="col">
			
				<a href="usuario?acao=login&opcao=1" class="btn btn-outline-secondary">
					<i class="fas fa-undo-alt mr-1"></i>Voltar
				</a>
			
				<h3 class="text-center mt-5"><i class="fas fa-plus mr-1"></i>Cadastrar Usuario</h3>
				
				<div class="row justify-content-center">
					
					<div class="col col-md-5">
					
						<form action="usuario?acao=cadastrar&opcao=2" method="post">
						
							<div class="form-group mt-4">
								<label for="nome" class="mb-0">Nome:</label>
						        <input type="text" name="nome" id="nome" class="form-control">
							</div>
				
						    <div class="form-group mt-4">
						    	<label for="email" class="mb-0">Email:</label>
						        <input type="email" name="email" id="email" class="form-control">
						    </div>
						    
						    <div class="form-group mt-4">
						    	<label for="senha" class="mb-0">Senha:</label>
						        <input type="password" name="senha" id="senha" class="form-control">
						    </div>
						
						    <button type="submit" class="btn btn-success mt-2 mb-3">
						    	<i class="far fa-save mr-1"></i>Cadastrar
						    </button>
						
						</form>
					
					</div>
				
				</div>

			</div>
			
		</div>
		
	</div>

<jsp:include page="../rodape.jsp"></jsp:include>