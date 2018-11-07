import bluej.extensions.*;
import javax.swing.*;
import java.awt.event.*;

/* This class shows how you can bind different menus to different parts of BlueJ
 * Remember:
 * - getToolsMenuItem, getClassMenuItem and getObjectMenuItem may be called by BlueJ at any time.
 * - They must generate a new JMenuItem each time they are called.
 * - No reference to the JMenuItem should be stored in the extension.
 * - You must be quick in generating your menu.
 */
class MenuBuilder extends MenuGenerator {

    private BPackage curPackage;
    private BClass curClass;
    private BObject curObject;

    public JMenuItem getToolsMenuItem(BPackage aPackage) {

        return new JMenuItem(new SimpleAction("Quality Assessment Tools", "Tools menu: \n Checkstyle \n JaCoCo \n PMD/CPD \n SpotBugs"));
    }

    public JMenuItem getClassMenuItem(BClass aClass) {

        return new JMenuItem(new SimpleAction("Click Class", "Object menu"));

    }

    public JMenuItem getObjectMenuItem(BObject anObject) {

        return new JMenuItem(new SimpleAction("Click Object", "Object menu:"));
    }

    // These methods will be called when
    // each of the different menus are about to be invoked.

    public void notifyPostToolsMenu(BPackage bp, JMenuItem jmi) {
        System.out.println("Post on Tools menu");
        curPackage = bp;
        curClass = null;
        curObject = null;
    }

    public void notifyPostClassMenu(BClass bc, JMenuItem jmi) {
        System.out.println("Post on Class menu");
        curPackage = null;
        curClass = bc;
        curObject = null;
    }

    public void notifyPostObjectMenu(BObject bo, JMenuItem jmi) {
        System.out.println("Post on Object menu");
        curPackage = null;
        curClass = null;
        curObject = bo;
    }

    // A utility method which pops up a dialog detailing the objects 
    // involved in the current (SimpleAction) menu invocation.
    private void showCurrentStatus(String header) {
        try {
            if (curObject != null)
                curClass = curObject.getBClass();
            if (curClass != null)
                curPackage = curClass.getPackage();

            String msg = header;
            if (curPackage != null)
                msg += "\nCurrent Package = " + curPackage;
            if (curClass != null)
                msg += "\nCurrent Class = " + curClass;
            if (curObject != null)
                msg += "\nCurrent Object = " + curObject;
            JOptionPane.showMessageDialog(null, msg);
        } catch (Exception exc) {
        }
    }


    // The nested class that instantiates the different (simple) menus.
    class SimpleAction extends AbstractAction {
        private String msgHeader;

        public SimpleAction(String menuName, String msg) {
            putValue(AbstractAction.NAME, menuName);
            msgHeader = msg;
        }

        public void actionPerformed(ActionEvent anEvent) {
            showCurrentStatus(msgHeader);
        }
    }
}