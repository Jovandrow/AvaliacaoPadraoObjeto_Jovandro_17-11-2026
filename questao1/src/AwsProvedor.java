public class AwsProvedor implements ProvedorNuvem {
    public String getNome() { return "Aws"; }

    public MaquinaVirtual criarMaquinaVirtual() { return new AwsMaquinaVirtual(); }
    public Armazenamento criarArmazenamento(int gb) { return new AwsArmazenamento(gb); }
    public FilaMensagens criarFila() { return new AwsFila(); }

    public double getCustoHoraMaquina() { return AwsMaquinaVirtual.CUSTO_POR_HORA; }
    public double getCustoGbMes() { return AwsArmazenamento.CUSTO_POR_GB; }
    public double getCustoFilaMes() { return AwsFila.CUSTO_MENSAL; }
}
