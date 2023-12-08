package note;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EtudiantManager implements Services {
	ArrayList<Etudiant> etudiantList = new ArrayList<>();
	//ArrayList<Matiere> matiereList = new ArrayList<>();
	//Matiere m1 = new Matiere("Physique", new ArrayList<Float>());
	//Matiere m2 = new Matiere("Anglais", new ArrayList<Float>());
	//Matiere m3 = new Matiere("Math", new ArrayList<Float>());
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
        

        while (true) {
        	System.out.println("1. Saisie etudiant : ");
            System.out.println("2. Saisie des Notes : ");
            System.out.println("3. Calcul de la Moyenne : ");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");

            int option = scanner.nextInt();
            scanner.nextLine(); 
            EtudiantManager etudiantManager = new EtudiantManager();

            switch (option) {
                case 1:
                	etudiantManager.addEtudiant();
                    break;
                case 2:
                	etudiantManager.addNote();
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

	}

	
	 
	@Override
	public void addEtudiant() {
		System.out.print("Entrer le code de l'étudiant : ");
		String code = scanner.nextLine();
		
		Etudiant etudiant = findEtudiant(code);
		if (etudiant == null) {
			System.out.print("Entrer le prénom de l'étudiant : ");
			String prenom = scanner.nextLine();
			System.out.print("Entrer le nom de l'étudiant : ");
			String nom = scanner.nextLine();
			System.out.print("Entrer le email de l'étudiant : ");
			String email = scanner.nextLine();
			Etudiant et = new Etudiant(code,prenom,nom,email);
			
				
			etudiantList.add(et);
		}
		else {System.out.println("etudiant déja existé!!!!");}
		
		
		
	}

	@Override
	public void addNote() {
		
		// TODO Auto-generated method stub 
		System.out.print("Entrer le code de l'étudiant : ");
		String cd = scanner.next();
		
		Etudiant etudiant = findEtudiant(cd);
		
		
		System.out.print("Entrer la matiere : ");
		String mat = scanner.next();
		ArrayList<Float> noteList = new ArrayList<>(); 
		Matiere m = new Matiere(mat, noteList);
	    
		for( Matiere mm : etudiant.getMatieres())
		if(mm.getNomMatiere().equals(mat)){
		{
			System.out.print("Entrez une note (entre 0 et 20) : ");
            float note = scanner.nextFloat();
        			do {
        	            
        	            try {
        	            	
        	                
        	                //scanner.nextLine(); 
        	                if (note >= 0 && note <= 20) {
        	                	m.addNote(note);
        	                	etudiant.addMatieres(m);
        	                } else {
        	                    System.out.println("Note invalide. Veuillez réessayer.");
        	                }
        	            } catch (InputMismatchException e) {
        	                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
        	                scanner.nextLine(); // Clear the invalid input
        	                note = -1;
        	                
        	            }
        	        } while (note != -1);
        		
                
        } 
		
		}
		
		
		
	}

	@Override
	public Etudiant findEtudiant(String code) {
        for (Etudiant etudiant : etudiantList) {
            if (etudiant.getCode().equals(code)) {
                return etudiant;
            }
        }
        
        
        return null;
    }

	
	
	
	
}
