package ui;

public class AsciiArt {
        private static String banner =
                " ▒█████   ██▓    ▓█████▄      ██████  ▄████▄   ██▀███   ▒█████   ██▓     ██▓    \n" +
                "▒██▒  ██▒▓██▒    ▒██▀ ██▌   ▒██    ▒ ▒██▀ ▀█  ▓██ ▒ ██▒▒██▒  ██▒▓██▒    ▓██▒    \n" +
                "▒██░  ██▒▒██░    ░██   █▌   ░ ▓██▄   ▒▓█    ▄ ▓██ ░▄█ ▒▒██░  ██▒▒██░    ▒██░    \n" +
                "▒██   ██░▒██░    ░▓█▄   ▌     ▒   ██▒▒▓▓▄ ▄██▒▒██▀▀█▄  ▒██   ██░▒██░    ▒██░    \n" +
                "░ ████▓▒░░██████▒░▒████▓    ▒██████▒▒▒ ▓███▀ ░░██▓ ▒██▒░ ████▓▒░░██████▒░██████▒\n" +
                "░ ▒░▒░▒░ ░ ▒░▓  ░ ▒▒▓  ▒    ▒ ▒▓▒ ▒ ░░ ░▒ ▒  ░░ ▒▓ ░▒▓░░ ▒░▒░▒░ ░ ▒░▓  ░░ ▒░▓  ░\n" +
                "  ░ ▒ ▒░ ░ ░ ▒  ░ ░ ▒  ▒    ░ ░▒  ░ ░  ░  ▒     ░▒ ░ ▒░  ░ ▒ ▒░ ░ ░ ▒  ░░ ░ ▒  ░\n" +
                "░ ░ ░ ▒    ░ ░    ░ ░  ░    ░  ░  ░  ░          ░░   ░ ░ ░ ░ ▒    ░ ░     ░ ░   \n" +
                "    ░ ░      ░  ░   ░             ░  ░ ░         ░         ░ ░      ░  ░    ░  ░\n" +
                "                  ░                  ░                                          \n";

        private static String border_top = "╔══════════════════════════════════════════════════════════════════════════════╗\n";
        private static String border_left = "║";
        private static String border_right = "║\n";
        private static String border_bottom = "╚══════════════════════════════════════════════════════════════════════════════╝\n";

        static final String BANNER = Styles.RED.apply(banner);
        static final String BORDER_TOP = Styles.RED.apply(border_top);
        static final String BORDER_LEFT = Styles.RED.apply(border_left);
        static final String BORDER_RIGHT = Styles.RED.apply(border_right);
        static final String BORDER_BOTTOM = Styles.RED.apply(border_bottom);
}
