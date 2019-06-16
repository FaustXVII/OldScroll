import gameFiles.GameObject;
import gameFiles.gameFile;
import lombok.val;
import ui.CommandlineHUD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GameFlow {
    HashMap<Integer, GameObject> gameObjects = new gameFile().getGameObjects();

    public void newGame(){
        getLevel(1);
    }

    public void getLevel(int level_ID){
        val gameObject = gameObjects.get(level_ID);
        System.out.println(CommandlineHUD.convertGameObjectTo_outputMessage(gameObject));
        getLevel(selectNextPageBy_Interaction(getInteractionOptionsFrom_GameObject.apply(gameObject)));

    }

    public int selectNextPageBy_Interaction(final Map<String, Integer> interactionOptions){
        System.out.print(">");
        val scanner = new Scanner(System.in);
        val userInput = scanner.next();

        return interactionOptions.containsKey(userInput) ?
            interactionOptions.get(userInput)
            : selectNextPageBy_Interaction(interactionOptions);
    }


    final Function<GameObject, Map<String, Integer>> getInteractionOptionsFrom_GameObject =
        gameObject -> gameObject.getInteractions().stream()
            .collect(Collectors.toMap(i -> i.getFindWord().substring(0,1), i -> i.getGoto_pageId()));
}
