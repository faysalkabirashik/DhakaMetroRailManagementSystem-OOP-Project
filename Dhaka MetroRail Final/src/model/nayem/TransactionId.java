package model.nayem;
import java.util.UUID;
public class TransactionId 
{
    private String transactionId;

    public TransactionId() {
        this.transactionId = generateTransactionId();
    }

    private String generateTransactionId() {
        return UUID.randomUUID().toString();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
//TransactionId transactionId = new TransactionId();
//String id = transactionId.getTransactionId();
//System.out.println("Transaction ID: " + id);