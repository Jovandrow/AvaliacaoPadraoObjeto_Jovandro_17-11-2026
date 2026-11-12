public class AzureProvedor implements ProvedorNuvem {
    public String getNome() { return "Azure"; }

    public MaquinaVirtual criarMaquinaVirtual() { return new AzureMaquinaVirtual(); }
    public Armazenamento criarArmazenamento(int gb) { return new AzureArmazenamento(gb); }
    public FilaMensagens criarFila() { return new AzureFila(); }

    public double getCustoHoraMaquina() { return AzureMaquinaVirtual.CUSTO_POR_HORA; }
    public double getCustoGbMes() { return AzureArmazenamento.CUSTO_POR_GB; }
    public double getCustoFilaMes() { return AzureFila.CUSTO_MENSAL; }
}
