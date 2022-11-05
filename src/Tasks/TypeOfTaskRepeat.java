package Tasks;

public enum TypeOfTaskRepeat {

    ONE_TIME("однократная"), DAILY("ежедневная"), WEEKLY("еженедельная"), MONTHLY("ежемесячная"), ANNUAL("ежегодная");

    String repeatTask;

    TypeOfTaskRepeat(String repeatTask) {
        this.repeatTask = repeatTask;
    }

    public String getRepeatTask() {
        return repeatTask;
    }

}
