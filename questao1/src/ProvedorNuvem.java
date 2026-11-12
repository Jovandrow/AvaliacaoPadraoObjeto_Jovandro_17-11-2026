public interface ProvedorNuvem {
    String getNome();
    MaquinaVirtual criarMaquinaVirtual();
    Armazenamento criarArmazenamento(int gb);
    FilaMensagens criarFila();
    double getCustoHoraMaquina();
    double getCustoGbMes();
    double getCustoFilaMes();
}
