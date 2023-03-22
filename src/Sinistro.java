

public class Sinistro {
    private int id ;
    private String data ;
    private String endereco;
    private static int IdGenerator = 0;
    // Construtor
    public Sinistro ( int id , String data , String endereco ) {
        this .id                = IdGenerator++ ;
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

    public void setData ( String data) {
        this . data = data ;
    }

    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this . endereco = endereco ;
    }
    
}