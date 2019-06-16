package gameFiles;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GameObject {
    @Getter @Setter
    String Title;

    @Getter @Setter
    List<String> body;

    @Getter @Setter
    List<Interaction> interactions;
}

