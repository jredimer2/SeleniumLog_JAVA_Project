package SeleniumLogger;

import java.util.Stack;

import XMLConfig.XMLConfigurationClass;

public class SeleniumLog {
    private String _LogFilePath;
    private String _ScreenshotsPath;
    private Stack PathStack = new Stack();
    private Boolean _FileCreated;
    private Stack _CurrentIndentLevelStack = new Stack();
    //////private SaveIndents _SavedIndents = new SaveIndents();
    //public static _MessageSettings MessageSettings = new _MessageSettings();
    private _MessageSettings MessageSettings = new _MessageSettings();

    private Boolean Result = true;

    public String OutputFilePath() { return _LogFilePath; }
    public String ScreenshotsPath() { return _ScreenshotsPath;}
    private Integer ActualIndentLevel() { return MessageSettings.indentModel.CurrentLevel;  }
    private Integer PendingIndentLevel() { return MessageSettings.GetPendingLevel(); }
    
    private List<int> wdlist = new List<int>();
    private IWebDriver driver;
    //public _Config Config = new _Config();
    public XMLConfigurationClass Config = XMLConfigurationClass.Instance();
    
    public class Color
    {
        public int red;
        public int green;
        public int blue;
        public Color()
        {
        }
    }
}
