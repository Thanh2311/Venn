package vennData;

import java.io.File;

public class FileManager { //maybe use an xml, or json format, need to figure out what is necessary for header information
	
	private String filePath;
	private File f;
	
	public FileManager(String filePath) {
		this.filePath = filePath;
		f = new File(filePath);
	}
	
	
}
