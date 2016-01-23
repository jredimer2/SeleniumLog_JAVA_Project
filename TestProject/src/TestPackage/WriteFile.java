package TestPackage;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile {
	private String path;
	private Boolean append_to_file = false;
	
	public WriteFile(String file_path){
		path = file_path;
	}
	public WriteFile(String file_path, Boolean append_value) {
		path = file_path;
		append_to_file = append_value;
	}
	public void writeToFile(String textLine) throws IOException {
		FileWriter write = new FileWriter(path,append_to_file);
		PrintWriter print_line = new PrintWriter(write);
		print_line.printf(textLine + "\n");
		print_line.close();
	}
}
