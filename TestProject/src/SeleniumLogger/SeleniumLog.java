package SeleniumLogger;

import java.util.Stack;

public class SeleniumLog {
    private String _LogFilePath;
    private String _ScreenshotsPath;
    private Stack PathStack = new Stack();
    private Boolean _FileCreated;
    private Stack _CurrentIndentLevelStack = new Stack();
    private SaveIndents _SavedIndents = new SaveIndents();
    //public static _MessageSettings MessageSettings = new _MessageSettings();
    private _MessageSettings MessageSettings = new _MessageSettings();

    private bool Result = true;

    public string OutputFilePath { get { return _LogFilePath; } }
    public string ScreenshotsPath { get { return _ScreenshotsPath; } }
    private int ActualIndentLevel { get { return MessageSettings.indentModel.CurrentLevel; } }
    private int PendingIndentLevel { get { return MessageSettings.GetPendingLevel(); } }
    
    private List<int> wdlist = new List<int>();
    private IWebDriver driver;
    //public _Config Config = new _Config();
    public XmlConfigurationClass Config = XmlConfigurationClass.Instance();
}
