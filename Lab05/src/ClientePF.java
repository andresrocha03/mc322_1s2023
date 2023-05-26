import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private String educacao;
    private LocalDate dataNascimento ;
    private ArrayList<Veiculo> listaVeiculos;
    
    
    
    //construtor
    public ClientePF(String nome, String endereco, String telefone, String email, String cpf, String genero, LocalDate dataLicenca, String educacao, LocalDate dataNascimento) {
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = new ArrayList<>();
    }

    //getters and setters
    public String getCpf() {
        return this.cpf;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEducacao() {
        return this.educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculo(ArrayList<Veiculo> newLista) {
        this.listaVeiculos = newLista;
    }
    
    //metodos Veiculos 
    public boolean cadastrarVeiculo(Veiculo veiculo) {
        for (Veiculo veiculoCadastrado: listaVeiculos) {
            if (veiculoCadastrado == veiculo) {
                //veiculo já esta cadastrado
                System.out.println("Veiculo " + veiculo.getPlaca() + " já possui cadastro.");
                return false;
            }           
        }
        listaVeiculos.add(veiculo);
        System.out.println("Veiculo cadastrado: " + veiculo.getPlaca());
        return true;
    }

    public boolean removerVeiculo(String placa) {
        //encontrar veiculo e verificar se o veiculo esta cadastrado
        for (Veiculo veiculoCadastrado: listaVeiculos) {
            if (veiculoCadastrado.getPlaca().equals(placa)) {
                //veiculo cadastrado, é possível removê-lo
                listaVeiculos.remove(veiculoCadastrado);
                //this.valorSeguro = this.calcularScore();
                return true;
            }           
        }
        //veiculo não foi cadastrado, não é possível removê-lo
        System.out.println("Veiculo " + placa + " não possui cadastro.");
        return false;
    }
    
   
    
    public String toString() {
        return 
            super.toString() +
            "cpf: " + cpf +
            "\ngenero: " + genero +
            "\neducacao: " + educacao +
            "\ndataNascimento: " + dataNascimento +
            "\nlistaVeiculos:" + this.listaVeiculos;
        }
    
    
}

/*
  public double calcularScore() {
        int qtdVeiculos = (this.listarVeiculos()).size();
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


 */