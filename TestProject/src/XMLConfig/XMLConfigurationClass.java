package XMLConfig; // debug 3

import java.io.File;

import javax.lang.model.element.Element;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLConfigurationClass {
    public Boolean EnableSeleniumLog;
    public String TimestampFormat;
    public String LogFilePath;
    public Boolean WriteLineNumbers;
    public Boolean AutoLaunchSeleniumLogDesktop;
    public String SeleniumLogDesktopInstallationFolder;
    public String ScreenshotsFolder;
    public Boolean TakeScreenshotOnEveryWriteline;
    public Boolean TakeScreenshotOnEveryPass;
    public Boolean TakeScreenshotOnEveryFail;
    public Boolean TakeScreenshotOnEveryError;
    public Boolean TakeScreenshotOnEveryWarning;
    public Boolean TakeScreenshotOnEveryException;
    public Boolean ForceThrowExceptionOnAssertFail;
    public Boolean EnableFunctionInterceptor;
    public Boolean FunctionEntry_AutoExploreComplexFunctionInputParams;
    public Boolean FunctionEntry_DisplayNullInputs;
    public Boolean FunctionEntry_TakeScreenshotOnEntry;
    public Boolean FunctionExit_AutoExploreComplexFunctionOutputs;
    public Boolean FunctionExit_DisplayNullOutputs;
    public Boolean FunctionExit_TakeScreenshotOnExit;
    public Boolean FunctionExit_EnablePerformanceMeasurement;
    public String PerformanceMeasurementUnit;
    public Boolean EnableLoggingOfLowLevelSeleniumWebdriverEvents;
    public Boolean OnNavigating_LogBeforeEvent;
    public Boolean OnNavigating_TakeScreenshotBeforeEvent;
    public Boolean OnNavigating_LogAfterEvent;
    public Boolean OnNavigating_TakeScreenshotAfterEvent;
    public Boolean OnNavigatingBack_LogBeforeEvent;
    public Boolean OnNavigatingBack_TakeScreenshotBeforeEvent;
    public Boolean OnNavigatingBack_LogAfterEvent;
    public Boolean OnNavigatingBack_TakeScreenshotAfterEvent;
    public Boolean OnNavigatingForward_LogBeforeEvent;
    public Boolean OnNavigatingForward_TakeScreenshotBeforeEvent;
    public Boolean OnNavigatingForward_LogAfterEvent;
    public Boolean OnNavigatingForward_TakeScreenshotAfterEvent;
    public Boolean OnClick_LogBeforeEvent;
    public Boolean OnClick_TakeScreenshotBeforeEvent;
    public Boolean OnClick_LogAfterEvent;
    public Boolean OnClick_TakeScreenshotAfterEvent;
    public Boolean OnChangeValue_LogBeforeEvent;
    public Boolean OnChangeValue_TakeScreenshotBeforeEvent;
    public Boolean OnChangeValue_LogAfterEvent;
    public Boolean OnChangeValue_TakeScreenshotAfterEvent;
    public Boolean OnFindElement_LogBeforeEvent;
    public Boolean OnFindElement_TakeScreenshotBeforeEvent;
    public Boolean OnFindElement_LogAfterEvent;
    public Boolean OnFindElement_TakeScreenshotAfterEvent;
    public Boolean OnScriptExecute_LogBeforeEvent;
    public Boolean OnScriptExecute_TakeScreenshotBeforeEvent;
    public Boolean OnScriptExecute_LogAfterEvent;
    public Boolean OnScriptExecute_TakeScreenshotAfterEvent;
    public Boolean OnWebdriverExceptionThrown_LogEvent;
    public Boolean Enable_Selenium_Webdriver_Trace;
    public Boolean Enable_Generic_Function_Trace;
    public Boolean AutoStartSeleniumLogApp;
    public String SeleniumLogAppInstallationFolder;
    public String OutputFilePath;
    public Boolean ScreenshotOnEveryMessage;
    public Boolean ScreenshotOnEveryPass;
    public Boolean ScreenshotOnEveryFail;
    public Boolean ScreenshotOnEveryError;
    public Boolean ScreenshotOnEveryWarning;
    public Boolean LogLowLevelSeleniumCommands;
    public Boolean OnClick_LogFunctionStart;
    public Boolean OnClick_LogFunctionEnd;
    public Boolean OnClick_ScreenshotOnStart;
    public Boolean OnClick_ScreenshotOnEnd;
    public Boolean FunctionTrace_DisplayNullInputs;
    public String ExceptionMessageBuffer = "";
        
    public XMLConfigurationClass() {
    	//ParseXML();
    }
    private Boolean TrueOrFalse(String tagname, String val) {
        try {
            if ((val.toLowerCase().equals("true")) || (val.toLowerCase().equals("yes")))
                return true;
            else
                return false;
        } catch (Exception e) {
            System.out.println("Error: <" + tagname + "> value cannot be converted to boolean. Accepted values are Yes/No or True/False.");
            throw e;
        }
    }

    public void ParseXML() {
    	try {
    		//WebDriver driver = new FirefoxDriver();
    		
    		File fXmlFile = new File("C:\\tmp\\SeleniumLog.config");
    		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    		org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);   				
    		//optional, but recommended
    		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    		doc.getDocumentElement().normalize();
    		NodeList nodes = doc.getDocumentElement().getChildNodes();
    		TraverseChildren(nodes);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    public void TraverseChildren(NodeList nodes) {
    	try{
    		for(int i=0; i<nodes.getLength(); i++){
      		  Node node = nodes.item(i);
      		  if(node instanceof org.w3c.dom.Element)
      		  {
      		    org.w3c.dom.Element child = (org.w3c.dom.Element) node;    		    
      		    String option = child.getAttribute("option");
      		    String value = child.getTextContent();
      		    //System.out.println("value = " + value);
      		    switch (option) {

      		    	case "Enable SeleniumLog":
	      		    	EnableSeleniumLog = TrueOrFalse(option,value);
	      		    	break;

                    case "Timestamp format":
                        TimestampFormat = value;
                        break;

                    case "Log file path":
                        LogFilePath = value;
                        break;

                    case "Write line numbers":
                        WriteLineNumbers = TrueOrFalse(option, value);
                        break;

                    case "Auto-launch SeleniumLog Desktop":
                        AutoLaunchSeleniumLogDesktop = TrueOrFalse(option, value);
                        break;

                    case "SeleniumLog Desktop Installation Folder":
                        SeleniumLogAppInstallationFolder = value;
                        break;

                    case "Screenshots folder":
                        ScreenshotsFolder = value;
                        break;

                    case "Take screenshot on every log.WriteLine()":
                        TakeScreenshotOnEveryWriteline = TrueOrFalse(option, value);
                        break;

                    case "Take screenshot on every log.Pass()":
                        TakeScreenshotOnEveryPass = TrueOrFalse(option, value);
                        break;

                    case "Take screenshot on every log.Fail()":
                        TakeScreenshotOnEveryFail = TrueOrFalse(option, value);
                        break;

                    case "Take screenshot on every log.Error()":
                        TakeScreenshotOnEveryError = TrueOrFalse(option, value);
                        break;

                    case "Take screenshot on every log.Warning()":
                        TakeScreenshotOnEveryWarning = TrueOrFalse(option, value);
                        break;

                    case "Take screenshot on every Exception":
                        TakeScreenshotOnEveryException = TrueOrFalse(option, value);
                        break;

                    case "Force throw exception when assert fails":
                        ForceThrowExceptionOnAssertFail = TrueOrFalse(option, value);
                        break;

                    case "Enable Function Interceptor":
                        EnableFunctionInterceptor = TrueOrFalse(option, value);
                        break;

                    case "Function Entry : Auto-explore complex function input params":
                        FunctionEntry_AutoExploreComplexFunctionInputParams = TrueOrFalse(option, value);
                        break;

                    case "Function Entry : Display NULL inputs":
                        FunctionEntry_DisplayNullInputs = TrueOrFalse(option, value);
                        break;

                    case "Function Entry : Take screenshot on entry":
                        FunctionEntry_TakeScreenshotOnEntry = TrueOrFalse(option, value);
                        break;

                    case "Function Exit : Auto-explore complex function outputs":
                        FunctionExit_AutoExploreComplexFunctionOutputs = TrueOrFalse(option, value);
                        break;

                    case "Function Exit : Display NULL outputs":
                        FunctionExit_DisplayNullOutputs = TrueOrFalse(option, value);
                        break;

                    case "Function Exit : Take screenshot on exit":
                        FunctionExit_TakeScreenshotOnExit = TrueOrFalse(option, value);
                        break;

                    case "Function Exit : Enable performance measurement":
                        FunctionExit_EnablePerformanceMeasurement = TrueOrFalse(option, value);
                        break;

                    case "Performance measurement unit":
                        PerformanceMeasurementUnit = value;
                        break;

                    case "Enable Logging of low-level Selenium Webdriver Events":
                        EnableLoggingOfLowLevelSeleniumWebdriverEvents = TrueOrFalse(option, value);
                        break;

                    case "OnNavigating : log before event":
                        OnNavigating_LogBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigating : take screenshot before event":
                        OnNavigating_TakeScreenshotBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigating : log after event":
                        OnNavigating_LogAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigating : take screenshot after event":
                        OnNavigating_TakeScreenshotAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigatingForward : log before event":
                        OnNavigatingForward_LogBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigatingForward : take screenshot before event":
                        OnNavigatingForward_TakeScreenshotBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigatingForward : log after event":
                        OnNavigatingForward_LogAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigatingForward : take screenshot after event":
                        OnNavigatingForward_TakeScreenshotAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigatingBack : log before event":
                        OnNavigatingBack_LogBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigatingBack : take screenshot before event":
                        OnNavigatingBack_TakeScreenshotBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigatingBack : log after event":
                        OnNavigatingBack_LogAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnNavigatingBack : take screenshot after event":
                        OnNavigatingBack_TakeScreenshotAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnClick : log before event":
                        OnClick_LogBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnClick : take screenshot before event":
                        OnClick_TakeScreenshotBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnClick : log after event":
                        OnClick_LogAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnClick : take screenshot after event":
                        OnClick_TakeScreenshotAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnChangeValue : log before event":
                        OnChangeValue_LogBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnChangeValue : take screenshot before event":
                        OnChangeValue_TakeScreenshotBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnChangeValue : log after event":
                        OnChangeValue_LogAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnChangeValue : take screenshot after event":
                        OnChangeValue_TakeScreenshotAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnFindElement : log before event":
                        OnFindElement_LogBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnFindElement : take screenshot before event":
                        OnFindElement_TakeScreenshotBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnFindElement : log after event":
                        OnFindElement_LogAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnFindElement : take screenshot after event":
                        OnFindElement_TakeScreenshotAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnScriptExecute : log before event":
                        OnScriptExecute_LogBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnScriptExecute : take screenshot before event":
                        OnScriptExecute_TakeScreenshotBeforeEvent = TrueOrFalse(option, value);
                        break;

                    case "OnScriptExecute : log after event":
                        OnScriptExecute_LogAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnScriptExecute : take screenshot after event":
                        OnScriptExecute_TakeScreenshotAfterEvent = TrueOrFalse(option, value);
                        break;

                    case "OnWebdriverExceptionThrown : log event":
                        OnWebdriverExceptionThrown_LogEvent = TrueOrFalse(option, value);
                        break;
						
                    case "enable_seleniumlog":
                        ExceptionMessageBuffer = option;
                        EnableSeleniumLog = Boolean.valueOf(value);
                        break;
						
                    case "enable_selenium_webdriver_trace":
                        ExceptionMessageBuffer = option;
                        Enable_Selenium_Webdriver_Trace = Boolean.valueOf(value);
                        break;
						
                    case "enable_general_function_trace":
                        ExceptionMessageBuffer = option;
                        Enable_Generic_Function_Trace = Boolean.valueOf(value);
                        break;
                    
					case "auto_start_seleniumlog_app":
                        ExceptionMessageBuffer = option;
                        AutoStartSeleniumLogApp = Boolean.valueOf(value);
                        break;
                    
					case "seleniumlog_app_installation_folder":
                        ExceptionMessageBuffer = option;
                        SeleniumLogAppInstallationFolder = value;
                        break;
                    
					case "timestamp_format":
                        ExceptionMessageBuffer = option;
                        TimestampFormat = value;
                        break;
                    
					case "output_file_path":
                        ExceptionMessageBuffer = option;
                        OutputFilePath = value;
                        break;
                    
					case "screenshots_folder":
                        ExceptionMessageBuffer = option;
                        ScreenshotsFolder = value;
                        break;
                    
					case "screenshot_on_writeline":
                        ExceptionMessageBuffer = option;
                        ScreenshotOnEveryMessage = Boolean.valueOf(value);
                        break;
                    
					case "screenshot_on_pass":
                        ExceptionMessageBuffer = option;
                        ScreenshotOnEveryPass = Boolean.valueOf(value);
                        break;
                    
					case "screenshot_on_fail":
                        ExceptionMessageBuffer = option;
                        ScreenshotOnEveryFail = Boolean.valueOf(value);
                        break;
                    
					case "screenshot_on_error":
                        ExceptionMessageBuffer = option;
                        ScreenshotOnEveryError = Boolean.valueOf(value);
                        break;
                    
					case "screenshot_on_warning":
                        ExceptionMessageBuffer = option;
                        ScreenshotOnEveryWarning = Boolean.valueOf(value);
                        break;
                    
					case "force_throw_exception_on_assert_fail":
                        ExceptionMessageBuffer = option;
                        ScreenshotOnEveryFail = Boolean.valueOf(value);
                        break;
                    
					case "on_click_event":
                        ExceptionMessageBuffer = option;
                        //_ParentNode = "OnClick";
                        break;
                    
					case "log_function_start":
                        ExceptionMessageBuffer = option;
                        //if (_ParentNode == "OnClick")
                        //    OnClick_LogFunctionStart = Boolean.valueOf(value);
                        break;
                    
					case "log_function_end":
                        ExceptionMessageBuffer = option;
                        //if (_ParentNode == "OnClick")
                        //    OnClick_LogFunctionEnd = Boolean.valueOf(value);
                        break;
                    
					case "screenshot_on_start":
                        ExceptionMessageBuffer = option;
                        //if (_ParentNode == "OnClick")
                        //    OnClick_ScreenshotOnStart = Boolean.valueOf(value);
                        break;
                    
					case "screenshot_on_end":
                        ExceptionMessageBuffer = option;
                        //if (_ParentNode == "OnClick")
                        //    OnClick_ScreenshotOnEnd = Boolean.valueOf(value);
                        break;
                    
					case "general_function_trace_display_null_inputs":
                        ExceptionMessageBuffer = option;
                        FunctionTrace_DisplayNullInputs = Boolean.valueOf(value);
                        break;

      		    	default:
      		    		break;
      		    
      		    }
      		    
      		  }
      		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    public void Print() {
    	System.out.println("EnableSeleniumLog : " + EnableSeleniumLog);
		System.out.println("TimestampFormat : " + TimestampFormat );
		System.out.println("LogFilePath : " + LogFilePath );
	    System.out.println("WriteLineNumbers : " + WriteLineNumbers );
	    System.out.println("AutoLaunchSeleniumLogDesktop : " + AutoLaunchSeleniumLogDesktop );
	    System.out.println("SeleniumLogDesktopInstallationFolder : " + SeleniumLogDesktopInstallationFolder );
	    System.out.println("ScreenshotsFolder : " + ScreenshotsFolder );
	    System.out.println("TakeScreenshotOnEveryWriteline : " + TakeScreenshotOnEveryWriteline );
	    System.out.println("TakeScreenshotOnEveryPass : " + TakeScreenshotOnEveryPass );
	    System.out.println("TakeScreenshotOnEveryFail : " + TakeScreenshotOnEveryFail );
	    System.out.println("TakeScreenshotOnEveryError : " + TakeScreenshotOnEveryError );
	    System.out.println("TakeScreenshotOnEveryWarning : " + TakeScreenshotOnEveryWarning );
	    System.out.println("TakeScreenshotOnEveryException : " + TakeScreenshotOnEveryException );
	    System.out.println("ForceThrowExceptionOnAssertFail : " + ForceThrowExceptionOnAssertFail );
	    System.out.println("EnableFunctionInterceptor : " + EnableFunctionInterceptor );
	    System.out.println("FunctionEntry_AutoExploreComplexFunctionInputParams : " + FunctionEntry_AutoExploreComplexFunctionInputParams );
	    System.out.println("FunctionEntry_DisplayNullInputs : " + FunctionEntry_DisplayNullInputs );
	    System.out.println("FunctionEntry_TakeScreenshotOnEntry : " + FunctionEntry_TakeScreenshotOnEntry );
	    System.out.println("FunctionExit_AutoExploreComplexFunctionOutputs : " + FunctionExit_AutoExploreComplexFunctionOutputs );
	    System.out.println("FunctionExit_DisplayNullOutputs : " + FunctionExit_DisplayNullOutputs );
	    System.out.println("FunctionExit_TakeScreenshotOnExit : " + FunctionExit_TakeScreenshotOnExit );
	    System.out.println("FunctionExit_EnablePerformanceMeasurement : " + FunctionExit_EnablePerformanceMeasurement );
	    System.out.println("PerformanceMeasurementUnit : " + PerformanceMeasurementUnit );
	    System.out.println("EnableLoggingOfLowLevelSeleniumWebdriverEvents : " + EnableLoggingOfLowLevelSeleniumWebdriverEvents );
	    System.out.println("OnNavigating_LogBeforeEvent : " + OnNavigating_LogBeforeEvent );
	    System.out.println("OnNavigating_TakeScreenshotBeforeEvent : " + OnNavigating_TakeScreenshotBeforeEvent );
	    System.out.println("OnNavigating_LogAfterEvent : " + OnNavigating_LogAfterEvent );
	    System.out.println("OnNavigating_TakeScreenshotAfterEvent : " + OnNavigating_TakeScreenshotAfterEvent );
	    System.out.println("OnNavigatingBack_LogBeforeEvent : " + OnNavigatingBack_LogBeforeEvent );
	    System.out.println("OnNavigatingBack_TakeScreenshotBeforeEvent : " + OnNavigatingBack_TakeScreenshotBeforeEvent );
	    System.out.println("OnNavigatingBack_LogAfterEvent : " + OnNavigatingBack_LogAfterEvent );
	    System.out.println("OnNavigatingBack_TakeScreenshotAfterEvent : " + OnNavigatingBack_TakeScreenshotAfterEvent );
	    System.out.println("OnNavigatingForward_LogBeforeEvent : " + OnNavigatingForward_LogBeforeEvent );
	    System.out.println("OnNavigatingForward_TakeScreenshotBeforeEvent : " + OnNavigatingForward_TakeScreenshotBeforeEvent );
	    System.out.println("OnNavigatingForward_LogAfterEvent : " + OnNavigatingForward_LogAfterEvent );
	    System.out.println("OnNavigatingForward_TakeScreenshotAfterEvent : " + OnNavigatingForward_TakeScreenshotAfterEvent );
	    System.out.println("OnClick_LogBeforeEvent : " + OnClick_LogBeforeEvent );
	    System.out.println("OnClick_TakeScreenshotBeforeEvent : " + OnClick_TakeScreenshotBeforeEvent );
	    System.out.println("OnClick_LogAfterEvent : " + OnClick_LogAfterEvent );
	    System.out.println("OnClick_TakeScreenshotAfterEvent : " + OnClick_TakeScreenshotAfterEvent );
	    System.out.println("OnChangeValue_LogBeforeEvent : " + OnChangeValue_LogBeforeEvent );
	    System.out.println("OnChangeValue_TakeScreenshotBeforeEvent : " + OnChangeValue_TakeScreenshotBeforeEvent );
	    System.out.println("OnChangeValue_LogAfterEvent : " + OnChangeValue_LogAfterEvent );
	    System.out.println("OnChangeValue_TakeScreenshotAfterEvent : " + OnChangeValue_TakeScreenshotAfterEvent );
	    System.out.println("OnFindElement_LogBeforeEvent : " + OnFindElement_LogBeforeEvent );
	    System.out.println("OnFindElement_TakeScreenshotBeforeEvent : " + OnFindElement_TakeScreenshotBeforeEvent );
	    System.out.println("OnFindElement_LogAfterEvent : " + OnFindElement_LogAfterEvent );
	    System.out.println("OnFindElement_TakeScreenshotAfterEvent : " + OnFindElement_TakeScreenshotAfterEvent );
	    System.out.println("OnScriptExecute_LogBeforeEvent : " + OnScriptExecute_LogBeforeEvent );
	    System.out.println("OnScriptExecute_TakeScreenshotBeforeEvent : " + OnScriptExecute_TakeScreenshotBeforeEvent );
	    System.out.println("OnScriptExecute_LogAfterEvent : " + OnScriptExecute_LogAfterEvent );
	    System.out.println("OnScriptExecute_TakeScreenshotAfterEvent : " + OnScriptExecute_TakeScreenshotAfterEvent );
	    System.out.println("OnWebdriverExceptionThrown_LogEvent : " + OnWebdriverExceptionThrown_LogEvent );
	    System.out.println("Enable_Selenium_Webdriver_Trace : " + Enable_Selenium_Webdriver_Trace );
	    System.out.println("Enable_Generic_Function_Trace : " + Enable_Generic_Function_Trace );
	    System.out.println("AutoStartSeleniumLogApp : " + AutoStartSeleniumLogApp );
	    System.out.println("SeleniumLogAppInstallationFolder : " + SeleniumLogAppInstallationFolder );
	    System.out.println("OutputFilePath : " + OutputFilePath );
	    System.out.println("ScreenshotOnEveryMessage : " + ScreenshotOnEveryMessage );
	    System.out.println("ScreenshotOnEveryPass : " + ScreenshotOnEveryPass );
	    System.out.println("ScreenshotOnEveryFail : " + ScreenshotOnEveryFail );
	    System.out.println("ScreenshotOnEveryError : " + ScreenshotOnEveryError );
	    System.out.println("ScreenshotOnEveryWarning : " + ScreenshotOnEveryWarning );
	    System.out.println("LogLowLevelSeleniumCommands : " + LogLowLevelSeleniumCommands );
	    System.out.println("OnClick_LogFunctionStart : " + OnClick_LogFunctionStart );
	    System.out.println("OnClick_LogFunctionEnd : " + OnClick_LogFunctionEnd );
	    System.out.println("OnClick_ScreenshotOnStart : " + OnClick_ScreenshotOnStart );
	    System.out.println("OnClick_ScreenshotOnEnd : " + OnClick_ScreenshotOnEnd );
	    System.out.println("FunctionTrace_DisplayNullInputs : " + FunctionTrace_DisplayNullInputs );    	
    }
    
    
}
