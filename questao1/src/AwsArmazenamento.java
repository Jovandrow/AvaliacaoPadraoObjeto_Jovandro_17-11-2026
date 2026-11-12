import java.util.concurrent.atomic.AtomicInteger;

public class AwsArmazenamento implements Armazenamento {
    public static final double CUSTO_POR_GB = 0.023;
    private static final AtomicInteger SEQUENCIA = new AtomicInteger();

    private final String id = "s3://" + SEQUENCIA.incrementAndGet();
    private final int gb;

    public AwsArmazenamento(int gb) {
        this.gb = gb;
    }

    public String getId() { return id; }
    public int getGb() { return gb; }
    public double getCustoPorGb() { return CUSTO_POR_GB; }
}
