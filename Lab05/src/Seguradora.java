import java.util.ArrayList;
import java.time.LocalDate;

public class Seguradora {
    private final String cnpj;
    private String nome ;
    private String telefone ;
    private String email ;
    private String endereco ;
    private ArrayList<Seguro> listaSeguros;
    private ArrayList<Cliente> listaClientes;
    


    // Construtor
    public Seguradora (String cnpj, String nome , String telefone , String email , String endereco ) {
        this.cnpj = cnpj;
        this.nome      = nome ;
        this.telefone  = telefone ;
        this.email     = email ;
        this.endereco  = endereco ;
        this.listaSeguros = new ArrayList<Seguro>();
        this.listaClientes = new ArrayList<Cliente>();
    }

    // Getters e setters
    public String getCNPJ () {
        return cnpj;
    }
    
    public String getNome () {
        return nome ;
    }

    public void setNome ( String nome ) {
        this .nome = nome ;
    }

    public String getTelefone () {
        return telefone ;
    }

    public void setTelefone ( String telefone ) {
        this . telefone = telefone ;
    }

    public String getEmail () {
        return email ;
    }

    public void setEmail ( String email ) {
        this . email = email ;
    }

    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this . endereco = endereco ;
    }

    public ArrayList<Seguro> getSegurosPorCliente(String cpf) {

    }

    public ArrayList<Seguro> getSinistrosPorCliente(String cpf) {

    }

    public ArrayList<Cliente> listarClientes(String tipoCliente) {
        if (tipoCliente.equals("PF")){
            ArrayList<Cliente> listaClientesPF = new ArrayList<Cliente>();
            for (Cliente clienteCadastrado: listaClientes) {
                if (clienteCadastrado instanceof ClientePF) {
                    listaClientesPF.add(clienteCadastrado);                    
                    System.out.println("ClientePF cadastrado: " + clienteCadastrado.getNome());
                }
            }
            return listaClientesPF;
        }
        ArrayList<Cliente> listaClientesPJ = new ArrayList<Cliente>();
        if(tipoCliente.equals("PJ")) {
            for (Cliente clienteCadastrado: listaClientes) {
                if (clienteCadastrado instanceof ClientePJ) {
                    listaClientesPJ.add(clienteCadastrado);            
                    System.out.println("ClientePJ cadastrado: " + clienteCadastrado.getNome());       
                }
            }
            return listaClientesPJ;
        }
        return this.listaClientes;  
    }


    //Metodos cliente
    public boolean cadastrarCliente(Cliente cliente) {
        //verificar se o cliente ja esta cadastrado
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado == cliente) {
                //cliente ja cadastrado
                return false;
            }           
        }
        //cliente novo
        listaClientes.add(cliente);
        return true;
    }

    public boolean removerCliente(String nomeCliente) {
        //verificar se o cliente esta cadastrado
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado.getNome().equals(nomeCliente)) {
                //cliente cadastrado, é possível removê-lo
                listaClientes.remove(clienteCadastrado);
                return true;
            }           
        }
        //cliente não existe, não é possível removê-lo
        return false;
    }

   
    //Métodos Seguro
    
    public boolean gerarSeguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        /*  
        Aqui se gera um seguro
         */
        //verificar existencia de cliente e veiculo?????????

        //seguroPF
        if (tipo.equals("PF")) {
            Seguro seguro = new SeguroPF(dataInicio, dataFim, seguradora, veiculo, (ClientePF)cliente);
            listaSeguros.add(seguro);
            return true;
        }
        //seguroPJ
        Seguro seguro = new SeguroPJ(dataInicio, dataFim, seguradora, veiculo, (ClientePJ)cliente);
        listaSeguros.add(seguro);
        return true;
        
    }
    
    public boolean cadastrarSeguro(Seguro seguro){
        //seguro ja esta adicionado ???
        listaSeguros.add(seguro);
        return true;
    }

    public boolean cancelarSeguro(Seguro seguro){
        //esse Seguro existe ???
        listaSeguros.remove(seguro);
        return true;
    }

    public double calcularReceita(){
        int receita = 0; 
        for (Cliente cliente:listaClientes) {
            receita += calcularPrecoSeguroCliente(cliente);
        }
        return receita; 
    }
    
    //toString
    public String toString() { 
        return 
        "nome: " + nome +
        "\ntelefone: " + telefone +
        "\nemail: " + email+  
        "\nendereco: " + endereco;
    } 
            
    
}


/*
    public boolean visualizarSinistro (String nomeCliente) {
        //encontrar os sinistros com o nome do cliente
        int numSinistros = 0;
        
        for (Sinistro sinistroCadastrado: listaSinistros) {
            if (((sinistroCadastrado.getCliente()).getNome()).equals(nomeCliente)) {
                numSinistros++;
                System.out.println(sinistroCadastrado.toString());
            }           
        }
        //informar quantos sinistros tem
        if (numSinistros >= 1){
            System.out.println("O cliente " + nomeCliente + " possui " + numSinistros + " sinistros.");
            
            return true;    
        }
        else {
            System.out.println("O cliente " + nomeCliente + " não possui sinistros cadastrados");
            return false;
        }
 
    }
    
    
    public double calcularPrecoSeguroCliente(Cliente cliente){
        //checar qtdSinistros
        int qtdSinistros = 0;
        for (Sinistro sinistro:listaSinistros) {
            if (cliente == sinistro.getCliente()) {
                qtdSinistros++;
            }
        }
        return cliente.calcularScore() * (1 + qtdSinistros); 
    }
 
 
    */