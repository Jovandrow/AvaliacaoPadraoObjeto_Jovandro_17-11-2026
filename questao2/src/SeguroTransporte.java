import java.math.BigDecimal;

public class SeguroTransporte extends ServicoAdicional {
    private static final BigDecimal PERCENTUAL = new BigDecimal("0.015");

    public SeguroTransporte(Compra compra) {
        super(compra, "Seguro de transporte (1,5%)");
    }

    protected BigDecimal calcularCusto(BigDecimal valorVenda) {
        return valorVenda.multiply(PERCENTUAL);
    }
}
