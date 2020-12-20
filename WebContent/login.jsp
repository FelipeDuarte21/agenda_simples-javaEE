<jsp:include page="cabecalho.jsp"></jsp:include>

	<div class="container">
		
		<div class="row justify-content-center">
			
			<div class="card mt-5">
				
				
				<div class="card-body">
				
					<h6 class="text-center mb-3">
						<i class="fas fa-book-open mr-1"></i>Agenda de Contatos
					</h6>
					
					<form action="usuario?acao=login&opcao=2" method="post">
					
						<div class="form-group mt-4">
							<label for="email" class="mb-0">Email:</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text"><i class="fas fa-envelope"></i></div>
						        </div>
						        <input type="email" name="email" id="email" class="form-control" 
						        	placeholder="seuemail@email.com">
							</div>
						</div>
		
						<div class="form-group mt-3">
							<label for="senha" class="mb-0">Senha:</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text"><i class="fas fa-key"></i></div>
								</div>
								<input type="password" name="senha" id="senha" class="form-control"
									placeholder="sua senha">
							</div>	
							
						</div>
						
						<div class="col px-0 mt-4 mb-0">
							<button type="submit" class="btn btn-primary"><i class="fas fa-sign-in-alt mr-1"></i>Entrar</button>
						</div>	
					
					</form>
					
				</div>
				
				<div class="card-footer py-0">
					<p class="text-center m-0 p-2">Ainda não tem uma conta? cadastre <a href="usuario?acao=cadastrar&opcao=1">aqui!</a></p>
				</div>
			
			</div>
			
		</div>
	
	</div>

<jsp:include page="rodape.jsp"></jsp:include>