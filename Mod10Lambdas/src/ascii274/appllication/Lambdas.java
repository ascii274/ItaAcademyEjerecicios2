package ascii274.appllication;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambdas {
	

	/*
	 *  apartado 1
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
	
	/*
	 *- apartado 2
	 *
	 */
	
	
	public String getNumberToString(List<Integer> listaNumeros, String separator) {
		return listaNumeros.stream().map(n -> (n % 2==0) ? "e"+ n:"o" + n).collect(Collectors.joining(separator));
//		return listaNumeros.stream().map(Object::toString).collect(Collectors.joining(separator));
	}
	
//	public String getNumberToString(List<Integer> listaNumeros, Consumer<String> consumer, String separator) {
//		return listaNumeros.stream().map(n -> (n % 2==0) ? "e"+ n:"o" + n).collect(Collectors.joining(separator));
//	}

	
//	public Predicate<String> returnNameWith(String stringContent){
//		return text -> text.contains(stringContent);
//	}
//	
	
	/*
	 *- apartado 3 
	 */
	public Predicate<String> returnNamesWith(String stringContent){	
		//return texto -> texto.length() < longitud;
		return text -> text.contains(stringContent);
	}
	
	
	public void printNamesContentWith(List<String> lista,Consumer <String> consumer, String stringContent){
		System.out.println("***** Return names with '" + stringContent + "' *****");
		lista.stream().filter(this.returnNamesWith(stringContent)).forEach(consumer);
	}
	
	/*
	 * - apartado 4
	 */
	
	public Predicate<String> returnNameWithMaxLength(String stringContent, int longitud){
		return text -> text.contains(stringContent) && text.length() > 5;
	}
	
	public void filterNameWithMaxLength(List<String> lista, Consumer<String> consumer, String stringContent, int longitud) {
		System.out.println("***** Return names with '" + stringContent + "' and length >" + longitud + " *****");
		lista.stream().filter(this.returnNameWithMaxLength(stringContent, longitud)).forEach(consumer);		
	}
	
	/*
	 * - apartado 5 
	 */
	
	public void printMonth(List<String> lista) {//		
		System.out.println("***** Print months using lambda *****");
		lista.stream().forEach(v->System.out.println(v));		
	}
	
	/*
	 * - Apartado6
	 */
	public void printMonthMethodReference(List<String> lista, Consumer<String> consumer) {
		System.out.println("***** Print months method reference *****");		
//		lista.stream().forEach(consumer); // mejor no? porque no hay encadenamiento de proceso
//		lista.forEach(System.out::println); // version sin Consumer		
		lista.forEach(consumer);
		
	}
	
	/*
	 * - Nivel 1, fase 2.
	 */
	public void printPiValue() {
		Pi_InterfazFuncional pi_InterfazFuncional = () -> 3.1415;
		System.out.println("***** Print getValue from Interface functional *****");
		System.out.println(pi_InterfazFuncional.getPiValue());
		
	}
	
	
	/*
	 * - Nivel 1 , fase 3. 
	 */
	
	public void printTextReverse(String text) {
		
		Cadena_InterfazFuncional cadena_InterfazFuncional2 = (x) ->{	
		//String stringReverse2 = "";
		char ch2[] = x.toCharArray();
		for(int i=ch2.length-1; i>=0;i--) {
			x += ch2[i];
			}			
		return x;
		
		};		
		System.out.println("***** Print text reverse *****");
		System.out.println(cadena_InterfazFuncional2.reverse(text));		
	}
	
	
	
	
	
	
}
