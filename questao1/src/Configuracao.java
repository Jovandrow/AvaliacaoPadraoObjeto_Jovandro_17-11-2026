import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracao {
    private static final String[] CAMINHOS = {
        "config.properties", "../config.properties", "questao1/config.properties", "../questao1/config.properties"
    };

    private final String regiaoPadrao;
    private final double orcamentoMensalMaximo;

    private Configuracao() {
        Properties props = new Properties();
        boolean lido = false;
        for (String caminho : CAMINHOS) {
            try (InputStream in = new FileInputStream(caminho)) {
                props.load(in);
                lido = true;
                break;
            } catch (IOException e) {
                continue;
            }
        }
        if (!lido) {
            throw new IllegalStateException("config.properties nao encontrado");
        }
        regiaoPadrao = props.getProperty("regiao.padrao");
        orcamentoMensalMaximo = Double.parseDouble(props.getProperty("orcamento.mensal.maximo"));
    }

    private static class Holder {
        private static final Configuracao INSTANCIA = new Configuracao();
    }

    public static Configuracao getInstance() {
        return Holder.INSTANCIA;
    }

    public String getRegiaoPadrao() { return regiaoPadrao; }
    public double getOrcamentoMensalMaximo() { return orcamentoMensalMaximo; }
}
