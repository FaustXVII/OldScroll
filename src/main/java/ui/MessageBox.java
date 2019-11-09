package ui;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class MessageBox {
    private static final UnaryOperator<String> MESSAGE_BOX = message ->
        AsciiArt.BANNER + AsciiArt.BORDER_TOP + message + AsciiArt.BORDER_BOTTOM;

    private static final Function<List<String>, String> BODY_CUT_TO_FIT =
        strings -> strings.stream()
            .filter(s -> s.length() > 78)
            .map(s -> s.substring(0, 77) + "-\n" + s.substring(78))
            .collect(Collectors.joining("\n"));

    private static final Function<String, Integer> lengthWithoutStyle =
        string -> string.replaceAll(Styles.REGEX_ANSI_ESCAPE_CODES, "").length();

    private static final UnaryOperator<String> ADD_SPACE_TO_FIT =
        subString -> subString + " ".repeat(78 - lengthWithoutStyle.apply(subString));// +2 for the left and right borders.

    private static final UnaryOperator<String> TITLE_CENTERED =
        title -> " ".repeat(40 - (lengthWithoutStyle.apply(title)/2)) + title;

    private static final UnaryOperator<String> BORDER_LEFT_AND_RIGHT =
        string -> Arrays.asList(string.split("\n")).stream()
            .map(subString -> AsciiArt.BORDER_LEFT + ADD_SPACE_TO_FIT.apply(subString) + AsciiArt.BORDER_RIGHT)
            .collect(Collectors.joining(""));

    public static final BiFunction<String, List<String>, String> DISPLAY_MESSAGE =
        (title, body) -> MESSAGE_BOX.apply(
            BORDER_LEFT_AND_RIGHT.apply(TITLE_CENTERED.apply(title)) +
                BORDER_LEFT_AND_RIGHT.apply(BODY_CUT_TO_FIT.apply(body)));
}
