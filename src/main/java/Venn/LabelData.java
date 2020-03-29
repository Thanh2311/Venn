package Venn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.scene.control.Label;

public class LabelData implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<LabelSerializable> elementList;
	
	
	public LabelData() {
		elementList = new ArrayList<LabelSerializable>();	
	}
	
	
	public ArrayList<LabelSerializable> getList() {
		return elementList;
	}
	public void setFiles(ArrayList<LabelSerializable> in) {
		elementList = in;
	}
	
	
	public void save(File fileName) throws FileNotFoundException {

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
			elementList.clear();
			elementList.addAll((ArrayList)ois.readObject());
			ois.close();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (StreamCorruptedException e) {
			System.out.println("Not a real .venn file.");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void update(String oldText) {
		Iterator<LabelSerializable> itr = elementList.iterator();
		while (itr.hasNext()) {
			LabelSerializable label = itr.next();
			if (label.getText().equals(oldText))
				itr.remove();
		}
	}
	
	public void update(Label oldLabel) {
		update(oldLabel.getText());
	}
	
	public void update(Label oldLabel, Label newLabel) {
		update(oldLabel);
		elementList.add(new LabelSerializable(newLabel));		
	}
	
	public void update(String oldText, Label newLabel) {
		update(oldText);
		elementList.add(new LabelSerializable(newLabel));		
	}
	
	public void clearData() {
		elementList.clear();
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
