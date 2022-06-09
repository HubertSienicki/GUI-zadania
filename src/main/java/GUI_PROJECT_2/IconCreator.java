package GUI_PROJECT_2;

import javax.swing.*;
import java.awt.*;

public class IconCreator implements Icon {
    private final int height = 10;
    private final int width = 10;
    private final Color color;

    public IconCreator(Color color) {
        this.color = color;
    };

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillOval(16,0, width, height);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}