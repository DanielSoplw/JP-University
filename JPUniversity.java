import java.util.ArrayList;
import java.util.List;

public class JPUniversity {
    private List<Estudiante> estudiantes;
    private List<Ayuda> ayudas;

    public JPUniversity() {
        estudiantes = new ArrayList<>();
        ayudas = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void asignarAyuda(Ayuda ayuda) {
        ayudas.add(ayuda);
    }

    public List<Ayuda> getAyudas() {
        return ayudas;
    }
}