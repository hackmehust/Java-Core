package designpattern.structural;

/*
Ví dụ: Một công ty bán hàng online, chẳng hạn Tiki cung cấp nhiều lựa chọn cho khách hàng khi mua sản phẩm. Khi một
sản phẩm được mua, nó sẽ qua các bước xử lý: lấy thông tin về tài khoản mua hàng, thanh toán, vận chuyển,
gửi Email/ SMS thông báo.

Ứng dụng của chúng ta được thiết kế với Facade Pattern, bao gồm các class như sau:

Thông tin về tài khoản (AccountService) : lấy thông tin cơ bản của khách hàng thông qua email được cung cấp.
    Dịch vụ thanh toán (PaymentService) : có thể thanh toán thông qua Paypal, thẻ tín dụng (Credit Card), tài khoản ngân hàng
trực tuyến (E-banking), Tiền mặt (cash).
    Dịch vụ vận chuyển (ShippingService) : có thể chọn Free Shipping, Standard Shipping, Express Shipping.
    Dịch vụ email (EmailService) : có thể gửi mail cho khách hàng về tình hình đặt hàng, thanh toán, vận chuyển, nhận hàng.
    Dịch vụ tin nhắn (SMS) : có thể gửi thông báo SMS cho khách hàng khi thanh toán online.
 * ShopFacade : là một Facade Pattern, class này bao gồm các dịch vụ có bên trong hệ thống. Nó cung cấp một vài phương
thức để Client có thể dễ dàng mua hàng. Tùy vào nghiệp vụ mà nó sẽ sử dụng những dịch tương ứng, chẳng hạn dịch vụ SMS
chỉ được sử dụng nếu khách hàng đăng ký mua hàng thông qua hình thức thanh toán online (Paypal, E-banking, …).
    Client : là người dùng cuối sử dụng ShopFacade để mua hàng.
* */

class AccountService {
    public void getAccount(String email) {
        System.out.println("Getting the account of " + email);
    }
}
class PaymentService {
    public void paymentByPaypal() {
        System.out.println("Payment by Paypal");
    }
    public void paymentByCreditCard() {
        System.out.println("Payment by Credit Card");
    }
    public void paymentByEbankingAccount() {
        System.out.println("Payment by E-banking account");
    }
    public void paymentByCash() {
        System.out.println("Payment by cash");
    }
}

class ShippingService {
    public void freeShipping() {
        System.out.println("Free Shipping");
    }
    public void standardShipping() {
        System.out.println("Standard Shipping");
    }
    public void expressShipping() {
        System.out.println("Express Shipping");
    }
}

class EmailService {
    public void sendMail(String mailTo) {
        System.out.println("Sending an email to " + mailTo);
    }
}

class SmsService {
    public void sendSMS(String mobilePhone) {
        System.out.println("Sending an mesage to " + mobilePhone);
    }
}

// Facade Pattern
class ShopFacade {
    private static final ShopFacade INSTANCE = new ShopFacade();
    private AccountService accountService;
    private PaymentService paymentService;
    private ShippingService shippingService;
    private EmailService emailService;
    private SmsService smsService;
    private ShopFacade() {
        accountService = new AccountService();
        paymentService = new PaymentService();
        shippingService = new ShippingService();
        emailService = new EmailService();
        smsService = new SmsService();
    }
    public static ShopFacade getInstance() {
        return INSTANCE;
    }
    public void buyProductByCashWithFreeShipping(String email) {
        accountService.getAccount(email);
        paymentService.paymentByCash();
        shippingService.freeShipping();
        emailService.sendMail(email);
        System.out.println("Done\n");
    }
    public void buyProductByPaypalWithStandardShipping(String email, String mobilePhone) {
        accountService.getAccount(email);
        paymentService.paymentByPaypal();
        shippingService.standardShipping();
        emailService.sendMail(email);
        smsService.sendSMS(mobilePhone);
        System.out.println("Done\n");
    }
}

public class Facade {
    public static void main(String[] args) {
        ShopFacade.getInstance().buyProductByCashWithFreeShipping("contact@gpcoder.com");
        ShopFacade.getInstance().buyProductByPaypalWithStandardShipping("gpcodervn@gmail.com", "0988.999.999");
    }
}
