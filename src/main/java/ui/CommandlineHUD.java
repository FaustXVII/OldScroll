package ui;

import gameFiles.GameObject;
import gameFiles.Interaction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandlineHUD {
    public static String convertGameObjectTo_outputMessage(final GameObject gameObject){
        var outputMessage = MessageBox.DISPLAY_MESSAGE.apply(gameObject.getTitle(), gameObject.getBody());

        for(Interaction interaction : gameObject.getInteractions()){
            outputMessage = markInteractiveWords(interaction, outputMessage);
        }

        return outputMessage;
    }

    //ToDo Find a more elegant way to do this.
    private static String markInteractiveWords(Interaction interaction, String message){
        Pattern pattern = Pattern.compile(interaction.getFindWord());
        Matcher matcher = pattern.matcher(message);

        StringBuffer stringBuffer = new StringBuffer(message.length());
        for (int i= 0; matcher.find(); i++){
            String text = matcher.group(0);
            if(i == interaction.getAppearance())
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(Styles.INTERACTIVE.apply(text)));
        }

        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
