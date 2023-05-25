import java.time.LocalDate;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    ClientePF cliente;


    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,Veiculo veiculo, ClientePF cliente) {
        super(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //getters and setters

    public Frota getFrota() {
        return this.frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePF getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }
    
    //metodos condutor
    public boolean autorizarCondutor() {

    }
    public boolean desautorizarCondutor() {

    }

    //Metodos Sinistros
    public boolean gerarSinistro(Cliente cliente, Veiculo veiculo) {
        /*  Aqui se gera um sinistro de um cliente e um veículo já existentes,
            O endereco será o do cliente e a data será uma string.
         */
        //verificar se cliente existe
        boolean existeCliente = false;
        boolean existeVeiculo = false;
        for (Cliente clienteCadastrado: listaClientes) {
            if (clienteCadastrado == cliente) {
                    existeCliente = true;
            }                          
        }
        //verificar se veiculo exite
        if (existeCliente) {
            for (Veiculo veiculoCadastrado: cliente.listarVeiculos()) {
                if ( veiculoCadastrado == veiculo)  {
                    existeVeiculo = true;
                }           
            }
        }
        

        if (existeCliente && existeVeiculo) {
            //gerar sinistro
            Sinistro sinistro = new Sinistro("01/01/2023","Rua dos Girassois", this, veiculo, cliente);
            listaSinistros.add(sinistro);
            return true;
        }
        return false;
    }

    //metodo valor
    public int calcularValor(){

    }

}