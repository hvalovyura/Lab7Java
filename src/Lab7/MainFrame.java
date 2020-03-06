package Lab7;

import javax.swing.*;

public class MainFrame extends JFrame
{
    private static final String FRAME_TITLE = "Клиент мгновенных сообщений";

    private static final int FRAME_MINIMUM_WIDTH = 500;
    private static final int FRAME_MINIMUM_HEIGHT = 500;

    private static final int FROM_FIELD_DEFAULT_COLUMNS = 10;
    private static final int TO_FIELD_DEFAULT_COLUMNS = 20;

    private static final int INCOMING_AREA_DEFAULT_ROWS = 10;
    private static final int OUTGOING_AREA_DEFAULT_ROWS = 5;

    private static final int SMALL_GAP = 5;
    private static final int MEDIUM_GAP = 10;
    private static final int LARGE_GAP = 15;

    private static final int SERVER_PORT = 4567;

    private final JTextField textFieldFrom;
    private final JTextField textFiedTo;

    private final JTextArea textAreaIncoming;
    private final JTextArea textAreaOutgoing;

    public static void main(String[] args)
    {

    }
}
