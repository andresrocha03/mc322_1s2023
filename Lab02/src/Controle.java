public class Controle {
    public static void main(String args[]){
        Cliente pessoa = new Cliente("Joao", "852.678.860-41", "01/01/2000", "20", "Rua das Rosas");
        System.out.printf("cpf: %s\n",pessoa.getCPF());
        System.out.printf("o cpf é %b\n",pessoa.validateCPF(pessoa.getCPF()));
        pessoa.setCPF("11111111111111111");
        System.out.printf("cpf: %s\n",pessoa.getCPF());
        System.out.printf("o cpf é %b\n",pessoa.validateCPF("11111111111111111"));
        System.out.println(pessoa.toString());
        
        Seguradora seg = new Seguradora("Joao", "61996973007", "joao@gmail.com", "Rua das Rosas");
        System.out.printf("telefone: %s\n",seg.getTelefone());
        seg.setTelefone("456456456456");
        System.out.printf("telefone: %s\n",seg.getTelefone());
        
        Sinistro sin = new Sinistro("23/03/2023", "Rua das Rosas");
        System.out.printf("endereco: %s\n",sin.getEndereco());
        sin.setEndereco("Rua dos Girassois");
        System.out.printf("endereco: %s\n",sin.getEndereco());

        Veiculo vei = new Veiculo("ABC1234", "AUDI","Q8");
        System.out.printf("modelo: %s\n",vei.getModelo());
        vei.setModelo("Fusca");
        System.out.printf("modelo: %s\n",vei.getModelo());

        
    }
    
}
