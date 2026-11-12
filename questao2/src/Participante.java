public class Participante implements Licitante, Interessado {
    private final String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }

    public void atualizar(Lote lote, Lance lance) {
        System.out.println("[" + nome + "] Lote '" + lote.getNome() + "': novo lance de "
            + Dinheiro.formatar(lance.getValor()));
    }
}
