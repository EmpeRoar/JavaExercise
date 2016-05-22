package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;

public class PersonTableModel extends AbstractTableModel {

	private List<Person> db;
	
	private String[] colNames = {"ID","Name","Occupation","Age","Category","Employment Category","US Citizen","Tax ID"};
	
	public PersonTableModel(){
	
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}
	
	
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		if(db == null) return;
		
		Person person = db.get(row);
		
		switch(col){
		case 1:
			person.setName((String)value);
		    break;
		default:
			return;
		}
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		
		
		switch(col){
			case 1:
				return true; 
			default:
				return false;
		}
	}

	public void setData(List<Person> db){
		this.db = db;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	

	@Override
	public Object getValueAt(int row, int col) {
		Person person = db.get(row);
		switch(col){
			case 0: return person.getId();
			case 1: return person.getName();
			case 2: return person.getOccupation();
			case 3: return person.getAgeCategory();
			case 4: return person.getEmpCat();
			case 5: return person.isUsCitizen();
			case 6: return person.getTaxId();		
		}
		return null;
	}

}
