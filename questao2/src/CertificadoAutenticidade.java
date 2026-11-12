import java.math.BigDecimal;

public class CertificadoAutenticidade extends ServicoAdicional {
    private static final BigDecimal CUSTO = new BigDecimal("300.00");

    public CertificadoAutenticidade(Compra compra) {
        super(compra, "Certificado de autenticidade");
    }

    protected BigDecimal calcularCusto(BigDecimal valorVenda) {
        return CUSTO;
    }
}
