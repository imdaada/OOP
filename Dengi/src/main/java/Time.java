import java.util.ArrayList;

public class Time {
    private static Time instance;
    private int time = 0;
    private ArrayList<TimeUser> timeUsers = new ArrayList<>();

    private  Time() {};
    public void subscribe (TimeUser timeUser) {
        timeUsers.add(timeUser);
    }

    public void unsubscribe (TimeUser timeUser) {
        timeUsers.remove(timeUser);
    }

    public void addTime () {
        time += 1;
        timeUsers.forEach(TimeUser::time);
    }

    public int getTime() {
            return instance.time;
    }

    public static Time getInstance() {
        if (instance == null) {
            instance = new Time();
            return instance;
        }
        else {
            return instance;
        }
    }
}
