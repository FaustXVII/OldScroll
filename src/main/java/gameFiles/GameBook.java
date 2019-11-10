package gameFiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.val;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class GameBook {
    @Getter
    private static final HashMap<Integer, Page> _PAGES_IN_MEMORY = getPagesFromJSON();

    private static HashMap<Integer, Page> getPagesFromJSON(){
         try{
             val objectMapper = new ObjectMapper();
             return objectMapper
                 .readValue(
                    new File("src/main/resources/gameFile.json"),
                    objectMapper
                        .getTypeFactory()
                        .constructMapType(HashMap.class, Integer.class, Page.class));
         }catch (IOException io){
             throw new RuntimeException("Data seems corrupted, we can't continue: " + io);
         }
    }
}
