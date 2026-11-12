import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuditLog {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    private static final AuditLog INSTANCIA = new AuditLog();

    private final List<String> registros = new ArrayList<>();

    private AuditLog() { }

    public static AuditLog getInstance() {
        return INSTANCIA;
    }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        String data = LocalDateTime.now().format(FORMATO);
        registros.add(data + " | " + ambiente + " | " + provedor + " | " + resultado);
    }

    public synchronized List<String> getRegistros() {
        return Collections.unmodifiableList(new ArrayList<>(registros));
    }
}
