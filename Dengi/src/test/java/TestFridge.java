import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

 public class TestFridge {
     @Test
     public void testMoney() {
         Money m1, m2;
         m1 = new Money(1, 20);
         m1.show();
         m2 = new Money(2, 99);
         m2.show();
         System.out.println("+\n");
         m1.sum(m2);
         m1.show();
         System.out.println("-\n");
         m1.min(m2);
         m1.show();
         System.out.println("*\n");
         m1.mult(2);
         m1.show();
         System.out.println("/\n");
         m1.div(3);
         m1.show();
     }

     @Test
     public void testPerson() {
         Person person = new Person("Petr", "GG", new Money());
         System.out.println("Zero balance\n");
         person.showBalance();
         System.out.println("Add 2.20\n");
         person.addMoney(new Money(2, 20));
         person.showBalance();
         System.out.println("Delete 1.11\n");
         person.deleteMoney(new Money(1, 11));
         person.showBalance();
     }

     @Test
     public void testSub() throws CloneNotSupportedException {
         Person person = new Person("Petr", "GG", new Money());
         assertEquals(person.getMoney().getRub(), 0);
         assertEquals(person.getMoney().getCop(), 0);
         person.subscribe(new Salary(person, new Money(100, 0)));
         for (int i = 0; i<35; i++) {
             Time.getInstance().addTime();
         }
         assertEquals(person.getMoney().getRub(), 100);
         person.subscribe(new Salary(person, new Money(100, 0)));
         person.subscribe(new Loan(person, new Money(50, 0)));
         for (int i = 0; i<20; i++) {
             Time.getInstance().addTime();
         }
         assertEquals(person.getMoney().getRub(), 200);
         person.showBalance();
     }
}
