public class Validacao {   
    public static Boolean validateCNPJ(String cnpj) {
        //remover todos os caracteres não numericos do cnpj
        cnpj = cnpj.replaceAll("[^0-9]","");
        
        //verificar se o CNPJ tem 16 digitos
        if (cnpj.length() != 14) {
            System.out.println("O cnpj " + cnpj + " é inválido");
            return false;
        }
        
        //verificar se todos os digitos sao iguais
        char firstDigit = cnpj.charAt(0);  
        char digit;
        int i=0;
        for (i=1; i<12; i++) {
            digit = cnpj.charAt(i);
            if (digit != firstDigit) {
                break;
            }
        }
        if (i==12) {
            System.out.println("O cnpj " + cnpj + " é inválido");
            return false;
        }

        //calcular digitos verificadores
            //d1
        int soma=0,resto=0;
        int j = 5,aux=5,d1=0;
        for (i=0; i<=3;i++) {
            aux = Character.getNumericValue(cnpj.charAt(i));
            soma += j*aux;
            j--;
        }
        j = 9;
        for (i=4; i<=11;i++) {
            aux = Character.getNumericValue(cnpj.charAt(i));
            soma += j*aux;
            j--;
        }
        resto  = (soma)%11;
        if (resto == 0 || resto == 1) {
            d1 = 0;
        }
        
        else {
                d1 = 11 - resto; 
            }
        aux = Character.getNumericValue(cnpj.charAt(12));
        if (d1 != aux){
            System.out.println("O cnpj " + cnpj + " é inválido");
            return false;
        }
    
            //d2
        int d2 = 0;
        j = 6;
        aux=0;
        soma=0;
        resto=0;
        for (i=0; i<=4;i++) {
            aux = Character.getNumericValue(cnpj.charAt(i));
            soma += j*aux;
            j--;
        }
        j = 9;
        for (i=5; i<=12;i++) {
            aux = Character.getNumericValue(cnpj.charAt(i));
            soma += j*aux;
            j--;
        }
        resto  = (soma)%11;
        if (resto == 0 || resto == 1) {
            d2 = 0;
        }
        
        else {
                d2 = 11 - resto; 
        }
        aux = Character.getNumericValue(cnpj.charAt(13));
        if (d2 != aux){
            System.out.println("O cnpj " + cnpj + " é inválido");
            return false;
        }
        System.out.println("O cnpj " + cnpj + " é válido");
        return true;
    }

    public static Boolean validateCPF(String cpf) {
        //remover todos os caracteres não numericos do CPF
        cpf = cpf.replaceAll("[^0-9]","");
        
        //verificar se o CPF tem 11 digitos
        if (cpf.length() != 11) {
            return false;
        }
        
        //verificar se todos os digitos sao iguais
        char firstDigit = cpf.charAt(0);  
        char digit;
        int i=0;
        for (i=1; i<11; i++) {
            digit = cpf.charAt(i);
            if (digit != firstDigit) {
                break;
            }
        }
        if (i==11) {
            return false;
        }
        //calcular digitos verificadores
        int soma=0,resto=0;
        int j = 0,aux=0,d1=0;
        for (i=10; i>=2;i--) {
            aux = Character.getNumericValue(cpf.charAt(j));
            soma += i*aux;
            j++;
        }
        resto  = (soma)%11;
        if (resto == 0 || resto == 1) {
            d1 = 0;
        }
        
        else {
            d1 = 11 - resto; 
        }
        aux = Character.getNumericValue(cpf.charAt(9));
        if (d1 != aux){
            System.out.println("O cpf " + cpf + " é inválido");
            return false;
        }
        j=0;
        soma=0;
        resto=0;
        
        int d2 = 0;
        for (i=11; i>=2; i--) {
            aux = Character.getNumericValue(cpf.charAt(j));
            soma += i*aux;
            j++;
        }
        resto  = (soma)%11;
        if (resto == 0 || resto == 1) {
            d2 = 0;
        }
        else {
            d2 = 11 - resto; 
        }
        aux = Character.getNumericValue(cpf.charAt(10));
        if (d2 != aux) {
            System.out.println("O cpf " + cpf + " é inválido");
            return false;
        }
        System.out.println("O cpf " + cpf + " é válido");
        return true;
    }
    
    public static Boolean validateName(String nome){
        if (nome.matches("[A-Z]*") || nome.matches("[a-z]*") ){
            return true;
        }
        return false;
    }

}

