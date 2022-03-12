import javax.swing.*;
import java.awt.*;

public class Gui {

    JFrame frame;
    JPanel topPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    public Gui() {
        setFrame();
        addComponents();
        showFrame();
    }

    private void setFrame() {
        frame = new JFrame("Lottery Simulator");
        frame.setLayout(new GridBagLayout());

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());

        int size = (xSize < ySize) ? (int) (Math.round(xSize * 0.80)) : (int) (Math.round(ySize * 0.80));

        Dimension dimension = new Dimension(size, size);
        frame.setPreferredSize(dimension);
    }
    public JFrame getFrame() {
        return frame;
    }

    private void addComponents() {

        topPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        topPanel.setBackground(Color.green);
        leftPanel.setBackground(Color.blue);
        rightPanel.setBackground(Color.red);
        bottomPanel.setBackground(Color.yellow);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 2;
        c.weighty = 1;
        frame.add(topPanel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 3;
        frame.add(leftPanel, c);

        c.gridx = 1;
        c.gridy = 1;
        frame.add(rightPanel, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.weightx = 2;
        c.weighty = 1;
        frame.add(bottomPanel, c);
    }

    private void showFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
