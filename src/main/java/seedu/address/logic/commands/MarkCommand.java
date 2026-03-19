package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_WEEK;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.logic.Messages;

/**
 * Marks the attendance of an existing person in the address book.
 */
public class MarkCommand extends Command {

    public static final String COMMAND_WORD = "mark";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks the person identified by the index number used in the displayed person list as attended.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_WEEK + "WEEK (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_WEEK + "2";

    public static final String MESSAGE_MARK_PERSON_SUCCESS = "Marked Person: %1$s";
    public static final String MESSAGE_ALREADY_MARKED = "This person has already been marked as attended for this week.";

    private final Index index;
    private final int week;

    /**
     * @param index of the person in the filtered person list to mark
     * @param week of the attendance to mark
     */
    public MarkCommand(Index index, int week) {
        requireNonNull(index);
        requireNonNull(week);
        this.index = index;
        this.week = week;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model); 
        List<Person> lastShownList = model.getFilteredPersonList();
        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
        Person personToEdit = lastShownList.get(index.getZeroBased());
        if (personToEdit.getAttendance().isMarked(week)) {
            throw new CommandException(MESSAGE_ALREADY_MARKED);
        }
        personToEdit.getAttendance().markWeek(week);
        model.updatePerson(personToEdit);
        return new CommandResult(String.format(MESSAGE_MARK_PERSON_SUCCESS, personToEdit));

    }
    
}
