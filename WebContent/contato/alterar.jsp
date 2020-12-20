<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../cabecalho.jsp"></jsp:include>

	<div class="container-xl">
		
		<div class="row justify-content-end">
		
			<div class="col col-md-4 mt-3">
				<span><i class="fas fa-user mr-1"></i>${usuario.nome}</span>
			    <a href="usuario?acao=logout" class="btn btn-sm btn-outline-secondary ml-1">
			    	<i class="fas fa-sign-out-alt mr-1"></i>Sair
			    </a>
			</div>
			
		</div>
		
		<div class="row mt-5 mt-md-3">
			
			<div class="col">
			
				<a href="contato?acao=listar" class="btn btn-outline-secondary">
					<i class="fas fa-undo-alt mr-1"></i>Voltar
				</a>
			
				<h3 class="text-center mt-5"><i class="fas fa-edit mr-1"></i>Alterar Contato</h3>
				
				<div class="row justify-content-center">
					
					<div class="col col-md-5">
					
						<form action="contato?acao=alterar&opcao=2" method="post">
						
							<input type="hidden" name="id" value="${contato.id}">
						
							<div class="form-group mt-4">
								<label for="nome" class="mb-0">Nome:</label>
						        <input type="text" name="nome" id="nome" value="${contato.nome}" class="form-control">
							</div>
							
							<div class="form-group mt-4">
						   		<label for="celular" class="mb-0">Celular</label>
						        <input type="text" name="celular" id="celular" value="${contato.celular}" class="form-control"
						         data-mask="(00) 90000-0000">
						   	</div>
				
						   	<div class="form-group mt-4">
						   		<label for="telefone" class="mb-0">Telefone</label>
						        <input type="text" name="telefone" id="telefone" value="${contato.telefone}" class="form-control"
						         data-mask="(00) 0000-0000">
						   	</div>
						
						    <div class="form-group mt-4">
						    	<label for="email" class="mb-0">Email:</label>
						        <input type="email" name="email" id="email" value="${contato.email}" class="form-control">
						    </div>
						
						    <button type="submit" class="btn btn-info mt-2 mb-3">
						    	<i class="far fa-save mr-1"></i>Alterar
						    </button>
						
						</form>
					
					</div>
				
				</div>

			</div>
			
		</div>
		
	</div>

<jsp:include page="../rodape.jsp"></jsp:include>