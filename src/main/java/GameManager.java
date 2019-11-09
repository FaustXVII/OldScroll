import gameFiles.GameBook;
import gameFiles.Page;
import lombok.val;
import ui.CommandlineHUD;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

class GameManager {
    private final Function<Page, Map<String, Integer>> getInteractionOptionsFromPage =
        page -> page
            .getInteractions()
            .stream()
            .collect(
                Collectors.toMap(
                interaction -> interaction.getFindWord().substring(0,1),
                interaction -> interaction.getGoto_pageId()));

    private final Consumer<Integer> openPageByIndex = pageNumber -> {
        val page = GameBook.get_PAGES_IN_MEMORY().get(pageNumber);
        System.out.println(CommandlineHUD.convertPageTo_outputMessage(page));
        this.openPageByIndex.accept(selectNextPageBy_Interaction(getInteractionOptionsFromPage.apply(page)));
    };

    final Runnable newGame = () ->
        openPageByIndex.accept(1);

    private int selectNextPageBy_Interaction(final Map<String, Integer> interactionOptions){
        System.out.print(">");
        val userInput = new Scanner(System.in).next();

        return interactionOptions.containsKey(userInput) ?
            interactionOptions.get(userInput)
            : selectNextPageBy_Interaction(interactionOptions);
    }
}
