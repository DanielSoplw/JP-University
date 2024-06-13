
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;



public class JPUniversityController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea areaResultados;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAsignar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnResumen;

    @FXML
    private TextField lblCodigo;

    @FXML
    private TextField lblDocumento;

    @FXML
    private TextField lblEmail;

    @FXML
    private Label lblEstado;

    @FXML
    private TextField lblEstrato;

    @FXML
    private Label lblFechaAsignacion;

    @FXML
    private Label lblFechaEntrega;

    @FXML
    private TextField lblFechaNacimiento;

    @FXML
    private TextField lblNombre;

    @FXML
    private Label lblTipoAyuda;

    @FXML
    private TextField lblTipoDocumento;

    @FXML
    private Label txtCodigo;

    @FXML
    private Label txtDocumento;

    @FXML
    private Label txtEmail;

    @FXML
    private TextField txtEstado;

    @FXML
    private Label txtEstrato;

    @FXML
    private TextField txtFechaAsignacion;

    @FXML
    private TextField txtFechaEntrega;

    @FXML
    private Label txtFechaNacimiento;

    @FXML
    private Label txtInformacion;

    @FXML
    private Label txtNombre;

    @FXML
    private TextField txtTipoAyuda;

    @FXML
    private Label txtTipoDocumento;
    
    private JPUniversity jpu;
    
    
        
    

    @FXML
    void actualizarInformacion(ActionEvent event) {
       String codigo = txtCodigo.getText();
        Estudiante estudiante = buscarEstudiante(codigo);

        if (estudiante != null) {
            estudiante.setDocumento(txtDocumento.getText());
            estudiante.setNombre(txtNombre.getText());
            estudiante.setEmail(txtEmail.getText());
            estudiante.setEstrato(Integer.parseInt(txtEstrato.getText()));
            String[] fechaParts = txtFechaNacimiento.getText().split("-");
            Fecha fechaNacimiento = new Fecha(Integer.parseInt(fechaParts[0]), Integer.parseInt(fechaParts[1]), Integer.parseInt(fechaParts[2]));
            estudiante.setFechaNacimiento(fechaNacimiento);
            estudiante.setTipoDocumento(TipoDocumento.valueOf(txtTipoDocumento.getText()));

            areaResultados.setText("Información del estudiante actualizada exitosamente");
        } else {
            areaResultados.setText("Error: Estudiante no encontrado");
        }
    }

    @FXML
    void asignarAyuda(ActionEvent event) {
        String codigo = txtCodigo.getText();
        Estudiante estudiante = buscarEstudiante(codigo);

        if (estudiante != null) {
            TipoAyuda tipoAyuda = TipoAyuda.valueOf(lblTipoAyuda.getText());
            String[] fechaAsignacionParts = lblFechaAsignacion.getText().split("-");
            Fecha fechaAsignacion = new Fecha(Integer.parseInt(fechaAsignacionParts[0]), Integer.parseInt(fechaAsignacionParts[1]), Integer.parseInt(fechaAsignacionParts[2]));
            String[] fechaEntregaParts = lblFechaEntrega.getText().split("-");
            Fecha fechaEntrega = new Fecha(Integer.parseInt(fechaEntregaParts[0]), Integer.parseInt(fechaEntregaParts[1]), Integer.parseInt(fechaEntregaParts[2]));
            Estado estado = Estado.valueOf(lblEstado.getText());

            Ayuda ayuda = new Ayuda(fechaAsignacion, fechaEntrega, tipoAyuda, estado, estudiante);
            jpu.asignarAyuda(ayuda);

            areaResultados.setText("Ayuda asignada exitosamente");
        } else {
            areaResultados.setText("Error: Estudiante no encontrado");
        }
    }
    
      private Estudiante buscarEstudiante(String codigo) {
     for (Estudiante est : jpu.getEstudiantes()) {
        if (est.getCodigo().equals(codigo)) {
            return est;
        }
     }
     return null;
    }

    @FXML
    void generarResumen(ActionEvent event) {
      int ayudasEntregadas = 0;
        int estudiantesFavorecidos = 0;
        List<String> estudiantesFavorecidosList = new ArrayList<>();

        for (Ayuda ayuda : jpu.getAyudas()) {
            if (ayuda.getEstado() == Estado.ENTREGADO) {
                ayudasEntregadas++;
                if (!estudiantesFavorecidosList.contains(ayuda.getEstudiante().getCodigo())) {
                    estudiantesFavorecidos++;
                    estudiantesFavorecidosList.add(ayuda.getEstudiante().getCodigo());
                }
            }
        }

        areaResultados.setText("Cantidad de ayudas entregadas: " + ayudasEntregadas + "\nNúmero de estudiantes favorecidos: " + estudiantesFavorecidos);
    }

    @FXML
    void limpiarInformacion(ActionEvent event) {
        lblCodigo.clear();
        lblDocumento.clear();
        lblTipoDocumento.clear();
        lblNombre.clear();
        lblEmail.clear();
        lblFechaNacimiento.clear();
        lblEstrato.clear();
        areaResultados.setText(""); 
    }

    @FXML
    void registrarEstudiante(ActionEvent event) {
       String codigo = txtCodigo.getText();
        String documento = txtDocumento.getText();
        String nombre = txtNombre.getText();
        String email = txtEmail.getText();
        int estrato = Integer.parseInt(txtEstrato.getText());
        String[] fechaParts = txtFechaNacimiento.getText().split("-");
        Fecha fechaNacimiento = new Fecha(Integer.parseInt(fechaParts[0]), Integer.parseInt(fechaParts[1]), Integer.parseInt(fechaParts[2]));
        TipoDocumento tipoDocumento = TipoDocumento.valueOf(txtTipoDocumento.getText());

        Estudiante estudiante = new Estudiante(codigo, documento, nombre, email, fechaNacimiento, estrato, tipoDocumento);
        jpu.registrarEstudiante(estudiante);

        areaResultados.setText("Estudiante registrado exitosamente");
    }

    @FXML
    void initialize() {
        assert areaResultados != null : "fx:id=\"areaResultados\" was not injected: check your FXML file 'Untitled'.";
        assert btnActualizar != null : "fx:id=\"btnActualizar\" was not injected: check your FXML file 'Untitled'.";
        assert btnAsignar != null : "fx:id=\"btnAsignar\" was not injected: check your FXML file 'Untitled'.";
        assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'Untitled'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'Untitled'.";
        assert btnResumen != null : "fx:id=\"btnResumen\" was not injected: check your FXML file 'Untitled'.";
        assert lblCodigo != null : "fx:id=\"lblCodigo\" was not injected: check your FXML file 'Untitled'.";
        assert lblDocumento != null : "fx:id=\"lblDocumento\" was not injected: check your FXML file 'Untitled'.";
        assert lblEmail != null : "fx:id=\"lblEmail\" was not injected: check your FXML file 'Untitled'.";
        assert lblEstrato != null : "fx:id=\"lblEstrato\" was not injected: check your FXML file 'Untitled'.";
        assert lblFechaNacimiento != null : "fx:id=\"lblFechaNacimiento\" was not injected: check your FXML file 'Untitled'.";
        assert lblNombre != null : "fx:id=\"lblNombre\" was not injected: check your FXML file 'Untitled'.";
        assert lblTipoDocumento != null : "fx:id=\"lblTipoDocumento\" was not injected: check your FXML file 'Untitled'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'Untitled'.";
        assert txtDocumento != null : "fx:id=\"txtDocumento\" was not injected: check your FXML file 'Untitled'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Untitled'.";
        assert txtEstrato != null : "fx:id=\"txtEstrato\" was not injected: check your FXML file 'Untitled'.";
        assert txtFechaNacimiento != null : "fx:id=\"txtFechaNacimiento\" was not injected: check your FXML file 'Untitled'.";
        assert txtInformacion != null : "fx:id=\"txtInformacion\" was not injected: check your FXML file 'Untitled'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'Untitled'.";
        assert txtTipoDocumento != null : "fx:id=\"txtTipoDocumento\" was not injected: check your FXML file 'Untitled'.";
        
        jpu = new JPUniversity();
    }

}
