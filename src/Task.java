import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public abstract class Task {
    Scanner sc = new Scanner(System.in);

    private String name;
    private final int id;
    private int counter;
    private String description;
    private LocalDateTime date;
    private LocalTime time;
    private TypeOfTask typeOfTask;


    public Task(String name, String description, LocalDateTime date, LocalTime time, TypeOfTask typeOfTask) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.typeOfTask = typeOfTask;
        this.id = counter++;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {
        if (description.isEmpty() || description == null) {
            throw new IllegalArgumentException("Не введено описание задачи");
        } else {this.description = description;}
    }

    public String getName() {return name;}



    public void setName(String name) {
        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Не введено название задачи");
        } else {
            this.name = name;
        }
    }
    public int getId() {return id;}

    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public abstract boolean appersIn(LocalDate localDate);

    public abstract Repeat getRepeatType();


}