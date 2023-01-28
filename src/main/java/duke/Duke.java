package duke;

import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

import duke.command.*;
import duke.exception.*;
import duke.task.*;
import duke.util.*;

/**
 * Duke class: serves as the entry class to the application
 */
public class Duke {
    private TaskList taskList;
    private final Storage storage;
    private final Ui ui;

    /**
     * Duke class constructor
     *
     * @param filePath
     */
    public Duke(String filePath) {
        ui = new Ui();
        ui.printWelcome();
        storage = new Storage(filePath, ui);
        try {
            taskList = storage.load(filePath);
        } catch (FileNotFoundException e) {
            taskList = new TaskList();
        }
    }

    /**
     * Read and process user commands
     */
    public void run() {
        boolean isTerminate = false;

        while (!isTerminate) {
            try {
                ui.printLine();

                String input = ui.readCommand();
                Command cmd = Parser.parse(input, taskList, ui, storage);
                isTerminate = cmd.execute();

            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Duke("./data/duke.txt").run();
    }
}
