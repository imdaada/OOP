public class Person {
    private String name;
    private String surname;
    private Money balance;

    Person(String name, String surname, Money balance) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    public void addMoney(Money money) {
        this.balance.sum(money);
    }

    public void deleteMoney(Money money) {
        this.balance.min(money);
    }

    public void showBalance() {
        this.balance.show();
    }

}
