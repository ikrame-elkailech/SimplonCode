/*
 * package note;
 * 
 * import java.util.ArrayList; import java.util.InputMismatchException; import
 * java.util.Scanner;
 * 
 * class Student { private String name; private ArrayList<Double> grades;
 * 
 * public Student(String name) { this.name = name; this.grades = new
 * ArrayList<>(); }
 * 
 * public String getName() { return name; }
 * 
 * public ArrayList<Double> getGrades() { return grades; }
 * 
 * public void addGrade(double grade) { grades.add(grade); } }
 * 
 * class GradeBook { private ArrayList<Student> students;
 * 
 * public GradeBook() { this.students = new ArrayList<>(); }
 * 
 * public void addStudent(Student student) { students.add(student); }
 * 
 * public Student findStudent(String name) { for (Student student : students) {
 * if (student.getName().equalsIgnoreCase(name)) { return student; } } return
 * null; }
 * 
 * public double calculateAverage(ArrayList<Double> grades) { if
 * (grades.isEmpty()) { return 0; }
 * 
 * double sum = 0; for (double grade : grades) { sum += grade; } return sum /
 * grades.size(); } }
 * 
 * public class test { public static void main(String[] args) { Scanner scanner
 * = new Scanner(System.in); GradeBook gradeBook = new GradeBook();
 * 
 * while (true) { System.out.println("1. Saisie des Notes");
 * System.out.println("2. Calcul de la Moyenne");
 * System.out.println("3. Quitter");
 * System.out.print("Choisissez une option : ");
 * 
 * int option = scanner.nextInt(); scanner.nextLine(); // Consume the newline
 * character
 * 
 * switch (option) { case 1: handleGradeEntry(scanner, gradeBook); break; case
 * 2: handleGradeCalculation(scanner, gradeBook); break; case 3:
 * System.out.println("Au revoir !"); System.exit(0); break; default:
 * System.out.println("Option invalide. Veuillez réessayer."); } } }
 * 
 * private static void handleGradeEntry(Scanner scanner, GradeBook gradeBook) {
 * System.out.print("Entrez le nom de l'étudiant : "); String studentName =
 * scanner.nextLine();
 * 
 * Student student = gradeBook.findStudent(studentName);
 * 
 * if (student == null) { student = new Student(studentName);
 * gradeBook.addStudent(student); }
 * 
 * System.out.println("Saisie des notes (entrez -1 pour terminer) :");
 * 
 * double grade; do { System.out.print("Entrez une note (entre 0 et 20) : ");
 * try { grade = scanner.nextDouble(); scanner.nextLine(); if (grade >= 0 &&
 * grade <= 20) { student.addGrade(grade); } else {
 * System.out.println("Note invalide. Veuillez réessayer."); } } catch
 * (InputMismatchException e) {
 * System.out.println("Entrée invalide. Veuillez entrer un nombre.");
 * scanner.nextLine(); // Clear the invalid input grade = -1; // Continue the
 * loop } } while (grade != -1); }
 * 
 * private static void handleGradeCalculation(Scanner scanner, GradeBook
 * gradeBook) { System.out.print("Entrez le nom de l'étudiant : "); String
 * studentName = scanner.nextLine();
 * 
 * Student student = gradeBook.findStudent(studentName);
 * 
 * if (student == null) { System.out.println("Étudiant non trouvé."); return; }
 * 
 * System.out.println("Calcul de la moyenne (entrez -1 pour terminer) :");
 * 
 * double average; do { System.out.print("Entrez une matière : "); String
 * subject = scanner.nextLine();
 * 
 * if (student.getGrades().isEmpty()) {
 * System.out.println("Aucune note enregistrée pour cet étudiant."); break; }
 * 
 * average = gradeBook.calculateAverage(student.getGrades());
 * System.out.println("Moyenne de " + subject + ": " + average);
 * 
 * System.out.print("Calculer la moyenne générale? (Oui/Non) : "); String choice
 * = scanner.nextLine();
 * 
 * if (choice.equalsIgnoreCase("Non")) { break; } } while (average != -1); } }
 */