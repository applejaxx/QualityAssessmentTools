import bluej.extensions.*;
import javax.swing.*;


/*
 * This class implements the preference panel behaviour for a BlueJ extension
 */
class Preferences implements PreferenceGenerator {
    private JPanel myPanel;
    private JTextField tool;
    private BlueJ bluej;
    public static final String PROFILE_LABEL="QualityAssessmentTool";

    // Construct the panel, and initialise it from any stored values
    public Preferences(BlueJ bluej) {
        this.bluej = bluej;
        myPanel = new JPanel();
        myPanel.add (new JLabel ("QualityAssessmentTool"));
        tool = new JTextField (40);
        myPanel.add (tool);
        // Load the default value
        loadValues();
    }

    public JPanel getPanel () {
        return myPanel;
    }

    public void saveValues () {
        // Save the preference value in the BlueJ properties file
        bluej.setExtensionPropertyString(PROFILE_LABEL, tool.getText());
    }

    public void loadValues () {
        // Load the property value from the BlueJ properties file, default to an empty string
        tool.setText(bluej.getExtensionPropertyString(PROFILE_LABEL,""));
    }
}