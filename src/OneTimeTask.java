import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OneTimeTask extends Task{
    public OneTimeTask(String name, String description, LocalDateTime date, LocalTime time, TypeOfTask typeOfTask) {
        super(name, description, date, time, typeOfTask);
    }

    @Override
    public boolean appersIn(LocalDate localDate) {
        return localDate.equals(this.getDate().toLocalDate());
    }

    @Override
    public Repeat getRepeatType() {
        return Repeat.ONETIME;
    }
}
