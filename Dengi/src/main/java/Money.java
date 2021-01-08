import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.*;

public class Money implements Cloneable, Serializable {
    private long rub;
    private long cop;

    Money(long rub, int cop) {
        this.cop = cop;
        this.rub = rub;
    }

    Money() {
        cop = 0;
        rub = 0;
    }

    public void show() {
       System.out.println(toString());
    }

    public long getRub() {
        return rub;
    }

    public long getCop() {
        return cop;
    }

    public void setRub(long rub) {
        this.rub = rub;
    }

    public void setCop(int cop) {
        this.cop = cop;
    }

    public void sum(Money money) {
        this.rub = this.rub + money.rub;
        this.cop = this.cop + money.cop;
        if (this.cop >= 100) {
            this.rub = this.rub + this.cop / 100;
            this.cop = this.cop - (this.cop / 100) * 100;
        }
    }

    public void min(Money money) {
        this.rub = this.rub - money.rub;
        this.cop = this.cop - money.cop;
        if (this.cop < 0) {
            this.rub -= 1;
            this.cop = 100 + this.cop;
        }
    }

    public void mult(int i) {
        this.rub = this.rub * i;
        this.cop = this.cop * i;
        if (this.cop >= 100) {
            this.rub = this.rub + this.cop / 100;
            this.cop = this.cop - (this.cop / 100) * 100;
        }
    }

    public void div(int i) {
        long cop = this.rub * 100 + this.cop;
        cop = cop / i;
        if (cop >= 100) {
            this.rub = cop / 100;
            this.cop = (int) (cop - (cop / 100) * 100);
        } else {
            this.rub = 0;
            this.cop = (int) cop;
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("rub", rub)
                .append("cop", cop)
                .toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
