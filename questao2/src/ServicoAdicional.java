import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public abstract class ServicoAdicional implements Compra {
    private final Compra compra;
    private final String descricao;

    protected ServicoAdicional(Compra compra, String descricao) {
        this.compra = compra;
        this.descricao = descricao;
    }

    protected abstract BigDecimal calcularCusto(BigDecimal valorVenda);

    private BigDecimal custo() {
        return calcularCusto(compra.getValorVenda()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getValorVenda() {
        return compra.getValorVenda();
    }

    public List<LinhaFatura> getLinhas() {
        List<LinhaFatura> linhas = compra.getLinhas();
        linhas.add(new LinhaFatura(descricao, custo()));
        return linhas;
    }

    public BigDecimal getTotal() {
        return compra.getTotal().add(custo());
    }
}
