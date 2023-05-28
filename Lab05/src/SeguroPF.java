import java.time.LocalDate;
import java.time.Period;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;


    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,Veiculo veiculo, ClientePF cliente) {
        super(dataInicio,dataFim,seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
        super.setValorMensal(calcularValor());
    }

    //getters and setters

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }
    

    //metodo valor
    public double calcularValor(){
        //encontrar qtdVeiculos
        int qtdVeiculos = (cliente.getListaVeiculos()).size();
        //encontrar idade
        int idade = (Period.between(cliente.getDataNascimento(),LocalDate.now())).getYears();
        //encontrar qtdSinistros/cliente
        int qtdSinistrosCli = getSeguradora().getSinistrosPorCliente(cliente).size();
        //encontrar qtdSinistros/condutor
        int qtdSinistrosCon = 0;
        for (Condutor condutor:super.getListaCondutores()) {
            qtdSinistrosCon += condutor.getListaSinistros().size();
        }
        //encontrar fatorIdade
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
        //
        return  (CalcSeguro.VALOR_BASE.getValor() * fatorIdade * (1+ (1/qtdVeiculos)) *
                (2 + (qtdSinistrosCli/10)) * (5 + (qtdSinistrosCon/10))   
                );
    }



    @Override
    public String toString() {
        return "{" +
            " veiculo='" + getVeiculo() + "'" +
            ", cliente='" + getCliente() + "'" +
            "}";
    }
   


}