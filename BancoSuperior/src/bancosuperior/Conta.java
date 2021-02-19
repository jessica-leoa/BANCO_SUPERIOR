package bancosuperior;

/**
 * @author jessica
 */

public class Conta {
    
    //Informacoes que todos os usuários deverao ter, coisas mais especificas serao declaradas em uma classe chamada cliente
    String nome;
    String cpf;
    String numeroConta;
    String agencia;
    char tipoConta;
    boolean status;
    private float saldo; //Dado encapsulado
    
    //Variável de classe
    float TAXA_TRANSFERENCIA = 2.0f;
    
    //Construtor da classe, informacoes obrigatória ao se instanciar um objeto do tipo conta, para que nao seja um objeto sem argumentos
    public Conta( String nome, String cpf, String numeroConta, String agencia, char tipoConta)
    {
       this.nome = nome;
       this.cpf = cpf;
       this.agencia = agencia;
       this.numeroConta = numeroConta;
       this.tipoConta = tipoConta;
       this.status = true;
       this.saldo = 0f;
       
    }
    
    // Métodos especiais: acessores e modificadores (GET e SET)
    //Utilizo para proteger variáveis críticas de uma instancia, limitando seu acesso através de uma funcao ou mais quando for uma regra de negócio do sistema
    //EX: como nesse caso eu já tenho o método depositar, só preciso do método de visualizar o saldo, já que ele é privado.
    
    public float getSaldo()
    {
        return this.saldo;
    }
    

    Conta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //Método para mostrar atributos de uma instancia (Usando o método toString, método herdado da classe Object, classe mae dos objetos em java, ou seja, qualquer classe criada em java é uma subclasse do Objected )
    //Esse método vai imprimir os atributos em formato de String

    @Override
    public String toString() {
        return "========>  Conta  <======== \r\n" + "Nome: " + nome + "CPF" + cpf + "\r\nNumero da Conta: " + numeroConta + "\r\nAgencia: " + agencia + "\r\nTipo de Conta: " + tipoConta + "\r\nStatus da conta: " + status + "\r\nSaldo: " + saldo + "\r\n===========================";
    }
      
   //Método depositar valor na conta
      //Sempre atribuir nomes intuitivos para dar mais clareza ao que o método faz sem precisar estudar seu escopo
    public void depositar(float valorDepositado)
    {
        if(this.status == true && valorDepositado > 0) 
            this.saldo += valorDepositado;
        //OBS: nesse momento seria importante colocar tratamento de erro, mas só verei em proximas aulas
    }
    
    //Método para desativar conta (Nao passei argumentos pq é apnas um valor lógico com dois estado, como antes era true, agora é false)
    public void desativarConta()
    {
        this.status = false;
    }
    
    //Método sacar
    public void sacar(float valorSacado)
    {
        if(this.saldo >= valorSacado && valorSacado > 0 && this.status)
            this.saldo -= valorSacado;
    }
    
    //Método transferir 
    public void transferir(Conta contaDestino, float valorTransferido) //contaDestino é do tipo conta, classe que eu criei.
    {
        //Checo apenas o basico, pq o método sacar já checa algumas condicoes no escopo do método
        if(this.tipoConta == contaDestino.tipoConta){
            this.sacar(valorTransferido);
            contaDestino.depositar(valorTransferido);
        }else{
            this.sacar(TAXA_TRANSFERENCIA);
            this.sacar(valorTransferido);
            contaDestino.depositar(valorTransferido);
        }
    }
    
    
}