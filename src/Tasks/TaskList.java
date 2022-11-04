package Tasks;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TaskList {
    private HashMap<Integer, Task> taskHashMap = new HashMap<>();

    public void addList(int id, Task task) {         // Добавление задачи
        taskHashMap.put(id, task);
    }

    public void taskListAllInfo() {

        for (Map.Entry<Integer, Task> entry : taskHashMap.entrySet()) {
            System.out.println("id = " + entry.getKey() + "   " + entry.getValue());
        }
    }

    public boolean deleteTask(int id) {            // Удаление задачи
        boolean fladDelete = false;
        for (Map.Entry<Integer, Task> entry : taskHashMap.entrySet()) {
            if (entry.getKey() == id) {
                taskHashMap.remove(id);
                fladDelete = true;
                break;
            }
        }
        return fladDelete;
    }

    public void receivingTask(LocalDate dateInput) {         // Поиск задачи по указанной дате
        System.out.println("dateInput=" + dateInput);
        for (Map.Entry<Integer, Task> entry : taskHashMap.entrySet()) {
            if (entry.getValue().getNextDate().equals(dateInput)) {
                System.out.println(entry.getValue());
            }
        }
    }

}