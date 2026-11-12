import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Lote {
    private static final BigDecimal FATOR_MINIMO = new BigDecimal("1.05");

    private final String nome;
    private final Categoria categoria;
    private final BigDecimal precoInicial;
    private final BigDecimal precoReserva;
    private final List<Lance> lances = new ArrayList<>();
    private final List<Interessado> interessados = new ArrayList<>();
    private BigDecimal lanceAtual;
    private RegraComissao regraComissao;
    private boolean aberto = true;
    private boolean vendido;
    private Licitante comprador;
    private BigDecimal valorVenda;
    private BigDecimal comissao;

    public Lote(String nome, Categoria categoria, BigDecimal precoInicial, BigDecimal precoReserva) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = categoria.getRegraPadrao();
    }

    public void acompanhar(Interessado interessado) {
        interessados.add(interessado);
    }

    public void deixarDeAcompanhar(Interessado interessado) {
        interessados.remove(interessado);
    }

    public void darLance(Licitante licitante, BigDecimal valor) {
        if (!aberto) {
            throw new LanceRecusadoException("Lote '" + nome + "' esta encerrado");
        }
        BigDecimal minimo = lanceAtual.multiply(FATOR_MINIMO);
        if (valor.compareTo(minimo) < 0) {
            throw new LanceRecusadoException("Lance de " + Dinheiro.formatar(valor)
                + " recusado: precisa ser pelo menos 5% acima do lance atual ("
                + Dinheiro.formatar(minimo) + " ou mais)");
        }
        Lance lance = new Lance(licitante, valor);
        lances.add(lance);
        lanceAtual = valor;
        for (Interessado interessado : new ArrayList<>(interessados)) {
            if (interessado != licitante) {
                interessado.atualizar(this, lance);
            }
        }
    }

    public void trocarRegraComissao(RegraComissao novaRegra) {
        if (!aberto) {
            throw new IllegalStateException("Lote encerrado: a regra de comissao nao pode mais ser trocada");
        }
        this.regraComissao = novaRegra;
    }

    public void encerrar() {
        if (!aberto) {
            return;
        }
        aberto = false;
        if (!lances.isEmpty() && lanceAtual.compareTo(precoReserva) >= 0) {
            vendido = true;
            valorVenda = lanceAtual;
            comprador = lances.get(lances.size() - 1).getLicitante();
            comissao = regraComissao.calcular(valorVenda);
        }
    }

    public String getNome() { return nome; }
    public Categoria getCategoria() { return categoria; }
    public BigDecimal getPrecoInicial() { return precoInicial; }
    public BigDecimal getPrecoReserva() { return precoReserva; }
    public BigDecimal getLanceAtual() { return lanceAtual; }
    public List<Lance> getLances() { return new ArrayList<>(lances); }
    public RegraComissao getRegraComissao() { return regraComissao; }
    public boolean isAberto() { return aberto; }
    public boolean isVendido() { return vendido; }
    public Licitante getComprador() { return comprador; }
    public BigDecimal getValorVenda() { return valorVenda; }
    public BigDecimal getComissao() { return comissao; }
}
