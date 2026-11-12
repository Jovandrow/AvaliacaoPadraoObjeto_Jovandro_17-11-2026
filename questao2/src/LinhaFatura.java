import java.math.BigDecimal;

public class LinhaFatura {
    private final String descricao;
    private final BigDecimal custo;

    public LinhaFatura(String descricao, BigDecimal custo) {
        this.descricao = descricao;
        this.custo = custo;
    }

    public String getDescricao() { return descricao; }
    public BigDecimal getCusto() { return custo; }
}
