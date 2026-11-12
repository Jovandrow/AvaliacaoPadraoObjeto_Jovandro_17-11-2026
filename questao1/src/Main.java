public class Main {
    private static Thread provisionar(Solicitacao solicitacao) {
        return new Thread(() -> {
            ProvedorNuvem provedor = EscolhaDeProvedor.escolher(solicitacao.getProvedor());
            new MontadorDeAmbiente(provedor).montar(solicitacao);
        });
    }

    public static void main(String[] args) throws InterruptedException {
        Thread aws1 = provisionar(new Solicitacao("ambiente-web", "Aws", 2, 100));
        Thread azure = provisionar(new Solicitacao("ambiente-dados", "Azure", 3, 200));
        Thread aws2 = provisionar(new Solicitacao("ambiente-api", "Aws", 5, 500));
        Thread recusado = provisionar(new Solicitacao("ambiente-gigante", "Aws", 20, 1000));

        aws1.start();
        azure.start();
        aws1.join();
        azure.join();

        aws2.start();
        recusado.start();
        aws2.join();
        recusado.join();

        System.out.println();
        System.out.println("=== Historico de auditoria ===");
        for (String registro : AuditLog.getInstance().getRegistros()) {
            System.out.println(registro);
        }
    }
}
