import java.util.concurrent.atomic.AtomicInteger;

public class AwsFila implements FilaMensagens {
    public static final double CUSTO_MENSAL = 0.40;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id = "sqs-" + SEQUENCIA.incrementAndGet();

    public String getId() { return id; }
    public double getCustoMensal() { return CUSTO_MENSAL; }
}
