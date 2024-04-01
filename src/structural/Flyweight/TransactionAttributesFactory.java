package structural.Flyweight;

import java.util.ArrayList;
import java.util.List;

public class TransactionAttributesFactory {
    private static final List<TransactionAttributes> transactionAttributesList = new ArrayList<>();

    public static TransactionAttributes getTransactionAttributes(double amount, String date, String type) {

        for (TransactionAttributes attributes : transactionAttributesList) {
            if (attributes.getAmount() == amount && attributes.getDate().equals(date) && attributes.getType().equals(type)) {
                return attributes;
            }
        }

        TransactionAttributes newAttributes = new TransactionAttributes(amount, date, type);
        transactionAttributesList.add(newAttributes);
        return newAttributes;
    }
}