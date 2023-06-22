package clockproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author turanakcnn
 */
public class ClockGUI extends JFrame {

    private Timer timeTime;
    private SimpleDateFormat format;
    private JLabel textTime;

    public ClockGUI() {
        setTitle("Saat");
        Dimension preferredSize = null;
        setPreferredSize(preferredSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tiklaKapat();
        setLayout(null);
        //setUndecorated(true);
        getContentPane().setBackground(Color.black);

        textTime = new JLabel("");
        textTime.setFont(new Font("Times New Roman", Font.BOLD, 200));
        Color custom = new Color(170,180,200);
        textTime.setForeground(custom);
        textTime.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        add(textTime);

        timeTime = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        timeTime.start();

    }

    private void update() {
        format = new SimpleDateFormat("HH:mm:ss");
        textTime.setText(format.format(new Date()));
    }

    private void tiklaKapat() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
    }
}
