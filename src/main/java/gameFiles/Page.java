package gameFiles;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Page {
    @Getter @Setter
    String title;

    @Getter @Setter
    List<String> body;

    @Getter @Setter
    List<Interaction> interactions;
}

