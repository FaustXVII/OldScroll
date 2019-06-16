package gameFiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.val;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class gameFile {
    @Getter
    HashMap<Integer, GameObject> gameObjects = initGameObject();

    private HashMap<Integer, GameObject> initGameObject(){
         try{
             val objectMapper = new ObjectMapper();
             return objectMapper.readValue(
                 new File("src/main/resources/gameFile.json"),
                 objectMapper.getTypeFactory()
                     .constructMapType(HashMap.class, Integer.class, GameObject.class));
         }catch (IOException io){
             throw new RuntimeException("Data seems corrupted, we can't continue: " + io);
         }
    }
}
