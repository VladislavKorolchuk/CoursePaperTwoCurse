package Tasks;

public enum TapeTask {

    PERSONAL_TASK("Личная задача"), WORK_TASK("Рабочая задача");

    String tapeTask;

    TapeTask(String tapeTask) {
        this.tapeTask = tapeTask;
    }

    public String getTapeTask() {
        return tapeTask;
    }

}
