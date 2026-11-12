import java.math.BigDecimal;
import java.math.RoundingMode;

public class ComissaoArte implements RegraComissao {
    private static final BigDecimal PERCENTUAL = new BigDecimal("0.20");

    public String getNome() { return "Arte (20%)"; }

    public BigDecimal calcular(BigDecimal valorVenda) {
        return valorVenda.multiply(PERCENTUAL).setScale(2, RoundingMode.HALF_UP);
    }
}
