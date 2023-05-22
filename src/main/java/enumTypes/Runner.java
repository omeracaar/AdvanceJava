package enumTypes;

public class Runner {
    public static void main(String[] args) {

        useConstant("DEPOSIT");
        useConstant("TRANSFER");
        useConstant("EFT");//CTE vermez.

        //sadece sınırlı ve sabit değişkenler kullanabilmek için ENUM type kullanmalıyız...

        useEnumType(TransactionTypeEnum.DEPOSIT);
        useEnumType(TransactionTypeEnum.TRANSFER);
        //useEnumType(TransactionTypeEnum."EFT");//CTE


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

    //enum type ile ayni methodu olusturalim
    public static void useEnumType(TransactionTypeEnum secim){
        if (secim==TransactionTypeEnum.DEPOSIT){
            System.out.println("Para yatirma işlemi seçildi.");
        }else if (secim==TransactionTypeEnum.WITHDRAW){
            System.out.println("Para cekme işlemi seçildi.");
        } else if (secim==TransactionTypeEnum.TRANSFER) {
            System.out.println("Para transfer işlemi seçildi.");
        } else if (secim==TransactionTypeEnum.PAYMENT) {
            System.out.println("Odeme işlemi seçildi.");
        } else if (secim==TransactionTypeEnum.OTHER) {
            System.out.println("Diger islemler...");
        }

        if (secim.getCode()==10){
            System.out.println("Islem kodu = " + secim);
        }

        System.out.println("Enum ismi: "+secim.name());
        System.out.println("Enum ordinal: "+secim.ordinal());
    }




}