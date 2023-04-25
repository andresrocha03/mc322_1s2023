import java.time.LocalDate;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private String classeEconomica;
    private String dataNascimento ;
    

    public String getCpf() {
        return this.cpf;
    }
    //construtor
    public ClientePF(String nome, String endereco, String cpf, String genero, LocalDate dataLicenca, String educacao, String classeEconomica, String dataNascimento) {
        super(nome, endereco);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.classeEconomica = classeEconomica;
        this.dataNascimento = dataNascimento;
    }

    //getters and setters
    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLicenca() {
        return this.dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return this.educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getClasseEconomica() {
        return this.classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean validateCPF(String cpf) {
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
        }
        
        else {
            d1 = 11 - resto; 
        }
        aux = Character.getNumericValue(cpf.charAt(9));
        if (d1 != aux){
            System.out.println("O cpf " + cpf + " é inválido");
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
            System.out.println("O cpf " + cpf + " é inválido");
            return false;
        }
        System.out.println("O cpf " + cpf + " é válido");
        return true;
    }
     

    
    public String toString() {
        return 
            super.toString() +
            "cpf: " + cpf +
            "\ngenero: " + genero +
            "\ndataLicenca: '" + dataLicenca +
            "\neducacao: " + educacao +
            "\nclasseEconomica: '" + classeEconomica +
            "\ndataNascimento: " + dataNascimento ;
    }
    
    
}
