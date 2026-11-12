import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor implements Interessado {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    public void atualizar(Lote lote, Lance lance) {
        String registro = LocalDateTime.now().format(FORMATO) + " | " + lote.getNome() + " | "
            + lance.getLicitante().getNome() + " | " + Dinheiro.formatar(lance.getValor());
        registros.add(registro);
        System.out.println("[Auditor] " + registro);
    }

    public List<String> getRegistros() {
        return new ArrayList<>(registros);
    }
}
