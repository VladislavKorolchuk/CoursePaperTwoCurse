package Tasks;

public enum DivisionByType {

    PERSONAL_TASK("Личная задача"), WORK_TASK("Рабочая задача");

    String tapeTask;

    DivisionByType(String tapeTask) {
        this.tapeTask = tapeTask;
    }

    public String getTapeTask() {
        return tapeTask;
    }

}
