package model.nayem;

public class TransactionHistory 
{
    String transID;
    String transType;
    String amount;

    public TransactionHistory(String transID, String transType, String amount) {
        this.transID = transID;
        this.transType = transType;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" + "transID=" + transID + ", transType=" + transType + ", amount=" + amount + '}';
    }
    
    
}
