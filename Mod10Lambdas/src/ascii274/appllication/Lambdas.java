package ascii274.appllication;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambdas {
	

	/**
	 * Nivel 1 Apartado 1
	 * Retorna cadenes que comencen por el parametre cadena i amb una longitud  de cadena igual
	 * parametre longitud  
	 * 
	 * @param cadena
	 * @param longitud
	 * @return
	 */
	public Predicate<String> returnNameStartsWithLength(String cadena,int longitud) {		
//		nombres.forEach(x-> System.out.println(x.startsWith("A")));
		return texto -> texto.startsWith(cadena) && texto.length() == longitud;
	}
	
	public void filterNamesStartsWithLength(List<String> lista, Consumer <String> consumer, String stringStart,int longitud) {
		//consumer -> interfaz funcional -> can be used as the assignment target for lambda
		System.out.println("***** Filter names starting with '" + stringStart +"' and text length=" + longitud + " *****"  );
		lista.stream().filter(this.returnNameStartsWithLength(stringStart,longitud)).forEach(consumer);
	}
	
	/**
	 * Nivel 1 Apartado 2
	 * Retorn una cadena separada per comes en un llista d'integers
	 *  
	 * @param listaNumeros
	 * @param separator
	 * @return
	 */
	
	public String getNumberToString(List<Integer> listaNumeros, String separator) {
		return listaNumeros.stream().map(n -> (n % 2==0) ? "e"+ n:"o" + n).collect(Collectors.joining(separator));		
	}
	
	// otra forma de hacer
//	public String getNumberToString2(List<Integer> listaNumeros, Consumer<String> consumer, String separator) {
//		return listaNumeros.stream().map(n -> (n % 2==0) ? "e"+ n:"o" + n).collect(Collectors.joining(separator));
//	}

	

	/**
	 * Nivel 1 Apartado 3.
	 * Retorna una llista de cadenes de text que contenen @param stringContent
	 * 
	 * @param stringContent
	 * @return
	 */
	public Predicate<String> returnNamesWith(String stringContent){	
		//return texto -> texto.length() < longitud;
		return text -> text.contains(stringContent);
	}
	
	
	public void printNamesContentWith(List<String> lista,Consumer <String> consumer, String stringContent){
		System.out.println("***** Return names with '" + stringContent + "' *****");
		lista.stream().filter(this.returnNamesWith(stringContent)).forEach(consumer);
	}
	
	
	/**
	 * Nivel 1 Apartado 4
	 * Retorna  cadenes de text amb una logitud segons el @param longitud
	 * 
	 * @param stringContent
	 * @param longitud
	 * @return
	 */
	
	public Predicate<String> returnNameWithMaxLength(String stringContent, int longitud){
		return text -> text.contains(stringContent) && text.length() > 5;
	}
	
	public void filterNameWithMaxLength(List<String> lista, Consumer<String> consumer, String stringContent, int longitud) {
		System.out.println("***** Return names with '" + stringContent + "' and length >" + longitud + " *****");
		lista.stream().filter(this.returnNameWithMaxLength(stringContent, longitud)).forEach(consumer);		
	}
	
	
	/**
	 * Nivel 1 Apartado 5.
	 * Mostra les dades de la llista
	 * @param lista
	 */
	
	public void printMonth(List<String> lista) {//		
		System.out.println("***** Print months using lambda *****");
		lista.stream().forEach(v->System.out.println(v));		
	}
	
	
	/**
	 * Nivel 1 Apartado 6.
	 * Mostra dades utilitzant method reference. 
	 * 
	 * @param lista
	 * @param consumer
	 */
	public void printMonthMethodReference(List<String> lista, Consumer<String> consumer) {	
		System.out.println("***** Print months method reference *****");
		// mejor no? porque no hay encadenamiento de proceso
//		lista.stream().forEach(consumer); 
		// version sin Cosumer, directament al métode
//		lista.forEach(System.out::println); 		
		lista.forEach(consumer);
		
	}
	
	
	/**
	 * Nivel 1 Fase 2
	 * Interface functional: retorna el valor del metode getPitValue()
	 * 
	 */
	public void printPiValue() {
		Pi_InterfazFuncional pi_InterfazFuncional = () -> 3.1415;
		System.out.println("***** Print getValue from Interface functional *****");
		System.out.println(pi_InterfazFuncional.getPiValue());
		
	}
	
	/**
	 * Nivel 1 Fase 3.
	 * Interface fucntional que retorna el un sting reverse a través del @param text
	 * 
	 * @param text
	 */
	
	public void printTextReverse(String text) {		
		Cadena_InterfazFuncional cadena_InterfazFuncional2 = (x) ->{
		char ch2[] = x.toCharArray();
		for(int i=ch2.length-1; i>=0;i--) {
			x += ch2[i];
			}			
		return x;
		
		};		
		System.out.println("***** Print text reverse *****");
		System.out.println(cadena_InterfazFuncional2.reverse(text));		
	}
	
	
	
	/** Nivel 2 Apartado 1 y 2.
	 * Ordena el listado true:descendiente false:descendiente y reverse
	 *  
	 * @param list
	 * @param ascDescendiente
	 * 
	 */
	public void ordenarTextosINumeros(List<String> list, boolean ascDescendiente) {
		// por defecto es ascendente
		if(ascDescendiente) {//ascendiente
			System.out.println("***** Print text order ascendancy *****");
//			list.stream().sorted(Comparator.comparing(s -> s.length())).forEach(System.out::println);
			list.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		}else {
			System.out.println("***** Print text order descendant *****");
			list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
//			list.stream().sorted(Comparator.comparing((String s)->s.length()).reversed()).forEach(System.out::println);			
		}		
	}
	
	/** Nivel 2 Apartado 3.
	 * Ordena alfabeticament per el primer caracter.
	 * @param list
	 * Ordena el listado por el primer caracter del listado
	 */
	public void ordenarPrimerCaracter(List<String> list) {
		System.out.println("***** Print alfabetical order first character *****");
		list.stream().sorted( Comparator.comparing(v->v.charAt(0))).forEach(System.out::println);
	}
	
	/**
	 * Nivel 2 Aparatado 4.
	 * Mostra cadenes de texts del que contenen el @param contenido.
	 * 
	 * @param list
	 * @param contenido
	 * Filtra el listado con el contenido que se pasa por el parametro y lo muestra
	 */
	public void ordenarTextosCon(List<String> list,String contenido) {
		System.out.println("***** Print order text with '"+ contenido +"' *****");
		// mustra solo los que tiene el valor del parametro contenido
		list.stream().filter( s->s.contains(contenido) ).collect(Collectors.toList()).forEach(System.out::println);;
//		list.stream().collect(  Collectors.groupingBy (s->s.contains(contenido))  ).values().forEach(System.out::println);
		
		//filtrado por el parametro contenido
//		list.stream().collect(  Collectors.groupingBy (s->s.contains(contenido))  ).values().forEach(System.out::println);		
	}
	
	/**
	 * Nivel 2 Apartado 5.
	 * Modifica el caracteres que rep per @param OldChar i ho canvía pero un de nou @param newChar
	 * 
	 * @param list
	 * @param oldChar
	 * @param newChar
	 */

	public void modifyElementsOfArray(List<String> list, String oldChar, String newChar) {
		System.out.println("***** Print text changing '"+ oldChar +"' with '" + newChar + "' *****");		
		list.stream().map(v-> v.replace(oldChar, newChar)).forEach(System.out::println);
	}
	
	/**
	 * Nivel 2 Apartado 6.	 * 
	 * Mostra elements que només on numerics guardats com strings.
	 * Filtrat amb predicate a part
	 * @param list
	 */
	public void filterOnlyNumbers(List<String> list) {
		System.out.println("***** Print only numbers *****");
		list.stream().filter( this.returnOnlyNumbers()  ).forEach(System.out::println);		
	}
	
	public Predicate<String> returnOnlyNumbers(){
		String expressionNumbers ="[0-9]+";
		return texto -> texto.matches(expressionNumbers);
	}
	
	/**
	 * Nivel 2 Apartado 6
	 * Sense predicator dins del filter.
	 * 
	 * @param list
	 */
	
	public void filterOnlyNumbers2(List<String> list) {
		String numbersExpressions="\\d+";
		list.stream().filter(  v-> v.matches(numbersExpressions) ).forEach(System.out::println);		
	}
	/**
	 * Nivel 2 Apartado 7.
	 * Suma Resta Multiplicacion Division
	 * 
	 */
	
	public void sumaRestaMultiplicacioDivisio() {
		Calcul_InterfazFuncional calcul_InterfazFuncional;
		System.out.println("***** Sum *****");
		calcul_InterfazFuncional = ()-> 5+2;		
		System.out.println(calcul_InterfazFuncional.operacio());
		
		System.out.println("***** Substraction *****");
		calcul_InterfazFuncional = ()-> 5-2;		
		System.out.println(calcul_InterfazFuncional.operacio());
		
		System.out.println("***** Multiplication *****");
		calcul_InterfazFuncional = ()-> 5*2;		
		System.out.println(calcul_InterfazFuncional.operacio());
		
		System.out.println("***** Division *****");
		calcul_InterfazFuncional = ()-> 5/2;		
		System.out.println(calcul_InterfazFuncional.operacio());		
	}
	
	
}
