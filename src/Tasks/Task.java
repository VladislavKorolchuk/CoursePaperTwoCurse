package Tasks;

import java.time.LocalDate;

public class Task {
    final int id;
    static int idGenerator = 0;           // id генератор
    final String heading;               // Заголовок
    final String description;           // Описание задачи
    final LocalDate date;               // Дата и время задачи
    final TypeOfTaskRepeat repeatTask;              // Повторяемость
    final DivisionByType tapeTask;                  // Тип Личная/Рабочая
    LocalDate nextDate;                // Следующая повторяемость

    public Task(String heading, String description, TypeOfTaskRepeat repeatTask, DivisionByType tapeTask) {
        id = idGenerator++;
        this.heading = heading;
        this.description = description;
        date = LocalDate.now();                // Получение текущей даты
        this.repeatTask = repeatTask;
        this.tapeTask = tapeTask;
        this.nextDate = nextDate();
    }

    @Override
    public String toString() {
        return " Задача - " +
                ", Заголовок - '" + heading + '\'' +
                ", Описание - '" + description + '\'' +
                ", Дата - " + date +
                ", Повторяемость - " + repeatTask.getRepeatTask() +
                ", Тип - " + tapeTask.getTapeTask() + "\n";
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public TypeOfTaskRepeat getRepeatTask() {
        return repeatTask;
    }

    public LocalDate getNextDate() {
        return nextDate;
    }

    public LocalDate nextDate() {  // Заполнение следующей даты ежедневника
        switch (this.repeatTask) {
            case ONE_TIME:
                return date;
            case DAILY:
                return date.plusDays(1);
            case WEEKLY:
                return date.plusWeeks(1);
            case MONTHLY:
                return date.plusMonths(1);
            case ANNUAL:
                return date.plusYears(1);
            default:
                return date;
        }
    }

}
