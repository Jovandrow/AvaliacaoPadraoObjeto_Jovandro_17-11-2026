import java.math.BigDecimal;

public class Lance {
    private final Licitante licitante;
    private final BigDecimal valor;

    public Lance(Licitante licitante, BigDecimal valor) {
        this.licitante = licitante;
        this.valor = valor;
    }

    public Licitante getLicitante() { return licitante; }
    public BigDecimal getValor() { return valor; }
}
