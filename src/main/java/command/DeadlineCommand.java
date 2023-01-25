package command;

import exception.DukeException;
import task.Deadline;
import task.TaskList;

public class DeadlineCommand extends Command {
    
    private TaskList taskList;
    private String command;

    public DeadlineCommand(String command, TaskList taskList) {
        this.command = command;
        this.taskList = taskList;
        
    }
    
    /*
     * adds deadline base on the string command
     * deadline requires taskName and EndDate
     */
    @Override
    public void execute() throws DukeException {
        String taskName = getTaskName("deadline", command);
        String endDate = getEndDate("deadline", command);

        Deadline deadline = new Deadline(taskName, endDate);
        taskList.add(deadline);

        System.out.println("    Got it. I've added this task:");
        System.out.println("      " + deadline);
        System.out.println("    Now you have " + taskList.size() + " tasks in the list.");
    }
}
