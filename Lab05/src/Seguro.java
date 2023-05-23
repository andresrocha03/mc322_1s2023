import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Seguro {
    private final int id;
    private static int IdGenerator = 0;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private int valorMensal;

    
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
        this.id = IdGenerator++;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<>();
        this.listaCondutores = new ArrayList<>();
        this.valorMensal = 0;
    }



    public int getId() {
        return this.id;
    }


    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return this.seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    //listar
    public ArrayList<Sinistro> listarSinistros() {
        return listaSinistros;
    }

    public ArrayList<Condutor> listarCondutores() {
        return listaCondutores;
    }

    public int getValorMensal() {
        return this.valorMensal;
    }

    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

    //metodos Condutor
    public abstract boolean desautorizarCondutor();
    public abstract boolean autorizarCondutor();

    }

    //Metodos valor
    public abstract int calcularValor();
    
    //Metodos Sinistro
    public abstract boolean gerarSinistro(Cliente cliente, Veiculo veiculo);
    
    
}
