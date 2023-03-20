import java.util.random;

public class Sinistro {
    private int id ;
    private String data ;
    private String endereco;

    // Construtor
    public Sinistro ( int id , String data , String endereco ) {
        this .id                = id ;
        this .data              = data ;
        this .endereco          = endereco ;
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

    public void setData ( String cpf ) {
        this . data = data ;
    }

    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this . endereco = endereco ;
    }
    // a funcao random gera numneros negativos tambem, como solucionar isso?
    public int generateId()  {
        //instanciar objeto da classe Random
        Ramdom id = new Ramdom();

        //retornar id unico
        return id.nextInt();
    }
}