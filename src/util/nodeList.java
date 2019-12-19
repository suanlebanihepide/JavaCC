package util;

import java.util.ArrayList;
import java.util.Iterator;

public class nodeList {
	public ArrayList<node> Nodelist = new ArrayList<node>();
	
	public void addnode( String Type, String name,int row,int column) {
		Nodelist.add(new node(Type,name,row,column));
	}
	
	public boolean isEmpty(){
		
		return Nodelist.isEmpty();
	}
	public  boolean isExist(String name){
		Iterator<node> itr = Nodelist.iterator();
			while (itr.hasNext()) {
				node tmp = (node) itr.next();
				if(tmp.getName().equals(name))
				{
					return true;
				}
			}
		
		return false;
	}
}
