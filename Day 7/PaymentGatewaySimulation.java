import java.util.UUID;

interface PaymentMethod {
    void pay(double amount);
}

class UPIPayment implements PaymentMethod {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI Payment of ₹" + amount + " for ID: " + upiId);
    }
}

class CreditCardPayment implements PaymentMethod {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card Payment of ₹" + amount + " for Card: ****" + cardNumber.substring(cardNumber.length() - 4));
    }
}

class NetBankingPayment implements PaymentMethod {
    private String bankName;

    public NetBankingPayment(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing NetBanking Payment of ₹" + amount + " via " + bankName);
    }
}

class PaymentFactory {
    public static PaymentMethod getPaymentMethod(String type, String detail) {
        if (type.equalsIgnoreCase("UPI")) return new UPIPayment(detail);
        else if (type.equalsIgnoreCase("CREDIT")) return new CreditCardPayment(detail);
        else if (type.equalsIgnoreCase("NETBANKING")) return new NetBankingPayment(detail);
        throw new IllegalArgumentException("Unsupported Payment Method");
    }
}

public class PaymentGatewaySimulation {
    public static void main(String[] args) {
        processTransaction("UPI", "user@upi", 500.0);
        processTransaction("CREDIT", "1234567890123456", 1500.0);
    }

    public static void processTransaction(String type, String detail, double amount) {
        String transactionId = UUID.randomUUID().toString();
        System.out.println("\n--- Initializing Transaction: " + transactionId + " ---");
        try {
            PaymentMethod method = PaymentFactory.getPaymentMethod(type, detail);
            method.pay(amount);
            System.out.println("Status: SUCCESS | Transaction ID: " + transactionId);
        } catch (Exception e) {
            System.out.println("Status: FAILED | Reason: " + e.getMessage());
        }
    }
}
