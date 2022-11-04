import Tasks.RepeatTask;
import Tasks.TapeTask;
import Tasks.Task;
import Tasks.TaskList;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    // static HashMap<Integer, Task> taskHashMap = new HashMap<>();
    static TaskList taskList = new TaskList();

    public static void main(String[] args) throws IOException, ParseException {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1: // Добавление задачи
                            inputTask(scanner);
                            break;
                        case 2: // Удаление задачи с заданным ID
                            System.out.print("Введите ID задачи для удаления ");
                            int delete = scanner.nextInt();
                            if (taskList.deleteTask(delete)) {
                                System.out.println("\nЗадача с заданным ID - удалена успешно!\n");
                            } else {
                                System.out.println("\n!  Не удается удалить задачу т.к. она не существует\n");
                            }
                            break;
                        case 3: // Получение задачи на указанный день

                            System.out.print("Введите дату для поиска задачи в формате yyyy-mm-dd - ");
                            String dateInputStr = scanner.next();
                            if (!isValidDate(dateInputStr)) {
                                LocalDate dateInput = LocalDate.parse(dateInputStr);
                                taskList.receivingTask(dateInput);
                            }
                            else {
                                System.out.print("Введена дата не по формату!");
                            }
                            break;
                        case 4: // Вывод всех задач в консоль
                            taskList.taskListAllInfo();
                            break;
                        case 0:
                            break label;
                        default:
                            throw new IllegalStateException("Unexpected value: " + menu);
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {

        System.out.print("Введите заголовок задачи: ");
        String headingName = scanner.next();
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String descriptionName = scanner.next();

        int repeatability;
        do {
            System.out.print("Введите повторяемость задачи: 1/однократная,2/ежедневная,3/еженедельная,4/ежемесячная,5/ежегодная ");
            repeatability = scanner.nextInt();
        } while (!(repeatability > 0 && repeatability < 6));

        switch (repeatability) {
            case 1:
                Task task1 = new Task(headingName, taskName, RepeatTask.ONE_TIME, TapeTask.PERSONAL_TASK);
                taskList.addList(task1.getId(), task1);
                break;
            case 2:
                Task task2 = new Task(headingName, taskName, RepeatTask.DAILI, TapeTask.PERSONAL_TASK);
                taskList.addList(task2.getId(), task2);
                break;
            case 3:
                Task task3 = new Task(headingName, taskName, RepeatTask.WEEKLY, TapeTask.PERSONAL_TASK);
                taskList.addList(task3.getId(), task3);
                break;
            case 4:
                Task task4 = new Task(headingName, taskName, RepeatTask.MONTHLY, TapeTask.PERSONAL_TASK);
                taskList.addList(task4.getId(), task4);
                break;
            case 5:
                Task task5 = new Task(headingName, taskName, RepeatTask.ANNUAL, TapeTask.PERSONAL_TASK);
                taskList.addList(task5.getId(), task5);
                break;
            //     default:
        }
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу \n" +
                        "2. Удалить задачу \n" +
                        "3. Получить задачу на указанный день \n" +
                        "4. Получить все задачи \n" +
                        "0. Выход \n"
        );
    }

    public static boolean isValidDate(String dateStr) {   // Проверка введенной даты на правильность формата

        if (!dateStr.matches("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])")) {
            return true;
        }
        else {
            return false;
        }
    }

}

