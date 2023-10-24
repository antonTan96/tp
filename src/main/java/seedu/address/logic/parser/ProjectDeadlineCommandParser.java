package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.ProjectDeadlineCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.project.Deadline;

/**
 * Parses input arguments and creates a new ProjectDeadlineCommand object
 */
public class ProjectDeadlineCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the ProjectDeadlineCommand
     * and returns an ProjectDeadlineCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ProjectDeadlineCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args,
                PREFIX_DEADLINE);

        if (!arePrefixesPresent(argMultimap, PREFIX_DEADLINE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ProjectDeadlineCommand.MESSAGE_USAGE));
        }

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ProjectDeadlineCommand.MESSAGE_USAGE), ive);
        }
        Deadline deadline = ParserUtil.parseDeadline(argMultimap.getValue(PREFIX_DEADLINE).get());;

        return new ProjectDeadlineCommand(index, deadline);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
