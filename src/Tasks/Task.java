package Tasks;

import java.time.LocalDate;

public class Task {
    final int id;
    static int idGenerator = 0;           // id генератор
    final String heading;               // Заголовок
    final String description;           // Описание задачи
    final LocalDate date;               // Дата и время задачи
    RepeatTask repeatTask;              // Повторяемость
    TapeTask tapeTask;                  // Тип Личная/Рабочая
    LocalDate nextDate;                // Следующая повторяемость

    public Task(String heading, String description, RepeatTask repeatTask, TapeTask tapeTask) {
        id = idGenerator++;
        this.heading = heading;
        this.description = description;
        date = LocalDate.now();                // Получение текущей даты
        this.repeatTask = repeatTask;
        this.tapeTask = tapeTask;
        nextDate();
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

    public RepeatTask getRepeatTask() {
        return repeatTask;
    }

    public LocalDate getNextDate() {
        return nextDate;
    }

    public void nextDate() {  // Заполнение следующей даты ежедневника
        switch (this.repeatTask) {
            case ONE_TIME:
                nextDate = date;
                break;
            case DAILI:
                nextDate = date.plusDays(1);
                break;
            case WEEKLY:
                nextDate=date.plusWeeks(1);
                break;
            case MONTHLY:
                nextDate=date.plusMonths(1);
                break;
            case ANNUAL:
                nextDate=date.plusYears(1);
                break;
            default:
                break;
        }
    }

}
