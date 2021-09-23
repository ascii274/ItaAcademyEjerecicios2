package ascii274.controller.nivell3;

import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class AlumneRepository {
	private Alumne alumne;
	private List<Alumne> listAlumnes = new ArrayList<Alumne>();
	
	
	public void fillStudent() {
		
		listAlumnes.add(new Alumne("Pedro",22,CursEnum.JAVA,6.5));
		listAlumnes.add(new Alumne("Paco",20,CursEnum.PHP,5.5));
		listAlumnes.add(new Alumne("Shiva", 17, CursEnum.JAVA, 4.0));
		listAlumnes.add(new Alumne("Laura", 18, CursEnum.PYTHON, 4.9));
		listAlumnes.add(new Alumne("Vanesa", 29, CursEnum.PHP, 7.0));
		listAlumnes.add(new Alumne("Alvaro", 19, CursEnum.PYTHON, 8.9));
		listAlumnes.add(new Alumne("Ester", 40, CursEnum.JAVA, 7.5));
		listAlumnes.add(new Alumne("Oscar", 27, CursEnum.PHP, 5.0));
		listAlumnes.add(new Alumne("Maria", 33, CursEnum.JAVA, 2.0));
		
	}
	
 
	/**
	 * Mostra el nom i l'edat de l'alumne
	 */
	public void printNameAge() {
		System.out.println("****** Print student data and Age*****");
//		listAlumnes.stream().forEach(System.out::println); // imprimie tl toSring de la clase Alumne
		listAlumnes.forEach(x->System.out.println("[Nombre:" + x.getNom() + " ,edat:" + x.getEdat() +"]"));
	}
 
	/**
	 * Retorna un List<Alumnes> que li pasem una expressio lambda. 
	 * En aquet cas x-> x.getName()startsWith(stringStart);
	 * 
	 * @param alumnes
	 * @param predicate
	 * @return
	 */
	
	public List<Alumne> filterAlumne(List<Alumne> alumnes, Predicate<Alumne> predicate){
		return alumnes.stream().filter(predicate).collect(Collectors.toList());
	}
	
	/**
	 * Filtra alumnes que el nom comença per el @param stringStarts i ho asigna a la llista listNamAge
	 * 
	 * @param stringStarts
	 */
	public void filterNameAndAgeStartsWith(String stringStarts) {
		List<Alumne> listNameAge = filterAlumne(listAlumnes,x->x.getNom().startsWith(stringStarts));
		System.out.println("\n***** Print students with names starting '" + stringStarts + "' ****");
//		System.out.println(listNameAge); // lo muesra en una sola linea
		listNameAge.forEach(System.out::println);
	}
	
	/**
	 * Filtra les notes que rep @param note 
	 * @param note
	 */
	public void filterNote(double note) {
		List<Alumne> listNote = filterAlumne(listAlumnes, x->x.getNota() >=note);
		System.out.println("\n***** Print students with notes >='" + note + "' ****");
//		System.out.println(listNote); // lo muestra en una sola linea
		listNote.forEach(System.out::println);
	}
	
	/**
	 *  Filtra @param note >= 5 and @param cursEnum='PHP'
	 *    
	 * @param note
	 * @param cursEnum
	 */
	public void filterNoteAndCurs(double note, CursEnum cursEnum) {
		System.out.println("\n***** Print students with notes >='" + note + "' and Course:'" + cursEnum + "' ****");
		List<Alumne> listNoteAndCurs = filterAlumne(listAlumnes, x-> x.getNota()>=note && x.getCurs() == cursEnum.PHP);
		listNoteAndCurs.forEach(System.out::println);
	}
	
	
	public void filterStudenCourseAndOlderAge(CursEnum cursEnum) {
		System.out.println("\n***** Print Students in " + cursEnum + "' course");
		List<Alumne> listStudenCourse = filterAlumne(listAlumnes, x-> x.getCurs()==cursEnum.JAVA && x.getEdat()> 18 );
		listStudenCourse.forEach(System.out::println);
		
	}
	
	
	//getter setter
	public List<Alumne> getlistAlumnes() {
		return listAlumnes;
	}
	
	

}
