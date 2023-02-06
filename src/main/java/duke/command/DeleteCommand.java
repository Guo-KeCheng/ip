package duke.command;

import duke.exception.DukeException;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.util.Storage;

import java.io.IOException;

/**
 * Executable command to delete specific task.
 *
 * @author Guo-KeCheng
 */
public class DeleteCommand extends Command {
    private final String input;
    private final TaskList taskList;
    private final Ui ui;

    private final Storage storage;

    /**
     * DeleteCommand constructor
     *
     * @param input    Entire line of user input
     * @param taskList Existing taskList
     * @param ui       Shared Ui object
     * @param storage  Shared storage object
     */
    public DeleteCommand(String input, TaskList taskList, Ui ui, Storage storage) {
        this.input = input;
        this.taskList = taskList;
        this.ui = ui;
        this.storage = storage;
    }

    /*
     * delete task by removing the Task at the corresponding index
     * throws exception for wrong syntax and invalid task number
     */
    @Override
    public String execute() throws DukeException {
        String[] inputs = input.split(" ");
        if (inputs.length == 1) {

            int ind = Integer.parseInt(inputs[0]) - 1;
            if (ind >= taskList.size() || ind < 0) {
                throw new DukeException("OOPS!!! Invalid task number");
            }

            String result = ui.printDeletedTask(taskList.get(ind));
            taskList.remove(ind);

            try {
                storage.save(taskList);
            } catch (IOException e) {
                return ui.showError(e.getMessage());
            }

            return result;

        } else {
            throw new DukeException("Incorrect command: delete <valid task index>");
        }

    }
}
