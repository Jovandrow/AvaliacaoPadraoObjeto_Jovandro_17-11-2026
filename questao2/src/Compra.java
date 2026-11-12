import java.math.BigDecimal;
import java.util.List;

public interface Compra {
    BigDecimal getValorVenda();
    List<LinhaFatura> getLinhas();
    BigDecimal getTotal();
}
