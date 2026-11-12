import java.math.BigDecimal;

public class EntregaExpressa extends ServicoAdicional {
    private static final BigDecimal CUSTO = new BigDecimal("450.00");

    public EntregaExpressa(Compra compra) {
        super(compra, "Entrega expressa");
    }

    protected BigDecimal calcularCusto(BigDecimal valorVenda) {
        return CUSTO;
    }
}
