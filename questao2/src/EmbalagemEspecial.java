import java.math.BigDecimal;

public class EmbalagemEspecial extends ServicoAdicional {
    private static final BigDecimal CUSTO = new BigDecimal("180.00");

    public EmbalagemEspecial(Compra compra) {
        super(compra, "Embalagem especial");
    }

    protected BigDecimal calcularCusto(BigDecimal valorVenda) {
        return CUSTO;
    }
}
