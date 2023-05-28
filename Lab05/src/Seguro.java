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
    private double valorMensal;

    
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

    public void setListaSinistros(ArrayList<Sinistro> novaListaSinistros) {
        this.listaSinistros = novaListaSinistros;
    }

    public abstract Cliente getCliente();


    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }

    public double getValorMensal() {
        return this.valorMensal;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

    //metodos Condutor
    public boolean autorizarCondutor(Condutor condutor){
        //encontrar condutor
        for (Condutor condutorCadastrado: listaCondutores) {
            if (condutorCadastrado.equals(condutor)) {
                condutorCadastrado.setAutorizacao(true); 
                return true;
            }
        }
        //condutor nao encontrado
        return false;
    }
    
    public boolean desautorizarCondutor(Condutor condutor) {
        //encontrar condutor
        for (Condutor condutorCadastrado: listaCondutores) {
            if (condutorCadastrado.equals(condutor)) {
                condutorCadastrado.setAutorizacao(false); 
                return true;
            }
        }
        //condutor nao encontrado
        return false;
    };

    //Metodos valor
    public abstract double calcularValor();
    
    //Metodos Sinistros
    public boolean gerarSinistro(LocalDate data, String endereco, Condutor condutor) {
        /*  Aqui se gera um sinistro do cliente do seguro,
            O endereco será uma string e a data será LocalDate.
         */
        //gerar sinistro
        Sinistro sinistro = new Sinistro(data, endereco, this, condutor);
        ArrayList<Sinistro> novaListaSinistros = getListaSinistros();
        novaListaSinistros.add(sinistro);
        condutor.adicionarSinistro(sinistro);
        setListaSinistros(novaListaSinistros); 
        return true;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", dataInicio='" + getDataInicio() + "'" +
            ", dataFim='" + getDataFim() + "'" +
            ", seguradora='" + getSeguradora() + "'" +
            ", listaSinistros='" + getListaSinistros() + "'" +
            ", listaCondutores='" + getListaCondutores() + "'" +
            ", valorMensal='" + getValorMensal() + "'" +
            "}";
    }

}
