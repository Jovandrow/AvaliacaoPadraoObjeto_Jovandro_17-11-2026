public class EscolhaDeProvedor {
    public static ProvedorNuvem escolher(String nome) {
        switch (nome) {
            case "Aws":   return new AwsProvedor();
            case "Azure": return new AzureProvedor();
            default: throw new IllegalArgumentException("Provedor desconhecido: " + nome);
        }
    }
}
