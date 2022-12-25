import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String name, String description, LocalDateTime date, LocalTime time, TypeOfTask typeOfTask) {
        super(name, description, date, time, typeOfTask);
    }

    @Override
    public boolean appersIn(LocalDate localDate) {
        LocalDateTime taskDate = this.getDate().toLocalDate().atStartOfDay();
        return localDate.equals(taskDate) ||
                localDate.getDayOfWeek().equals(taskDate.getDayOfWeek());
    }

    @Override
    public Repeat getRepeatType() {
        return Repeat.WEEKLY;
    }
}
