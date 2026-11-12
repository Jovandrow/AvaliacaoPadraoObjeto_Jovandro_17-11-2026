import java.util.concurrent.atomic.AtomicInteger;

public class AzureFila implements FilaMensagens {
    public static final double CUSTO_MENSAL = 0.50;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id = "sb-" + SEQUENCIA.incrementAndGet();

    public String getId() { return id; }
    public double getCustoMensal() { return CUSTO_MENSAL; }
}
