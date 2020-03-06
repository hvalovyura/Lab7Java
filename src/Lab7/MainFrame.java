package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private final JTextField textFieldTo;

    private final JTextArea textAreaIncoming;
    private final JTextArea textAreaOutgoing;

    public MainFrame()
    {
        super(FRAME_TITLE);
        setMinimumSize(new Dimension(FRAME_MINIMUM_WIDTH, FRAME_MINIMUM_HEIGHT));
        final Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - getWidth()) / 2, kit.getScreenSize().height - getHeight() - 2);

        textAreaIncoming = new JTextArea(INCOMING_AREA_DEFAULT_ROWS, 0);
        textAreaIncoming.setEditable(false);

        final JScrollPane scrollPanelIncoming = new JScrollPane(textAreaIncoming);

        final JLabel labelFrom = new JLabel("От");
        final JLabel labelTo = new JLabel("Получатель");

        textFieldFrom = new JTextField(FROM_FIELD_DEFAULT_COLUMNS);
        textFieldTo = new JTextField(TO_FIELD_DEFAULT_COLUMNS);

        textAreaOutgoing = new JTextArea(OUTGOING_AREA_DEFAULT_ROWS, 0);

        final JScrollPane scrollPanelOutgoing = new JScrollPane(textAreaOutgoing);

        final JPanel messagePanel = new JPanel();
        messagePanel.setBorder(BorderFactory.createTitledBorder("Сообщение"));

        final JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sendMessage();
            }
        });

        final GroupLayout layout2 = new GroupLayout(messagePanel);
        messagePanel.setLayout(layout2);

        

    }

    public static void main(String[] args)
    {

    }
}
