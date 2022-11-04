package Tasks;

public enum RepeatTask {

    ONE_TIME("однократная"), DAILI("ежедневная"), WEEKLY("еженедельная"), MONTHLY("ежемесячная"), ANNUAL("ежегодная");

    String repeatTask;

    RepeatTask(String repeatTask) {
        this.repeatTask = repeatTask;
    }

    public String getRepeatTask() {
        return repeatTask;
    }

}
