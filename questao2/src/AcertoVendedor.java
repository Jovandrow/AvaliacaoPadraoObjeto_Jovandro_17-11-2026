import java.math.BigDecimal;

public class AcertoVendedor {
    public static void imprimir(Lote lote) {
        BigDecimal liquido = lote.getValorVenda().subtract(lote.getComissao());
        System.out.println("--- ACERTO DO VENDEDOR: lote '" + lote.getNome() + "' ---");
        System.out.println("  Valor de venda: " + Dinheiro.formatar(lote.getValorVenda()));
        System.out.println("  Comissao (" + lote.getRegraComissao().getNome() + "): " + Dinheiro.formatar(lote.getComissao()));
        System.out.println("  Valor liquido a repassar: " + Dinheiro.formatar(liquido));
    }
}
