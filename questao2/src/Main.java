import java.math.BigDecimal;

public class Main {
    private static BigDecimal r(String valor) {
        return new BigDecimal(valor);
    }

    private static void lance(Lote lote, Participante quem, String valor) {
        System.out.println(">> " + quem.getNome() + " da lance de " + Dinheiro.formatar(r(valor)) + " no lote '" + lote.getNome() + "'");
        try {
            lote.darLance(quem, r(valor));
        } catch (LanceRecusadoException e) {
            System.out.println("   RECUSADO: " + e.getMessage());
        }
    }

    private static void encerrar(Lote lote) {
        lote.encerrar();
        if (lote.isVendido()) {
            System.out.println("Lote '" + lote.getNome() + "' VENDIDO a " + lote.getComprador().getNome()
                + " por " + Dinheiro.formatar(lote.getValorVenda()));
        } else {
            System.out.println("Lote '" + lote.getNome() + "' NAO VENDIDO (maior lance " + Dinheiro.formatar(lote.getLanceAtual())
                + ", reserva " + Dinheiro.formatar(lote.getPrecoReserva()) + ")");
        }
    }

    public static void main(String[] args) {
        Categoria arte = new Categoria("Arte", new ComissaoArte());
        Categoria veiculos = new Categoria("Veiculos", new ComissaoVeiculos());

        Lote quadro = new Lote("Quadro Abstrato", arte, r("1000.00"), r("1500.00"));
        Lote moto = new Lote("Moto Classica 1975", veiculos, r("8000.00"), r("12000.00"));

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        quadro.acompanhar(ana);
        quadro.acompanhar(bruno);
        quadro.acompanhar(carla);
        quadro.acompanhar(painel);
        quadro.acompanhar(auditor);
        moto.acompanhar(ana);
        moto.acompanhar(bruno);
        moto.acompanhar(painel);
        moto.acompanhar(auditor);

        System.out.println("=== Lances no lote 'Quadro Abstrato' ===");
        lance(quadro, ana, "1100.00");
        lance(quadro, bruno, "1120.00");
        lance(quadro, bruno, "1200.00");

        System.out.println("\nBruno deixa de acompanhar o lote 'Quadro Abstrato'");
        quadro.deixarDeAcompanhar(bruno);
        lance(quadro, carla, "1300.00");
        lance(quadro, ana, "1400.00");
        lance(quadro, carla, "1550.00");

        System.out.println("\n=== Lances no lote 'Moto Classica 1975' ===");
        lance(moto, ana, "8400.00");
        lance(moto, bruno, "9000.00");

        System.out.println("\n=== Campanha: o quadro passa a usar a regra de Eletronicos ===");
        quadro.trocarRegraComissao(new ComissaoEletronicos());

        System.out.println("\n=== Encerramentos ===");
        encerrar(quadro);
        encerrar(moto);
        lance(quadro, ana, "2000.00");

        System.out.println();
        AcertoVendedor.imprimir(quadro);

        System.out.println();
        Compra compra = new VendaBase(quadro);
        compra = new SeguroTransporte(compra);
        compra = new EmbalagemEspecial(compra);
        compra = new EmbalagemEspecial(compra);
        compra = new CertificadoAutenticidade(compra);
        Fatura.imprimir(compra);

        System.out.println();
        System.out.println("Fatura sem servicos adicionais:");
        Fatura.imprimir(new VendaBase(quadro));
    }
}
