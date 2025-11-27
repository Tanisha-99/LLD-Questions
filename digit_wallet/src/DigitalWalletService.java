import entities.Account;
import entities.Currency;
import entities.User;
import repositories.AccountRepository;
import repositories.TransactionRepository;
import repositories.UserRepository;
import services.CurrencyService;
import services.WalletService;

import java.math.BigDecimal;

public class DigitalWalletService {
    private static DigitalWalletService instance;
    private WalletService walletService;
    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private CurrencyService currencyService;

    private DigitalWalletService() {
        this.userRepository = new UserRepository();
        this.accountRepository = new AccountRepository();
        this.transactionRepository = new TransactionRepository();
        this.currencyService = new CurrencyService();

        this.walletService = new WalletService(userRepository, accountRepository, transactionRepository, currencyService);
    }

    public static synchronized DigitalWalletService getInstance() {
        if(instance == null) {
            instance = new DigitalWalletService();
        }

        return instance;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    public void transfer(BigDecimal amount, String source, String destination) {
        walletService.transfer(source, destination, amount);
    }

    public void credit(String accountId, BigDecimal amount) {
        try{
            accountRepository.credit(accountId, amount);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
