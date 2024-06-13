
import java.util.ArrayList;
import java.util.List;

public class JPUniversity {
    private List<Ayuda> ayudas;
    private List<Estudiante> estudiantes;
    
    public JPUniversity() {
        this.ayudas = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }
    
    public void registrarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }
    
    public void asignarAyuda(Ayuda ayuda) {
        this.ayudas.add(ayuda);
    }
    
    public void entregarAyuda(Ayuda ayuda) {
        ayuda.entregar();
    }
    
    public void rechazarAyuda(Ayuda ayuda) {
        ayuda.rechazar();
    }
    
    public void generarResumen() {
        int ayudasEntregadas = 0;
        int estudiantesFavorecidos = 0;
        List<String> estudiantesFavorecido = new ArrayList<>();
        
        for (Ayuda ayuda : ayudas) {
            if (ayuda.getEstado() == Estado.ENTREGADO) {
                ayudasEntregadas++;
                if (!estudiantesFavorecido.contains(ayuda.getEstudiante().getCodigo())) {
                    estudiantesFavorecidos++;
                    estudiantesFavorecido.add(ayuda.getEstudiante().getCodigo());
                }
            }
        }
        
        System.out.println("Cantidad de ayudas entregadas: " + ayudasEntregadas);
        System.out.println("Número de estudiantes favorecidos: " + estudiantesFavorecidos);
    }
    
    public static void main(String[] args) {
        JPUniversity jpu = new JPUniversity();
        
        // Ejemplo de uso
        Estudiante est1 = new Estudiante("001", "123456", "Juan Perez", "juan.perez@gmail.com", new Fecha(1, 1, 2000), 3, TipoDocumento.CC);
        Estudiante est2 = new Estudiante("002", "789101", "Maria Lopez", "maria.lopez@gmail.com", new Fecha(5, 5, 2001), 2, TipoDocumento.TI);
        
        jpu.registrarEstudiante(est1);
        jpu.registrarEstudiante(est2);
        
        Ayuda ayuda1 = new Ayuda(new Fecha(1, 6, 2023), null, TipoAyuda.MERCADO, Estado.ASIGNADO, est1);
        Ayuda ayuda2 = new Ayuda(new Fecha(1, 6, 2023), null, TipoAyuda.COMPUTADOR, Estado.ASIGNADO, est2);
        
        jpu.asignarAyuda(ayuda1);
        jpu.asignarAyuda(ayuda2);
        
        jpu.entregarAyuda(ayuda1);
        jpu.entregarAyuda(ayuda2);
        
        jpu.generarResumen();
    }
}