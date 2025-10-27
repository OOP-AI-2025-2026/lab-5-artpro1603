package ua.opnu;

public class TimeSpan {

    private static final int MAX_MINUTES = 59;
    private static final int MINUTES_IN_HOUR = 60;

    private int hours;
    private int minutes;

    // Конструктори
    public TimeSpan() {
        this(0, 0);
    }

    public TimeSpan(int minutes) {
        this(minutes / MINUTES_IN_HOUR, minutes % MINUTES_IN_HOUR);
    }

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Години й хвилини мають бути додатніми");
        }
        this.hours = hours + minutes / MINUTES_IN_HOUR;
        this.minutes = minutes % MINUTES_IN_HOUR;
    }

    public TimeSpan(TimeSpan other) {
        this(other.hours, other.minutes);
    }

    // Гетери
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // Додавання
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) return;
        int totalMinutes = this.minutes + minutes;
        this.hours += hours + totalMinutes / MINUTES_IN_HOUR;
        this.minutes = totalMinutes % MINUTES_IN_HOUR;
    }

    public void add(int minutes) {
        add(0, minutes);
    }

    public void add(TimeSpan span) {
        add(span.hours, span.minutes);
    }

    // Віднімання
    public void subtract(int hours, int minutes) {
        int totalCurrent = getTotalMinutes();
        int totalSubtract = hours * MINUTES_IN_HOUR + minutes;

        if (totalSubtract <= totalCurrent) {
            int newMinutes = totalCurrent - totalSubtract;
            this.hours = newMinutes / MINUTES_IN_HOUR;
            this.minutes = newMinutes % MINUTES_IN_HOUR;
        }
    }

    public void subtract(int minutes) {
        subtract(0, minutes);
    }

    public void subtract(TimeSpan span) {
        subtract(span.hours, span.minutes);
    }

    public int getTotalMinutes() {
        return hours * MINUTES_IN_HOUR + minutes;
    }

    public double getTotalHours() {
        return (double) getTotalMinutes() / MINUTES_IN_HOUR;
    }

    public void scale(int factor) {
        if (factor > 0) {
            int total = getTotalMinutes() * factor;
            this.hours = total / MINUTES_IN_HOUR;
            this.minutes = total % MINUTES_IN_HOUR;
        }
    }
}
