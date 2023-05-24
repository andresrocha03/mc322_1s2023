import java.util.ArrayList;

public abstract class Cliente {
    private String nome ;
    private String telefone;
    private String endereco;
    private String email;
    
    // Construtor
    public Cliente (String nome, String telefone, String endereco, String email) {
        this.nome              = nome ;
        this.telefone   = telefone;
        this.endereco          = endereco ;
        this.email = email;
    }

    // Getters e setters
    public String getNome () {
        return this.nome;
    }

    public void setNome ( String nome ) {
        this.nome = nome ;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this.endereco = endereco ;
    }

    public String toString() {
        return 
            "nome: " + nome +
            "\ntelefone: " + telefone +
            "\nendereco: " + endereco +
            "\nemail: " + email;
    }
    
}



/* 
   

    //calcular score sera implementado nas subclasses, de acordo com o tipo do cliente
    public abstract double calcularScore();    

     public double getValorSeguro() {
        return this.valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

   
