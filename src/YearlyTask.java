import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class YearlyTask extends Task{
    public YearlyTask(String name, String description, LocalDateTime date, LocalTime time, TypeOfTask typeOfTask) {
        super(name, description, date, time, typeOfTask);
    }

    @Override
    public boolean appersIn(LocalDate localDate) {
        LocalDateTime taskDate = this.getDate().toLocalDate().atStartOfDay();
        return localDate.equals(taskDate) ||
                (taskDate.isAfter(localDate.atStartOfDay()) && taskDate.getDayOfMonth() == localDate.getDayOfMonth()
                        && localDate.getMonth().equals(taskDate.getMonth()));
    }

    @Override
    public Repeat getRepeatType() {
        return Repeat.YEARLY;
    }
}