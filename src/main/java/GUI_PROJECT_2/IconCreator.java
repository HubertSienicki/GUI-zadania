package GUI_PROJECT_2;

import javax.swing.*;
import java.awt.*;

public class IconCreator implements Icon {
    private final int height = 10;
    private final int width = 10;
    private final int x;
    private final int y;
    private final Color color;

    public IconCreator(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillOval(this.x,this.y, width, height);
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