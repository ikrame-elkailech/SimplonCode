package note;

import java.util.ArrayList;
import java.util.HashMap;

public class Matiere {

	
	private String NomMatiere;
	private ArrayList<Float> notes;
	//private int codeEtudiant;
	
	public String getNomMatiere() {
		return NomMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		NomMatiere = nomMatiere;
	}
	
	 
	public void addNote(float note) {
        notes.add(note);
        return ;
    }
	public Matiere(String nomMatiere, ArrayList<Float> notes) {
		super();
		NomMatiere = nomMatiere;
		this.notes = notes;
	}
	
	
	
	
	
	
	 

}
