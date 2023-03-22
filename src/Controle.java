public class Controle {
    public static void main(String args[]){
        Cliente pessoa = new Cliente("dezin", "710-735-301.24", "03/11/2003", "20", "RES. piramidde");
        System.out.println(pessoa.getCPF());
        pessoa.setCPF("11111111111111111");
        System.out.println(pessoa.validateCPF("11111111111111111"));
        System.out.println(pessoa.toString());
        
        Seguradora seg = new Seguradora("dezin", "62996973007", "dezin@gmail.com", "Res. Piramide");
        System.out.println(seg.getTelefone());
        seg.setTelefone("456456456456");
        System.out.println(seg.getTelefone());
        
        Sinistro sin = new Sinistro("23/03/2023", "Res Piramide");
        System.out.println(sin.getEndereco());
        sin.setEndereco("OXXO");
        System.out.println(sin.getEndereco());

        Veiculo vei = new Veiculo("ABC2325", "MERCEDES","C180");
        System.out.println(vei.getModelo());
        vei.setModelo("fusca");
        System.out.println(vei.getModelo());

        
    }
    
}
