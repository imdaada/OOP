import java.util.ArrayList;
import java.util.List;

public class Person implements TimeUser {
    private String name;
    private String surname;
    //private int time = 0;
    private Money balance;
    private List<Subscription> subscriptions = new ArrayList<Subscription>();

    Person(String name, String surname, Money balance) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        Time.getInstance().subscribe(this);
    }

    public void addMoney(Money money) {
        this.balance.sum(money);
    }

    public void deleteMoney(Money money) {
        this.balance.min(money);
    }

    public void subscribe(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void showBalance() {
        this.balance.show();
    }

    public Money getMoney() {
        return balance;
    }

   /* public void addTime(){
            time += 1;
            subscriptions.forEach((Subscription a) -> {
                a.event(time);
            });
    } */

    @Override
    public void time() {
        subscriptions.forEach((Subscription a) -> {
            a.event(Time.getInstance().getTime());
        });
    }
}
