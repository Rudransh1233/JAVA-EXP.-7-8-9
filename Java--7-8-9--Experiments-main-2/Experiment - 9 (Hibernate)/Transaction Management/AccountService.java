@Service
public class AccountService {
    @Autowired
    private AccountDAO dao;

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Account from = dao.getAccount(fromId);
        Account to = dao.getAccount(toId);

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        dao.updateAccount(from);
        dao.updateAccount(to);

        System.out.println("Transfer successful!");
    }
}
