import command.AbstractCommand;
import command.Add;
import command.Commands;
import command.Replace;
import core.CommandController;
import models.Text;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * This class contains JUnit tests to test the behaviour of the CommandController Class.
 *
 * @since 1.0.0
 */
public class CommandControllerTest {
    private CommandController commandController;
    private Commands commands;
    private AbstractCommand add;
    private AbstractCommand replace;

    /**
     * This methode initialise the commandcontroller, text, add, commands and actiontupel class for all tests
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Text text = new Text();
        commandController = new CommandController(text);
        add = new Add();
        replace = new Replace();
        commands = Commands.ADD;

    }

    /**
     * This methode tests the SelectCommand methode with the add command.
     */
    @Test
    public void testSelectCommandAdd() {
        assertEquals(add.getClass().getName(), commandController.selectCommand(commands).getClass().getName());
    }

    /**
     * This methode tests the SelectCommand methode with the replace command.
     */
    @Test
    public void testSelectCommandReplace() {
        commands = Commands.REPLACE;
        assertEquals(replace.getClass().getName(), commandController.selectCommand(commands).getClass().getName());
    }
}
