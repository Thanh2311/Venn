package vennData;

public class Component implements Comparable<Component>{
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
	
	public void setAttributes(byte[] attr) {
		this.attributes = attr;
	}
	
	public String toString() {
		String out = this.componentName;
		out += " ";
		for(byte b: attributes) {
			out += (b + ",");
		}
		return out;
	}

	@Override
	public int compareTo(Component o) {
		return this.getName().compareTo(o.getName());
	}
	
}
