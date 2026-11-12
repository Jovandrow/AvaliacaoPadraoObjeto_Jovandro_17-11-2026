import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PainelLeiloeiro implements Interessado {
    private final Map<String, BigDecimal> maiorLance = new HashMap<>();
    private final Map<String, Integer> totalLances = new HashMap<>();

    public void atualizar(Lote lote, Lance lance) {
        String nome = lote.getNome();
        maiorLance.merge(nome, lance.getValor(), BigDecimal::max);
        totalLances.merge(nome, 1, Integer::sum);
        System.out.println("[Painel] Lote '" + nome + "': maior lance " + Dinheiro.formatar(maiorLance.get(nome))
            + " | total de lances: " + totalLances.get(nome));
    }
}
