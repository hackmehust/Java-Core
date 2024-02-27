package designpattern.creational;

// Supper class
interface Bank {
    String getBankName();
}

// Subclass 1
// bill pugh singleton: sử dụng thêm 1 class Helper
class TPBank implements Bank {

    private TPBank() {
    }

    public static TPBank getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final TPBank INSTANCE = new TPBank();
    }

    @Override
    public String getBankName() {
        return "TPBank";
    }
}
// Subclass 2
class VietcomBank implements Bank {
    @Override
    public String getBankName() {
        return "VietcomBank";
    }
}

// Factory class
class BankFactory {
    private BankFactory() {
    }
    public static final Bank getBank(BankType bankType) {
        switch (bankType) {
            case TPBANK:
                return TPBank.getInstance();
            case VIETCOMBANK:
                return new VietcomBank();
            default:
                throw new IllegalArgumentException("This bank type is unsupported");
        }
    }
}

//Bank type:
enum BankType {
    VIETCOMBANK, TPBANK;
}

//Client:
public class Factory {
    public static void main(String[] args) {
        Bank bank1 = BankFactory.getBank(BankType.TPBANK);
        Bank bank2 = BankFactory.getBank(BankType.TPBANK);
        System.out.println(bank1); // designpattern.creational.TPBank@6f496d9f
        System.out.println(bank2); // designpattern.creational.TPBank@6f496d9f

        Bank bank3 = BankFactory.getBank(BankType.VIETCOMBANK);
        Bank bank4 = BankFactory.getBank(BankType.VIETCOMBANK);
        System.out.println(bank3); // designpattern.creational.VietcomBank@10f87f48
        System.out.println(bank4); // designpattern.creational.VietcomBank@b4c966a
    }
}
