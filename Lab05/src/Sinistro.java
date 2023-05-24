import java.time.LocalDate;

public class Sinistro {
    private int id;
    private static int IdGenerator = 0;
    private LocalDate data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;
    
    // Construtor
    public Sinistro (String data, String endereco, Seguradora seguradora,Veiculo veiculo,Cliente cliente ) {
        this .id                = IdGenerator++ ;
        this .data              = data ;
        this .endereco          = endereco ;
        this .seguradora        = seguradora;
        this .veiculo           = veiculo;
        this .cliente           = cliente;
    }

    // Getters e setters
    public int getId () {
        return id ;
    }

    public void setId ( int id ) {
        this .id = id ;
    }

    public String getData () {
        return data ;
    }

    public void setData ( String data) {
        this . data = data ;
    }

    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this . endereco = endereco ;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String toString() {
        return  "id:" + id + "\ndata:" + data + "\nendereco:" + endereco +
                "\nseguradora:" + seguradora + "\nveiculo:"  + veiculo + 
                "\ncliente:" + cliente;
                
                
    }
}