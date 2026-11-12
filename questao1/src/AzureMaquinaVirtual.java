import java.util.concurrent.atomic.AtomicInteger;

public class AzureMaquinaVirtual implements MaquinaVirtual {
    public static final double CUSTO_POR_HORA = 0.12;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id = "vm-" + SEQUENCIA.incrementAndGet();

    public String getId() { return id; }
    public double getCustoPorHora() { return CUSTO_POR_HORA; }
}
