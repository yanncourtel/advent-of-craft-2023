import account.Client;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import statement.ClientStatementPrinter;

import java.util.LinkedHashMap;

import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;

class ClientTests {
    private final Client client = new Client(new LinkedHashMap<>() {{
        put("Tenet Deluxe Edition", 45.99);
        put("Inception", 30.50);
        put("The Dark Knight", 30.50);
        put("Interstellar", 23.98);
    }});

    @Test
    public void client_should_get_total_amount(){
        assertThat(client.getTotalAmount()).isEqualTo(130.97);
    }

    @Test
    public void client_should_get_all_lines(){
        assertThat(client.getAllLines().size()).isEqualTo(4);
    }

    @Nested class Statement {

        @Test
        void client_statement_printer_should_print_statement () {
            String statement = client.toStatement();

            ClientStatementPrinter printer = new ClientStatementPrinter(client);

            assertThat(printer.print()).isEqualTo(
                    "Tenet Deluxe Edition for 45.99€" + lineSeparator() +
                            "Inception for 30.5€" + lineSeparator() +
                            "The Dark Knight for 30.5€" + lineSeparator() +
                            "Interstellar for 23.98€" + lineSeparator() +
                            "Total : 130.97€");
        }
    }
}