import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

public class SeguroPJ extends Seguro {
    private ArrayList<Frota> listaFrotas;
    private ClientePJ cliente;


    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, ClientePJ cliente) {
        super(dataInicio,dataFim,seguradora);
        this.listaFrotas = new ArrayList<>();
        this.cliente = cliente;
    }

    //getters and setters

    public ArrayList<Frota> getListaFrotas() {
        return this.listaFrotas;
    }

    public void setFrota(ArrayList<Frota> novaListaFrota) {
        this.listaFrotas = novaListaFrota;
    }

    public ClientePJ getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }


    public double calcularValor(){

        //encontrar qtdVeiculos
        int qtdVeiculos = 0;
        for (Frota frota: this.listaFrotas) {
            qtdVeiculos += frota.getListaVeiculos().size();
        }
        //encontrar idade
        int AnosPosFundacao = (Period.between(cliente.getDataFundacao(),LocalDate.now())).getYears();
        //encontrar qtdSinistros/cliente
        int qtdSinistrosCli = getSeguradora().getSinistrosPorCliente(cliente).size();
        //encontrar qtdSinistros/condutor
        int qtdSinistrosCon = 0;
        for (Condutor condutor:super.getListaCondutores()) {
            qtdSinistrosCon += condutor.getListaSinistros().size();
        }
        //
        return  (CalcSeguro.VALOR_BASE.getValor() * (10 + (cliente.getQtdFuncionarios()/10)) *
                 (1 + (1/qtdVeiculos)) * (1 + (1/AnosPosFundacao)) *
                 (2 + (qtdSinistrosCli/10)) * (5 + (qtdSinistrosCon/10))   
                );
    }
    

    @Override
    public String toString() {
        return "{" +
            " listaFrotas='" + getListaFrotas() + "'" +
            ", cliente='" + getCliente() + "'" +
            "}";
    }

}
