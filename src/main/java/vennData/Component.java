package vennData;

public class Component {
	private String componentName;
	private byte[] attributes;
	
	public Component(String name, byte[] attributes) {
		componentName = name;
		this.attributes = attributes;
	}
	
	public String getName(){
		return componentName;
	}
	
	public byte[] getAttributes() {
		return attributes;
	}
	
	public String toString() {
		String out = this.componentName;
		out += " ";
		for(byte b: attributes) {
			out += (b + ",");
		}
		return out;
	}
	
}
