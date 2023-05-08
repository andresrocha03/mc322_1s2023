import java.time.LocalDate;
import java.time.Period;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private String classeEconomica;
    private LocalDate dataNascimento ;
    

    public String getCpf() {
        return this.cpf;
    }
    //construtor
    public ClientePF(String nome, String endereco, String cpf, String genero, LocalDate dataLicenca, String educacao, String classeEconomica, LocalDate dataNascimento, double valorSeguro) {
        super(nome, endereco, valorSeguro);
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

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public double calcularScore(Cliente cliente) {
        int qtdVeiculos = (cliente.listarVeiculos()).size();
        //encontrar idade
        int idade = (Period.between(this.dataNascimento,LocalDate.now())).getYears();
        double fatorIdade = 0;
        if ((18 <= idade) && (idade <=30)) {
            fatorIdade = CalcSeguro.FATOR_18_30.getValor();
        }
        else if ((30<idade) && (idade <= 60)) {
            fatorIdade = CalcSeguro.FATOR_30_60.getValor();
        }
        else {
            fatorIdade = CalcSeguro.FATOR_60_90.getValor();
        }
        return (CalcSeguro.VALOR_BASE.getValor() * fatorIdade * qtdVeiculos);
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
