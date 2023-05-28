import java.time.LocalDate;

public class Sinistro {
    private int id;
    private static int IdGenerator = 0;
    private LocalDate data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;
    
    
    // Construtor
    public Sinistro (LocalDate data, String endereco, Seguro seguro, Condutor condutor) {
        this .id                = IdGenerator++ ;
        this .data              = data ;
        this .endereco          = endereco ;
        this .seguro            = seguro;
        this .condutor          = condutor;
    }

    // Getters e setters
    public int getId () {
        return id ;
    }

    public void setId ( int id ) {
        this .id = id ;
    }

    public LocalDate getData () {
        return data ;
    }

    public void setData (LocalDate data) {
        this . data = data ;
    }

    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this . endereco = endereco ;
    }

    public Seguro getSeguro() {
        return this.seguro;
    }
    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
    
    public Condutor getCondutor() {
        return this.condutor;
    }
    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", data='" + getData() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", condutor='" + getCondutor() + "'" +
            ", seguro='" + getSeguro() + "'" +
            "}";
    }
    
}