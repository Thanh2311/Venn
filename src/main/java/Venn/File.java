package Venn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;

public class File {
	
	
	public List<LabelSeri> elementList;
	
	
	public File() {
		elementList = new ArrayList<LabelSeri>();	
	}
	
	
	public List<LabelSeri> getFiles() {
		return elementList;
	}
	public void setFiles(List<LabelSeri> in) {
		elementList = in;
	}
	
	
	public void save(String fileName) throws FileNotFoundException {

		try {
			FileOutputStream fout= new FileOutputStream (fileName);
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(fout);
			oos.writeObject(elementList);
			oos.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void read(String fileName) throws FileNotFoundException {

		try {
			FileInputStream fin= new FileInputStream (fileName);
			ObjectInputStream ois = new ObjectInputStream(fin);
			elementList = (ArrayList)ois.readObject();
			ois.close();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public String toString() {
		String contents = "";
		for (Label i : elementList){
			contents += (i.getText() + ", ");
		}
		return contents;
	}
	
}
