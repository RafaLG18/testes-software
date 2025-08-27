# Projeto de Testes de Cadastro de Usuário

Este projeto implementa testes unitários para um sistema de cadastro de usuários, testando diferentes cenários de validação e regras de negócio.

## Estrutura do Projeto

- **Usuario.java**: Classe modelo que representa um usuário com campos nome, endereço, data de nascimento, email, telefone e senha
- **UsuarioNegocio.java**: Classe de serviço responsável por gerenciar as operações de usuário
- **UsuarioRepository.java**: Interface para persistência de dados
- **Tests.java**: Classe de testes unitários usando JUnit 5 e Mockito

## Testes Implementados

### ✅ Testes Completos

1. **`cadastroCamposValidos()`** (linhas 22-35)
   - Testa o cadastro de um usuário com todos os campos válidos
   - Verifica se o usuário é adicionado corretamente
   - **Status**: Implementado e funcional

### ⚠️ Testes Incompletos

Os seguintes testes foram criados mas ainda precisam de implementação das validações e assertions:

2. **`cadastroTelefoneExistente()`** (linhas 37-48)
   - Deve testar a validação quando o telefone já existe no sistema
   - **Faltando**: Lógica de validação e assertion

3. **`cadastroEmailExistente()`** (linhas 50-57)
   - Deve testar a validação quando o email já existe no sistema
   - **Faltando**: Lógica de validação e assertion

4. **`cadastroFaltandoNome()`** (linhas 59-66)
   - Deve testar a validação quando o campo nome está vazio
   - **Faltando**: Lógica de validação e assertion

5. **`cadastroFaltandoEndereco()`** (linhas 68-75)
   - Deve testar a validação quando o campo endereço está vazio
   - **Faltando**: Lógica de validação e assertion

6. **`cadastroFaltandoData()`** (linhas 77-84)
   - Deve testar a validação quando o campo data está vazio
   - **Faltando**: Lógica de validação e assertion

7. **`cadastroFaltandoEmail()`** (linhas 86-93)
   - Deve testar a validação quando o campo email está vazio
   - **Faltando**: Lógica de validação e assertion

8. **`cadastroFaltandoTelefone()`** (linhas 95-102)
   - Deve testar a validação quando o campo telefone está vazio
   - **Faltando**: Lógica de validação e assertion

9. **`cadastroSenhaForte()`** (linhas 104-111)
   - Deve testar a validação de senha forte
   - **Faltando**: Lógica de validação e assertion

10. **`cadastroSenhaFraca()`** (linhas 113-120)
    - Deve testar a validação de senha fraca (senha "1234")
    - **Faltando**: Lógica de validação e assertion

## Próximos Passos

Para completar a implementação dos testes, é necessário:

1. **Implementar validações na classe `UsuarioNegocio`**:
   - Validação de campos obrigatórios
   - Validação de duplicidade (email e telefone)
   - Validação de força da senha

2. **Adicionar mocks e stubs apropriados** nos testes para simular:
   - Usuários existentes no repositório
   - Diferentes cenários de retorno do repositório

3. **Implementar assertions** para verificar:
   - Exceções lançadas para casos inválidos
   - Valores retornados para casos válidos
   - Comportamento esperado do sistema

4. **Adicionar testes de integração** se necessário

## Como Executar os Testes

```bash
# Executar todos os testes
mvn test

# Executar apenas a classe de testes
mvn test -Dtest=cadastro.Tests
```

## Tecnologias Utilizadas

- **JUnit 5**: Framework de testes
- **Mockito**: Framework para criação de mocks
- **Java**: Linguagem de programação
- **Maven**: Gerenciador de dependências