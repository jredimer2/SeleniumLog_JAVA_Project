package TestHarness;

import java.io.PrintWriter;
import java.io.IOException;

import TestPackage.TestClass1;
import TestPackage.WriteFile;
import XMLConfig.XMLConfigurationClass;

public class Main {

	public static void main(String[] args) throws IOException {
		TestClass1 cl = new TestClass1();
		System.out.println("Hello World " + cl.a);

		XMLConfigurationClass xml = new XMLConfigurationClass();
		xml.ParseXML();
		xml.Print();
		WriteFile file = new WriteFile("C:\\tmp\\javaout2.txt",true);
		file.writeToFile("line 1");
		file.writeToFile("line 2");
		

	}

}
