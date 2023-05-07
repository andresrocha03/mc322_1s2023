import java.time.LocalDate;

public class ClientePJ extends Cliente{
    private String CNPJ;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;

    //construtor
    public ClientePJ(String nome, String endereco, String CNPJ, LocalDate dataFundacao, double valorSeguro, int qtdeFuncionarios) {
        super(nome, endereco,valorSeguro);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }


    public LocalDate getDataFundacao() {
        return this.dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public Boolean validateCNPJ(String cnpj) {
        //remover todos os caracteres não numericos do cnpj
        cnpj = cnpj.replaceAll("[^0-9]","");
        
        //verificar se o CNPJ tem 16 digitos
        if (cnpj.length() != 14) {
            System.out.println("O cnpj " + cnpj + " é inválido");
            return false;
        }
        
        //verificar se todos os digitos sao iguais
        char firstDigit = cnpj.charAt(0);  
        char digit;
        int i=0;
        for (i=1; i<12; i++) {
            digit = cnpj.charAt(i);
            if (digit != firstDigit) {
                break;
            }
        }
        if (i==12) {
            System.out.println("O cnpj " + cnpj + " é inválido");
            return false;
        }

        //calcular digitos verificadores
            //d1
        int soma=0,resto=0;
        int j = 5,aux=5,d1=0;
        for (i=0; i<=3;i++) {
            aux = Character.getNumericValue(cnpj.charAt(i));
            soma += j*aux;
            j--;
        }
        j = 9;
        for (i=4; i<=11;i++) {
            aux = Character.getNumericValue(cnpj.charAt(i));
            soma += j*aux;
            j--;
        }
        resto  = (soma)%11;
        if (resto == 0 || resto == 1) {
            d1 = 0;
        }
        
        else {
                d1 = 11 - resto; 
            }
        aux = Character.getNumericValue(cnpj.charAt(12));
        if (d1 != aux){
            System.out.println("O cnpj " + cnpj + " é inválido");
            return false;
        }
    
            //d2
        int d2 = 0;
        j = 6;
        aux=0;
        soma=0;
        resto=0;
        for (i=0; i<=4;i++) {
            aux = Character.getNumericValue(cnpj.charAt(i));
            soma += j*aux;
            j--;
        }
        j = 9;
        for (i=5; i<=12;i++) {
            aux = Character.getNumericValue(cnpj.charAt(i));
            soma += j*aux;
            j--;
        }
        resto  = (soma)%11;
        if (resto == 0 || resto == 1) {
            d2 = 0;
        }
        
        else {
                d2 = 11 - resto; 
        }
        aux = Character.getNumericValue(cnpj.charAt(13));
        if (d2 != aux){
            System.out.println("O cnpj " + cnpj + " é inválido");
            return false;
        }
        System.out.println("O cnpj " + cnpj + " é válido");
        return true;
    }
    
    public double calculaScore() {
        return super.calculaScore() + (1+ (qtdeFuncionarios/100) * qtdCarros);
    }
    
    //toString
    public String toString() {
        return 
            super.toString() +
            "\nCNPJ: " + getCNPJ() + 
            "\ndataFundacao: " + getDataFundacao() ;
    }

}