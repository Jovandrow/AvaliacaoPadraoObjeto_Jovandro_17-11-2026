import java.math.BigDecimal;
import java.util.Locale;

public class Dinheiro {
    private static final Locale BR = Locale.forLanguageTag("pt-BR");

    public static String formatar(BigDecimal valor) {
        return String.format(BR, "R$ %,.2f", valor);
    }
}
