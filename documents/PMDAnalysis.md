
### PMD Extension Analysis:

* Preference menu is using a hard coded string that is run through the command line.  
* Rulesets are considered deprecated and are no longer working in the compressed JAR file path.  
* Starting with PMD 5.0 and Maven PMD Plugin 3.0 the paths to the bundled rulesets for the java language were changed from /rulesets/xyz.xml to /rulesets/java/xyz.xml.  
* Also the rulesets that were previously used in the extension are now deprecated (design.xml and basic.xml).
* Improved ruleset added with current PMD: quickstart.
