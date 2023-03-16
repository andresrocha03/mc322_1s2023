public class Cliente {
    private String nome ;
    private String cpf ;
    private String dataNascimento ;
    private String idade ;
    private String endereco;

    // Construtor
    public Cliente ( String nome , String cpf , String dataNascimento , String idade, String endereco ) {
        this .nome              = nome ;
        this .cpf               = cpf ;
        this .dataNascimento    = dataNascimento ;
        this .idade             = idade;
        this .endereco          = endereco ;
    }

    // Getters e setters
    public String getNome () {
        return nome ;
    }

    public void setNome ( String nome ) {
        this .nome = nome ;
    }

    public String getCpf () {
        return cpf ;
    }

    public void setCpf ( String cpf ) {
        //////VERIFICAR CPF VALIDO
        this . cpf = cpf ;
    }

    public String getDataNascimento () {
        return dataNascimento ;
    }

    public void setDataNascimento ( String dataNascimento ) {
        this . dataNascimento = dataNascimento ;
    }

    public String getIdade () {
        return idade ;
    }

    public void setIdade ( String idade ) {
        this . idade = idade ;
    }
 
 
    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this . endereco = endereco ;
    }

    //TOSTRING
    //VALIDAR CPF

}