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
	private ArrayList<LabelSerializable> elementList;
	private CommandManager undoManager;
	
	
	public LabelData() {
		elementList = new ArrayList<LabelSerializable>();	
		undoManager = new CommandManager(this);
	}
	
	
	public ArrayList<LabelSerializable> getList() {
		return elementList;
	}
	
	
	public void setList(ArrayList<LabelSerializable> in) {
		elementList = in;
	}
	
	
	public CommandManager getUndoManager() {
		return undoManager;
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
	
	
	public LabelSerializable remove(String oldText) {
		undoManager.execute();

		Iterator<LabelSerializable> itr = elementList.iterator();
		LabelSerializable label = null;
		while (itr.hasNext()) {
			label = itr.next();
			if (label.getText().equals(oldText)) {
				itr.remove();
				break;
			}
		}
		return label;
	}
	
	public void remove(Label oldLabel) {
		 remove(oldLabel.getText());
	}
	
	public void update(Label oldLabel, Label newLabel) {
		remove(oldLabel);	
		elementList.add(new LabelSerializable(newLabel));
		 
	}
	
	public void update(String oldText, Label newLabel) {
		remove(oldText);
		elementList.add(new LabelSerializable(newLabel));	
		
	}
	
	public void add(Label label) {
		undoManager.execute();
		elementList.add(new LabelSerializable(label));
		
	}
	
	public void clearData() {
		elementList.clear();
	}
	
	
	
	@Override
	public String toString() {
		String contents = "";
		if (elementList.isEmpty()) {
			contents += "Empty data";
		}
		else {
			for (LabelSerializable i : elementList){
				contents += (i.getText() + ", ");
			}
		}
		return contents;
	}
	
}
