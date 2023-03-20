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
    public String toString (){
        return "Nome: " + this.nome + "\nCPF: " + this.cpf +
                "\nData Nascimento: " + this.dataNascimento + "\nIdade: " +
                this.idade + "\nEndereco: " + this.endereco ;       
    }
    
    public Boolean validarCPF(String cpf) {
        //remover todos os caracteres não numericos do CPF
        cpf = cpf.replaceAll("[^0-9]","");
        
        //verificar se o CPF tem 11 digitos
        if (cpf.length() != 11) {
            return false;
        }
        
        //verificar se todos os digitos sao iguais
        char firstDigit = cpf.charAt(0);  
        char digit;
        int i=0;
        for (i=1; i<11; i++) {
            digit = cpf.charAt(i);
            if (digit != firstDigit) {
                break;
            }
        }
        if (i==11) {
            return false;
        }
        //calcular digitos verificadores
        int soma=0,resto=0;
        int j = 0,aux=0,d1=0;
        for (i=10; i>=2;i--) {
            aux = Character.getNumericValue(cpf.charAt(j));
            soma += i*aux;
            j++;
        }
        resto  = (soma)%11;
        if (resto == 0 || resto == 1) {
            d1 = 0;
        }System.out.printf("i: %d\n",cpf.length());
        
        else {
            d1 = 11 - resto; 
        }
        aux = Character.getNumericValue(cpf.charAt(9));
        if (d1 != aux){
            return false;
        }
        j=0;
        soma=0;
        resto=0;
        
        int d2 = 0;
        for (i=11; i>=2; i--) {
            aux = Character.getNumericValue(cpf.charAt(j));
            soma += i*aux;
            j++;
        }
        resto  = (soma)%11;
        if (resto == 0 || resto == 1) {
            d2 = 0;
        }
        else {
            d2 = 11 - resto; 
        }
        aux = Character.getNumericValue(cpf.charAt(10));
        if (d2 != aux) {
            return false;
        }
        return true;
    }
     
    
}