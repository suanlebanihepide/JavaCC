package util;

public class node {
	private String Type;
	private String name;
	private int row;
	private int column;
	
	node(String Type, String name,int row,int column){
		this.Type=Type;
		this.name = name;
		this.row=row;
		this.column=column;
	}
	
	@Override
	public String toString() {
		return "Variable [ Type=" + Type + ", name=" + name + ", row=" + row + ", column=" + column + "]";
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	
		
}
