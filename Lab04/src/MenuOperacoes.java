public enum MenuOperacoes {
    CADASTRAR_CLIENTE(1),
    LISTAR(2),
    EXCLUIR(3),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALC_RECEITA_SEGURADORA(6),
    SAIR(0);
    
    public final int valor;

    MenuOperacoes(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return this.valor;
    }

    public static MenuOperacoes getOperacao(int valor) {
        MenuOperacoes operacao = null;
        for (MenuOperacoes operacaoAux:MenuOperacoes.values()) {
            if (valor == operacaoAux.getValor()) {
                operacao = operacaoAux;
                break;
            }
        }
        return operacao;
    }
    


}
