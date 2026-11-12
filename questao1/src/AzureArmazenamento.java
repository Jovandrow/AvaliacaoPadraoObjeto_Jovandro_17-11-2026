import java.util.concurrent.atomic.AtomicInteger;

public class AzureArmazenamento implements Armazenamento {
    public static final double CUSTO_POR_GB = 0.02;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id = "blob://" + SEQUENCIA.incrementAndGet();
    private final int gb;

    public AzureArmazenamento(int gb) {
        this.gb = gb;
    }

    public String getId() { return id; }
    public int getGb() { return gb; }
    public double getCustoPorGb() { return CUSTO_POR_GB; }
}
