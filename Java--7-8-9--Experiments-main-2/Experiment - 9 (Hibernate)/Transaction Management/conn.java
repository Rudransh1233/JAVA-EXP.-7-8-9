@Entity
@Table(name = "accounts")
public class Account {
    @Id
    private int id;
    private String name;
    private double balance;

    // Getters, setters, constructors
}
