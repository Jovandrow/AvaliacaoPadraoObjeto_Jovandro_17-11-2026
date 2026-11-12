import java.math.BigDecimal;

public interface RegraComissao {
    String getNome();
    BigDecimal calcular(BigDecimal valorVenda);
}
