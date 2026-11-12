import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendaBase implements Compra {
    private final Lote lote;

    public VendaBase(Lote lote) {
        if (!lote.isVendido()) {
            throw new IllegalStateException("Lote '" + lote.getNome() + "' nao foi vendido");
        }
        this.lote = lote;
    }

    public BigDecimal getValorVenda() {
        return lote.getValorVenda();
    }

    public List<LinhaFatura> getLinhas() {
        List<LinhaFatura> linhas = new ArrayList<>();
        linhas.add(new LinhaFatura("Lote '" + lote.getNome() + "' - valor de venda", lote.getValorVenda()));
        return linhas;
    }

    public BigDecimal getTotal() {
        return lote.getValorVenda();
    }
}
