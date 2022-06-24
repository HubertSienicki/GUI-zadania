package GUI_Cwiczenia.Cwiczenia_14;

import javax.swing.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Model extends AbstractListModel {

    ArrayList capitals = new ArrayList();
    public Model() {
        capitals.add("Berlin");
        capitals.add("London");
    }

    public void addToModel(String capital){
        for (Object s : capitals) {
            if (capital.equals(s)) {
                JOptionPane.showMessageDialog(null, "element sie powtorzyl");
                return;
            }
        }
        capitals.add(capital);
        Collections.sort(capitals);
    }

    @Override
    public int getSize() {
        return capitals.size();
    }

    @Override
    public Object getElementAt(int index) {
        return capitals.get(index);
    }

    public void remove(int index) {
        capitals.remove(index);
    }
}
