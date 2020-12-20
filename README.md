# Sistema-Simples-de-Contato
Sistema simples de Contato feito através de Java Web 

#Rodar o sistema:
- Tenha um banco de dados instalado
- Rodar o seguinte comando no banco de dados:

create database contatos default charset utf8 default collate utf8_general_ci;

use create;

create table usuario(
	id int not null auto_increment,
    nome varchar(50) not null,
    email varchar(50) not null,
    senha varchar(15) not null,
    primary key(id)
)default char set utf8;

create table contato(
	id int not null auto_increment,
    nome varchar(50) not null,
    celular varchar(12) not null,
    telefone varchar(11) not null,
    email varchar(80) not null,
    id_usuario int not null,
    primary key(id),
    foreign key(id_usuario) references usuario(id)
)default char set utf8;

Obs: Em caso erro verifique os seguintes atributos da classe Conexão: Url, sgbd, usuario, senha, bd
Obs: Este sistema está usando o mysql

- Tenha instalado o eclipse e o tomcat como servidor
- Importe o projeto para eclipse e coloque no servidor tomcat instalado na maquina e inicialize ele
- Acesse através do navegador a seguinte url: localhost:8080/Contatos
- Crie um um usuario novo através do link no radape do card de login
- Em seguida faça login como o usuario recem cadastrado

#Licença:
- Este codigo é somente para uso de estudo e exemplo.
- Em caso de uso do sistema deve ser atribuido a autoria a Felipe Duarte - felipe15lfde@gmail.com.