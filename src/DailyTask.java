import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;

public class DailyTask extends Task {
    public DailyTask(String name, String description, LocalDateTime date, LocalTime time, TypeOfTask typeOfTask) {
        super(name, description, date, time, typeOfTask);
    }

    @Override
    public boolean appersIn(LocalDate localDate) {
        LocalDateTime taskDate = this.getDate().toLocalDate().atStartOfDay();
        return localDate.equals(taskDate) || localDate.isAfter(ChronoLocalDate.from(taskDate));
    }

    @Override
    public Repeat getRepeatType() {
        return Repeat.DAILY;
    }
}