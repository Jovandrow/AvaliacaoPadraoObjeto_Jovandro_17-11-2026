public class Fatura {
    public static void imprimir(Compra compra) {
        System.out.println("--- FATURA DO COMPRADOR ---");
        for (LinhaFatura linha : compra.getLinhas()) {
            System.out.println("  " + linha.getDescricao() + ": " + Dinheiro.formatar(linha.getCusto()));
        }
        System.out.println("  TOTAL A PAGAR: " + Dinheiro.formatar(compra.getTotal()));
    }
}
