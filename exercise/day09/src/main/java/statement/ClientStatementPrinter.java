package statement;

import account.Client;

import java.util.Map;
import java.util.stream.Collectors;

public class ClientStatementPrinter {
    private final Client client;

    public ClientStatementPrinter(Client client) {

        this.client = client;
    }

    public String print() {
        return client.getAllLines().entrySet()
                .stream()
                .map(entry -> formatLine(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator()))
                .concat(formatTotal());
    }

    private String formatLine(String name, Double value) {
        return name + " for " + value + "€";
    }

    private String formatTotal() {
        return System.lineSeparator() + "Total : " + client.getTotalAmount() + "€";
    }
}

