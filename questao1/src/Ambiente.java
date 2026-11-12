import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Ambiente {
    private static final int HORAS_NO_MES = 730;

    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas = new ArrayList<>();
    private final Armazenamento armazenamento;
    private final FilaMensagens fila;
    private final double custoMensal;

    // Os tres recursos nascem sempre da mesma fabrica, entao nunca misturam provedores.
    public Ambiente(String nome, String regiao, ProvedorNuvem provedor, int qtdMaquinas, int gb) {
        this.nome = nome;
        this.regiao = regiao;
        this.provedor = provedor.getNome();
        for (int i = 0; i < qtdMaquinas; i++) {
            maquinas.add(provedor.criarMaquinaVirtual());
        }
        this.armazenamento = provedor.criarArmazenamento(gb);
        this.fila = provedor.criarFila();
        this.custoMensal = estimarCusto(provedor, qtdMaquinas, gb);
    }

    public static double estimarCusto(ProvedorNuvem provedor, int qtdMaquinas, int gb) {
        return qtdMaquinas * provedor.getCustoHoraMaquina() * HORAS_NO_MES
             + gb * provedor.getCustoGbMes()
             + provedor.getCustoFilaMes();
    }

    public String resumo() {
        StringBuilder ids = new StringBuilder();
        for (MaquinaVirtual m : maquinas) {
            if (ids.length() > 0) ids.append(", ");
            ids.append(m.getId());
        }
        return String.format(Locale.forLanguageTag("pt-BR"),
            "Ambiente: %s | Provedor: %s | Regiao: %s%n"
            + "  Maquinas virtuais: %s%n"
            + "  Armazenamento: %s (%d GB)%n"
            + "  Fila: %s%n"
            + "  Custo mensal estimado: R$ %.2f",
            nome, provedor, regiao, ids, armazenamento.getId(), armazenamento.getGb(),
            fila.getId(), custoMensal);
    }

    public String getNome() { return nome; }
    public String getProvedor() { return provedor; }
    public double getCustoMensal() { return custoMensal; }
}
