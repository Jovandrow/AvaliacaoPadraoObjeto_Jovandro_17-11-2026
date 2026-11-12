import java.util.Locale;

public class MontadorDeAmbiente {
    private final ProvedorNuvem provedor;

    public MontadorDeAmbiente(ProvedorNuvem provedor) {
        this.provedor = provedor;
    }

    public Ambiente montar(Solicitacao solicitacao) {
        Configuracao config = Configuracao.getInstance();
        String nome = solicitacao.getNomeAmbiente();
        double custo = Ambiente.estimarCusto(provedor, solicitacao.getMaquinas(), solicitacao.getGbArmazenamento());

        if (custo > config.getOrcamentoMensalMaximo()) {
            String motivo = String.format(Locale.forLanguageTag("pt-BR"),
                "RECUSADO: custo estimado R$ %.2f acima do orcamento de R$ %.2f",
                custo, config.getOrcamentoMensalMaximo());
            AuditLog.getInstance().registrar(nome, provedor.getNome(), motivo);
            System.out.println("Ambiente " + nome + " recusado. " + motivo);
            return null;
        }

        Ambiente ambiente = new Ambiente(nome, config.getRegiaoPadrao(), provedor,
                solicitacao.getMaquinas(), solicitacao.getGbArmazenamento());
        AuditLog.getInstance().registrar(nome, provedor.getNome(), "ACEITO");
        System.out.println(ambiente.resumo());
        return ambiente;
    }
}
