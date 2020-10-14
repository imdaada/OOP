public class Salary extends Subscription {

    private Money oplata;
    private Money avans;
    Salary(Person person, Money money) throws CloneNotSupportedException {
        super(person, money);
        oplata = (Money) money.clone();
        avans = (Money) money.clone();
        avans.div(2);
        oplata.min(avans);
    }

    @Override
    public void event(int time) {
        if ((time % 12 == 0  && time < 20) || (time % 42 == 0 )) {
            person.addMoney(avans);
        }
        else if (time % 30 == 0) {
            person.addMoney(oplata);
        }
    }
}
