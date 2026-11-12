public class Solicitacao {
    private final String nomeAmbiente;
    private final String provedor;
    private final int maquinas;
    private final int gbArmazenamento;

    public Solicitacao(String nomeAmbiente, String provedor, int maquinas, int gbArmazenamento) {
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.maquinas = maquinas;
        this.gbArmazenamento = gbArmazenamento;
    }

    public String getNomeAmbiente() { return nomeAmbiente; }
    public String getProvedor() { return provedor; }
    public int getMaquinas() { return maquinas; }
    public int getGbArmazenamento() { return gbArmazenamento; }
}
