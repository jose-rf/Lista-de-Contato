# 📒 Agenda de Contatos

## 📌 Visão Geral
O **Agenda de Contatos** é um sistema desenvolvido em **Java** e **MySQL** que permite cadastrar, listar, pesquisar, editar e excluir contatos de forma simples e organizada. O projeto segue o padrão **MVC (Model-View-Controller)** para melhor estruturação do código.

---

## 🚀 Funcionalidades
✅ **Cadastro de Contatos** → Permite registrar novos contatos com nome, email e telefone.  
✅ **Listagem de Contatos** → Exibe todos os contatos cadastrados no banco de dados.  
✅ **Pesquisa de Contatos** → Busca um contato específico pelo telefone.  
✅ **Alteração de Contatos** → Permite modificar os dados de um contato existente.  
✅ **Exclusão de Contatos** → Remove um contato da tabela `CLIENTES`.  

---

## 🏗️ Estrutura MVC
### 📂 **Model (Modelo)**
Representa os dados do sistema.  
- `Contatos.java` → Define os atributos dos contatos (`id`, `nome`, `email`, `contato`).

### 📂 **View (Visão)**
Interface gráfica que interage com o usuário.  
- `TelaInicial.java` → Tela principal.  
- `TelaCadastro.java` → Tela para cadastrar contatos.  
- `PesquisaDeCliente.java` → Tela de pesquisa de contatos.  
- `TelaAlteracaoClientes.java` → Tela de edição e exclusão de contatos.  
- `Listagem.java` → Tela que exibe todos os contatos cadastrados.  

### 📂 **Controller (Controlador)**
Gerencia as regras de negócio e operações no banco de dados.  
- `ClienteRepository.java` → Contém os métodos **CRUD** (`inserir`, `selecionar`, `atualizar`, `deletar`).  
- `ConexaoMySQL.java` → Gerencia a conexão com o banco MySQL.  
- `Crud.java` → Interface que padroniza as operações CRUD.  

---

## 🛠️ Configuração do Banco de Dados
Antes de rodar o projeto, **crie o banco de dados** e a tabela executando este script no MySQL:

```sql
CREATE DATABASE AgendaDeContatos;
USE AgendaDeContatos;

CREATE TABLE CLIENTES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    contato VARCHAR(20) NOT NULL UNIQUE
);

SELECT * FROM CLIENTES;
