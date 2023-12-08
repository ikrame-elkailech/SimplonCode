package note;

import java.util.ArrayList;

public class Etudiant {

	private String code;
	 private String firstName;
	 private String lastName;
	 private String email;
	 private ArrayList<Matiere> matieres  ;
	 

	 
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public void addMatieres(Matiere matiere) {
		
        matieres.add(matiere);
        return ;
    }
	public Etudiant(String code, String firstName, String lastName, String email) {
		super();
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.matieres= new ArrayList<Matiere>();
		Matiere m1 = new Matiere("java", new ArrayList<Float>());
		Matiere m2 = new Matiere("react", new ArrayList<Float>());
		Matiere m3 = new Matiere("reseau", new ArrayList<Float>());
		
		this.matieres.add(m1);
		this.matieres.add(m2);
		this.matieres.add(m3);
	}
	public ArrayList<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(ArrayList<Matiere> matieres) {
		this.matieres = matieres;
	}
	
	
	
	
	
	 

}
