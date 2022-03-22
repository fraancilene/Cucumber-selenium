# language: pt

  # cenario de forma declarativa
Funcionalidade: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  Contexto:
    Dado que desejo adicionar uma conta


  Esquema do Cenário: Deve validar regra cadastro contas
    Quando adiciono a conta "<conta>"
#     Quando adiciono uma conta válida - omitindo a massa de dado
    Então recebo a mensagem "<mensagem>"
#    Então a conta é inserida com sucesso

    Exemplos:
      | conta          | mensagem                           |  |
      | Conta de Teste | Conta adicionada com sucesso!      |  |
      |                | Informe o nome da conta            |  |
      | Conta de Teste | Já existe uma conta com esse nome! |  |

#Serão feitos dois métodos com todos os passos de entrar e criar uma conta.