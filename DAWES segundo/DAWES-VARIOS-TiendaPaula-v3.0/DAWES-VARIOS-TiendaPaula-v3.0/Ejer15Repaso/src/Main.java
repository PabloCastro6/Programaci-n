import com.miempresa.modelo.Persona;
import com.miempresa.utilidades.Calculadora;

public class Main {
    public static void main(String[] args) {
       
        Persona persona = new Persona("Juan", 1.89, 80.0);

       
        double igcPersona = persona.calcularIGC();

        
        double igcCalculadora = Calculadora.calcularIGC(persona.getEstatura(), persona.getPeso());
        
        double areaCuadrado = Calculadora.calcularAreaCuadrado(2);
       
        System.out.println("IGC calculado por Persona: " + igcPersona);
        System.out.println("IGC calculado por Calculadora: " + igcCalculadora);
        System.out.println("Calcula área cuadrado: " + areaCuadrado);
        
    }
}
