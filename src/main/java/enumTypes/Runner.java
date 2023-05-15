package enumTypes;

public class Runner {
    public static void main(String[] args) {

        useConstant("DEPOSIT");
        useConstant("TRANSFER");
        useConstant("EFT");//CTE vermez.

        //sadece sınırlı ve sabit değişkenler kullanabilmek için ENUM type kullanmalıyız...



    }

    public static void useConstant(String secim){
        if(secim==TransactionTypeConstant.DEPOSIT){
            System.out.println("Para yatırma işlemi seçildi.");
        } else if (secim==TransactionTypeConstant.WITHDRAW) {
            System.out.println("Para çekme işlemi seçildi.");
        }else if (secim==TransactionTypeConstant.TRANSFER) {
            System.out.println("Para transfer işlemi seçildi.");
        }else if (secim==TransactionTypeConstant.PAYMENT) {
            System.out.println("Ödeme işlemi seçildi.");
        }else if (secim==TransactionTypeConstant.OTHER) {
            System.out.println("Diğer işlemler...");
        }
    }



}