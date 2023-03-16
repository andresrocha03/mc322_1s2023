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

    public String getCPF () {
        return cpf ;
    }

    public void setCPF ( String cpf ) {
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
    ////////////////////// é pra retornar ou pra printar??? é pra retornar o nome mesmo ?????  ///////////////////////////////////////////////////////////////////////////
    public void ToString (){
        System.out.print(nome);
        return nome;
    }
    
    public Boolean ValidarCPF(String cpf) {
        
        cpf.replaceAll("[^0-9]","");
        
        if (cpf.length() != 11) {
            return false;
        }
        
        for ////
        int soma=0,resto=0;
        int j = 0;
        
        for (int i=10; i>=2;i--) {
            soma += i*Integer.parseInt(cpf.charAt(j));
            j++;
        }
        resto  = (soma*10)%11;
        
        if (resto != Integer.parseInt(cpf.charAt(9))){
            return false;
        }

        j=0;
        soma=0;
        resto=0;
        for (int i=11; i>=2; i--) {
            soma += i*Integer.parseInt(cpf.charAt(j));
            j++;
        }
        resto  = (soma*10)%11;
        if (resto != Integer.parseInt(cpf.charAt(10))) {
            return false;
        }
        return true;
}