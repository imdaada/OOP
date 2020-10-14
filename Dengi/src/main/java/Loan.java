public class Loan extends Subscription {
    Loan(Person person, Money money) {
        super(person, money);
    }

    @Override
    public void event(int time) {
        if (time % 30 == 0) {
            person.deleteMoney(money);
        }
    }

}
