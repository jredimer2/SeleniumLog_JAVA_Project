package SeleniumLogger;

import java.util.Stack;
import java.util.stream.Collector;

public class _MessageSettings {
    private Boolean ShowLineNumbers;
    private Boolean WatchdogStart;
    private Boolean WatchdogEnd;
    private int PrevLineNum;
    private int LineNum;
    private Boolean Pass;
    private Boolean Fail;
    private Boolean Warning;
    private Boolean Error;
    private int PendingIndent;
    private int PendingUnindent;
    private int RunningIndentLevel;
    private Boolean Root;
    private Collector RGB;
    private Color DefaultRGB;
    private String Image;
    private String File;
    private String Path;
    private String Tab;
    private String TimestampFormat = "HH:mm:ss.fff";
    private String MessageStr;
    private String FormattingStr;
    private Stack BranchStack = new Stack(); // stack of branches which form a path
    private Stack PathsStack = new Stack(); // stack of paths
    public IndentModel indentModel = new IndentModel();
    public Boolean EnableLogging;

    /// <summary>
    /// Constructor
    /// </summary>
    public MessageSettings()
    {
        ShowLineNumbers = false;
        PrevLineNum = 0;
        LineNum = 1;
        RunningIndentLevel = 0;
        //Indent = 0;
        //Unindent = 0;
        ResetDefaultValues();
        EnableLogging = true;
    }

    private void ResetDefaultValues()
    {
        WatchdogStart = false;
        WatchdogEnd = false;
        Pass = false;
        Fail = false;
        Warning = false;
        Error = false;
        PendingIndent = 0;
        PendingUnindent = 0;
        Root = false;
        RGB = null;
        DefaultRGB = null;
        Image = null;
        File = null;
        //_TimestampFormat = "HH:mm:ss.fff";
        Path = null;
        Tab = null;
        MessageStr = null;
    }
}
