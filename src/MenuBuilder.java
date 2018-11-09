import bluej.extensions.*;
import javax.swing.*;

class MenuBuilder extends MenuGenerator {

    public JMenu getToolsMenuItem(BPackage aPackage) {
        JMenu menu = new JMenu("Quality tools");
        JMenuItem mi = new JMenuItem("Checkstyle");
        menu.add(mi);
        mi = new JMenuItem("PMD(not implemented yet)");
        menu.add(mi);
        return menu;
    }
}
