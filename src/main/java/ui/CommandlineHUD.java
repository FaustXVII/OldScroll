package ui;

import gameFiles.Page;
import gameFiles.Interaction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandlineHUD {
    public static String convertPageTo_outputMessage(final Page page){
        var outputMessage = MessageBox.DISPLAY_MESSAGE.apply(page.getTitle(), page.getBody());

        for(Interaction interaction : page.getInteractions()){
            outputMessage = markInteractiveWords(interaction, outputMessage);
        }

        return outputMessage;
    }

    public static final Runnable CLEAR_CONSOLE = ()->{
        System.out.print("\033[H\033[2J");
        System.out.flush();
    };

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
