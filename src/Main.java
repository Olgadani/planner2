import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Scanner;
public class Main {
    private static final TaskList TASKLIST = new TaskList();
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TASKLIST.addTask(new OneTimeTask("Test", "test", LocalDateTime.now(), LocalTime.now(), TypeOfTask.WORK));
        TASKLIST.addTask(new DailyTask("Test1", "test", LocalDateTime.now(), LocalTime.now(), TypeOfTask.WORK));
        TASKLIST.addTask(new WeeklyTask("Test2", "test", LocalDateTime.now(), LocalTime.now(), TypeOfTask.WORK));
        TASKLIST.addTask(new MonthlyTask("Test3", "test", LocalDateTime.now(), LocalTime.now(), TypeOfTask.WORK));
        TASKLIST.addTask(new YearlyTask("Test4", "test", LocalDateTime.now(), LocalTime.now(), TypeOfTask.WORK));
        printTaskForDate(scanner);

    }

    private static void printTaskForDate(Scanner scanner) {
        LocalDate localDate = readDate(scanner);
        Collection<Task> tasksForDate = TASKLIST.getTasksForDay(localDate);
        System.out.println("Задачи на: " + localDate.format(DATE_FORMAT));
        for (Task task : tasksForDate) {
            System.out.printf("[%s] %s: %s (%s)%n", localizeType(task.getTypeOfTask()),
                    task.getName(), task.getDate(), task.getDescription());
        }
    }

    private static LocalDate readDate(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите дату: ");
                String dateLine = scanner.nextLine();
                return LocalDate.parse(dateLine, DATE_FORMAT);

            } catch (DateTimeParseException e) {
                System.out.println("Введена дата в неверном формате");
            }
        }
    }
    private static String localizeType(TypeOfTask typeOfTask) {
        switch (typeOfTask) {
            case WORK:
                System.out.println("Рабочая");
                break;
            case PERSONAL:
                System.out.println("Личная");
                break;
        }
        return null;
    }
}