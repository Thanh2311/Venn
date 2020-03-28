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

public class LabelData implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<LabelSerializable> elementList;
	
	
	public LabelData() {
		elementList = new ArrayList<LabelSerializable>();	
	}
	
	
	public List<LabelSerializable> getList() {
		return elementList;
	}
	public void setFiles(List<LabelSerializable> in) {
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
	
	
	public void read(File fileName) throws FileNotFoundException {

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
		for (LabelSerializable i : elementList){
			contents += (i.getText() + ", ");
		}
		return contents;
	}
	
}
