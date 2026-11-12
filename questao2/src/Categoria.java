public class Categoria {
    private final String nome;
    private final RegraComissao regraPadrao;

    public Categoria(String nome, RegraComissao regraPadrao) {
        this.nome = nome;
        this.regraPadrao = regraPadrao;
    }

    public String getNome() { return nome; }
    public RegraComissao getRegraPadrao() { return regraPadrao; }
}
