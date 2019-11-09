package ui;

import java.util.function.UnaryOperator;

public class Styles {

    //AnsiEscapeCommands
    private static final String ANSI_NORMAL = "\033[0m";
    private static final String ANSI_COLOR_RED = "\033[38;5;1m";
    private static final String ANSI_UNDERLINE = "\033[4m" ;
    private static final UnaryOperator<String> FIRST_CHAR = s ->
            String.valueOf(s.charAt(0));

    static final String REGEX_ANSI_ESCAPE_CODES = "\\033\\[[0-9;]*m";
    static final UnaryOperator<String> RED = string ->
        ANSI_COLOR_RED.concat(string).concat(ANSI_NORMAL);

    static final UnaryOperator<String> INTERACTIVE = string ->
            string.replaceFirst(FIRST_CHAR.apply(string),
            ANSI_UNDERLINE + ANSI_COLOR_RED + FIRST_CHAR.apply(string) + ANSI_NORMAL + ANSI_COLOR_RED)
            + ANSI_NORMAL;
}
