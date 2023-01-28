package duke.task;

public abstract class Task {
    private boolean isCompleted; //by default the task should not be completed
    private String task;

    public Task(String task, boolean isCompleted) {
        this.task = task;
        this.isCompleted = isCompleted;
    }

    /**
     * Get the String representation of the task type
     *
     * @return String representation of the task type
     */
    public abstract String getTaskType();

    /**
     * Get the String representation of the completion status
     *
     * @return String representation of the completion status
     */
    public abstract String getStatus();

    /**
     * Get the String representation of the task description
     *
     * @return String representation of the task description
     */
    public abstract String getDescription();

    /**
     * Get the completion status of task
     *
     * @return completion status of task
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Set isCompleted as false
     */
    public void markUncompleted() {
        isCompleted = false;
    }

    /**
     * Set isCompleted as true
     */
    public void markCompleted() {
        isCompleted = true;
    }

    /**
     * Get the String representation of the task description
     *
     * @return String representation of the task description
     */
    public String getTask() {
        return this.task;
    }

    /**
     * Convert Task Object to String to be saved in data file
     *
     * @return String representation of Task Object
     */
    public String encode() {
        return getTaskType() + " | " + getStatus() + " | " + getDescription();
    }

    /**
     * Override toString method
     *
     * @return String representation of task object including completion status
     */
    @Override
    public String toString() {
        return (isCompleted ? "[X] " + task : "[ ] " + task);
    }

}
