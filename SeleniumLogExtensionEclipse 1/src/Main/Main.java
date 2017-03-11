package Main;
import SeleniumLogger.SeleniumLog;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		SeleniumLog log = SeleniumLog.Instance();
		log.Info("line 1");
		log.Info("line 2");

	}

}
