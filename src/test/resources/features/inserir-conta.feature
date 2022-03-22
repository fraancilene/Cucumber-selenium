# language: pt

  # cenario imperativo
Funcionalidade: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  Contexto:
    Dado que estou acessando a aplicação
    Quando informo o usuário "Fran@silva"
    E a senha "123456"
    E seleciono entrar
    Então  visualizo a página inicial
    Quando seleciono contas
    E seleciono adicionar

  Esquema do Cenário: Deve validar regra cadastro contas
    Quando informo a conta "<conta>"
    E seleciono salvar
    Então recebo a mensagem "<mensagem>"

    Exemplos:
      | conta          | mensagem                           |  |
      | Conta de Teste | Conta adicionada com sucesso!      |  |
      |                | Informe o nome da conta            |  |
      | Conta de Teste | Já existe uma conta com esse nome! |  |

