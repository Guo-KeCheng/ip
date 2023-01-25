package command;

import exception.DukeException;
import task.TaskList;
import util.Ui;

public class UnmarkCommand extends Command {
    private String command;
    private TaskList taskList;
    private Ui ui;

    public UnmarkCommand(String command, TaskList taskList, Ui ui) {
        this.command = command;
        this.taskList = taskList;
        this.ui = ui;
    }

    /*
     * Unmark takes in a String comman and handles the command
     * by checking for out of bounds as well as invalid syntaxes 
     * and unmarks the corresponding task as completed
     * @throws DukeException if input is incorrect
     */
    @Override
    public boolean execute() throws DukeException {

        String[] inputs = command.split(" ");
        if (inputs.length == 2) {
            int ind = Integer.parseInt(inputs[1]) - 1;
            if (ind >= taskList.size() || ind < 0) throw new DukeException("☹ OOPS!!! Invalid task number :(");

            taskList.get(ind).markUncompleted();

            ui.printUnmarkedTask(taskList.get(ind));

        } else {
            throw new DukeException("Incorrect command: unmark <valid task index>");
        }

        return false;
    }
}
