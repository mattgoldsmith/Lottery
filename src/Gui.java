import javax.swing.*;
import java.awt.*;

public class Gui {

    boolean debug = false;

    int size;

    JFrame frame;
    JPanel topPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    JLabel title = new JLabel("title");

    JLabel selected = new JLabel("selected");
    JLabel draw = new JLabel("draw");
    JLabel matches = new JLabel("matches");

    JLabel spent = new JLabel("spent");
    JLabel won = new JLabel("won");
    JLabel total = new JLabel("total");

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

        size = (xSize < ySize) ? (int) (Math.round(xSize * 0.80)) : (int) (Math.round(ySize * 0.80));

        Dimension dimension = new Dimension(size, size);
        frame.setPreferredSize(dimension);
    }

    private void addComponents() {

        if(debug) {
            topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));

            topPanel.setBackground(Color.green);
            leftPanel.setBackground(Color.blue);
            rightPanel.setBackground(Color.red);
            bottomPanel.setBackground(Color.yellow);

            selected.setBorder(BorderFactory.createLineBorder(Color.black));
            draw.setBorder(BorderFactory.createLineBorder(Color.black));
            matches.setBorder(BorderFactory.createLineBorder(Color.black));
            spent.setBorder(BorderFactory.createLineBorder(Color.black));
            won.setBorder(BorderFactory.createLineBorder(Color.black));
            total.setBorder(BorderFactory.createLineBorder(Color.black));
        }

        /* Add Panels */
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

        /* Add Labels */
        c = new GridBagConstraints();
        int width = (int) Math.floor((size/2.0) * 0.8);
        Font font = new Font("SansSerif", Font.PLAIN, 16);

        topPanel.setLayout(new GridBagLayout());
        title.setFont(new Font("SansSerif", Font.PLAIN, 32));
        topPanel.add(title, c);

        leftPanel.setLayout(new GridBagLayout());
        c.gridy = 0;
        selected.setPreferredSize(new Dimension(width, 64));

        selected.setFont(font);
        leftPanel.add(selected, c);
        c.gridy = 1;
        draw.setPreferredSize(new Dimension(width, 64));
        draw.setFont(font);
        leftPanel.add(draw, c);
        c.gridy = 2;
        matches.setPreferredSize(new Dimension(width, 64));
        matches.setFont(font);
        leftPanel.add(matches, c);

        rightPanel.setLayout(new GridBagLayout());
        c.gridy = 0;
        spent.setPreferredSize(new Dimension(width, 64));
        spent.setFont(font);
        rightPanel.add(spent, c);
        c.gridy = 1;
        won.setPreferredSize(new Dimension(width, 64));
        won.setFont(font);
        rightPanel.add(won, c);
        c.gridy = 2;
        total.setPreferredSize(new Dimension(width, 64));
        total.setFont(font);
        rightPanel.add(total, c);

        bottomPanel.setLayout(new GridBagLayout());
    }

    private void showFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JLabel getSelected() {
        return selected;
    }

    public JLabel getDraw() {
        return draw;
    }

    public JLabel getMatches() {
        return matches;
    }

    public JLabel getSpent() {
        return spent;
    }

    public JLabel getWon() {
        return won;
    }

    public JLabel getTotal() {
        return total;
    }

    public JLabel getTitle() {
        return title;
    }

    public JFrame getFrame() {
        return frame;
    }

}
