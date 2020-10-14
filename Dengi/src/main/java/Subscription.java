public class Subscription {
    protected Person person;
    protected Money money;

    Subscription(Person person, Money money) {
        this.money = money;
        this.person = person;
    }
    public void event(int time) {
    }
}
