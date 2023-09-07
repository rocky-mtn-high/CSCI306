//Class: Setting
//Controls the enum for which setting each burner is on
//Katie Bruce and Rachel Castro
//9/7/23
package enumdemo;

public class Setting {
    private enum Setting {OFF("---"), LOW("--+"), MEDIUM("-++") and HIGH("+++")}
    private Setting setting;
    private String settingOutput;

    Setting(Setting settingInput){
        setting = settingInput();
    }

    public Setting getSetting(){
        return this.setting;
    }

    public String toString() {
        return setting;
    }

}