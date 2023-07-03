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

    public ArrayList<Seguro> getListaSeguros() {
        return this.listaSeguros;
    }

    public ArrayList<Cliente> getListaClientes(String tipoCliente) {
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
        else if(tipoCliente.equals("PJ")) {
            ArrayList<Cliente> listaClientesPJ = new ArrayList<Cliente>();
            for (Cliente clienteCadastrado: listaClientes) {
                if (clienteCadastrado instanceof ClientePJ) {
                    listaClientesPJ.add(clienteCadastrado);            
                    System.out.println("ClientePJ cadastrado: " + clienteCadastrado.getNome());       
                }
            }
            return listaClientesPJ;
        }
        //aqui se retorna a lista com todos os clientes
        return this.listaClientes;  
    }

    //metodos cliente
    public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente) {
        //encontrar os seguros com o nome do cliente
        int numSeguros = 0;
        ArrayList<Seguro> listaSegCLiente = new ArrayList<>();
        for (Seguro seguroCadastrado: listaSeguros) {
            if (seguroCadastrado.getCliente().equals(cliente)) {
                numSeguros++;
                listaSegCLiente.add(seguroCadastrado);
                
            }           
        }
        //informar quantos seguros tem
        System.out.println("O cliente " + cliente.getNome() + " possui " + numSeguros + " seguros.");
        return listaSegCLiente;
    }

    public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente) {
        //encontrar os sinistros com o nome do cliente
        int numSinistros = 0;
        ArrayList<Sinistro> listaSinistros = new ArrayList<>();
        for (Seguro segCadastrado: listaSeguros) {
            if (segCadastrado.getCliente().equals(cliente)) {
                for (Sinistro sinCadastrado: segCadastrado.getListaSinistros()) { 
                    numSinistros++;
                    listaSinistros.add(sinCadastrado);
                    
                } 
            }
                       
        }
        
        return listaSinistros;
    }

    public boolean cadastrarCliente(Cliente cliente) {
        //verificar se o cliente ja esta cadastrado
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado.equals(cliente)) {
                //cliente ja cadastrado
                return false;
            }           
        }
        //cliente novo
        listaClientes.add(cliente);
        return true;
    }

    public boolean removerCliente(Cliente cliente) {
        //verificar se o cliente esta cadastrado
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado.equals(cliente)) {
                //cliente cadastrado, é possível removê-lo
                listaClientes.remove(clienteCadastrado);
                //remover seguros existentes no nome do cliente
                for (Seguro segCadastrado: listaSeguros) {
                    if (segCadastrado.getCliente().equals(cliente)) {
                        listaSeguros.remove(segCadastrado);
                    }
                return true;
                }
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
        boolean verificacao = false;
         //verificar existencia de cliente e veiculo
        
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado.equals(cliente)) {
                //cliente cadastrado, é possível gerar seguro
                if (cliente instanceof ClientePF) {
                    for (Veiculo veiculoCadastrado: ((ClientePF)cliente).getListaVeiculos()) {
                        if (veiculoCadastrado.equals(veiculo)) {
                            //veiculo cadastrado, é possível gerar seguro
                            verificacao = true;
                            break;
                        }
                    }
                }   
                else if (cliente instanceof ClientePJ){
                    for (Frota frota: ((ClientePJ)cliente).getListaFrotas()) {
                        for (Veiculo veiculoCadastrado: frota.getListaVeiculos()) {
                            
                            if (veiculoCadastrado.equals(veiculo)) {
                                //veiculo cadastrado, é possível gerar seguro
                                verificacao = true;
                                break;
                            }
                        }    
                        
                    }
        
                }    
                if (verificacao == true) break;  
            }
        }

        //seguroPF
        if (cliente instanceof ClientePF && verificacao) {
            Seguro seguro = new SeguroPF(dataInicio, dataFim, seguradora, veiculo, (ClientePF)cliente);
            listaSeguros.add(seguro);
            return true;
        }
        //seguroPJ
        if (cliente instanceof ClientePJ && verificacao) {
            Seguro seguro = new SeguroPJ(dataInicio, dataFim, seguradora, (ClientePJ)cliente);
            listaSeguros.add(seguro);
            return true;
        }
        return false;
        
    }
    
    public boolean cadastrarSeguro(Seguro seguro){
        //verificar se o seguro ja esta cadastrado
        for (Seguro seguroCadastrado: listaSeguros) {
            if (seguroCadastrado.equals(seguro)) {
                //seguro ja cadastrado
                return false;
            }           
        }
        //seguro novo
        listaSeguros.add(seguro);
        return true;
    }

    public boolean cancelarSeguro(Seguro seguro){
        //verificar se o seguro esta cadastrado
        for (Seguro seguroCadastrado: listaSeguros) {
            if (seguroCadastrado.equals(seguro)) {
                //seguro cadastrado, é possível removê-lo
                listaSeguros.remove(seguroCadastrado);
                return true;
            }        
        }
        //seguro não existe, não é possível removê-lo
        return false;
    }

    public double calcularReceita(){
        double receita = 0; 
        for (Seguro seguro:listaSeguros) {
            receita += seguro.getValorMensal();
        }
        return receita; 
    }
    

    @Override
    public String toString() {
        return "{" +
            " cnpj='" + cnpj+ "'" +
            ", nome='" + nome + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", email='" + getEmail() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", listaSeguros='" + getListaSeguros() + "'" +
            ", listaClientes='" + getListaClientes("") + "'" +
            "}";
    }
     
    
}

