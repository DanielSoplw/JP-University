public class Estudiante
{
    private String codigo, documento, nombre, email;
    private Fecha fechaNacimiento;
    private int estrato; 
    private TipoDocumento tipoDocumento; 
    
    public Estudiante (){
        
    }
    
    public Estudiante(String codigo, String documento, String nombre, String email, Fecha fechaNacimiento, int estrato, TipoDocumento tipoDocumento){
        this.codigo = codigo;
        this.documento = documento;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.estrato = estrato;
        this.tipoDocumento = tipoDocumento;
    }
//Start GetterSetterExtension Source Code

    /**GET Method Propertie codigo*/
    public String getCodigo(){
        return this.codigo;
    }//end method getCodigo

    /**SET Method Propertie codigo*/
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }//end method setCodigo

    /**GET Method Propertie documento*/
    public String getDocumento(){
        return this.documento;
    }//end method getDocumento

    /**SET Method Propertie documento*/
    public void setDocumento(String documento){
        this.documento = documento;
    }//end method setDocumento

    /**GET Method Propertie nombre*/
    public String getNombre(){
        return this.nombre;
    }//end method getNombre

    /**SET Method Propertie nombre*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//end method setNombre

    /**GET Method Propertie email*/
    public String getEmail(){
        return this.email;
    }//end method getEmail

    /**SET Method Propertie email*/
    public void setEmail(String email){
        this.email = email;
    }//end method setEmail

    /**GET Method Propertie fechaNacimiento*/
    public Fecha getFechaNacimiento(){
        return this.fechaNacimiento;
    }//end method getFechaNacimiento

    /**SET Method Propertie fechaNacimiento*/
    public void setFechaNacimiento(Fecha fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }//end method setFechaNacimiento

    /**GET Method Propertie estrato*/
    public int getEstrato(){
        return this.estrato;
    }//end method getEstrato

    /**SET Method Propertie estrato*/
    public void setEstrato(int estrato){
        this.estrato = estrato;
    }//end method setEstrato

//End GetterSetterExtension Source Code



//Start GetterSetterExtension Source Code

    /**GET Method Propertie tipoDocumento*/
    public TipoDocumento getTipoDocumento(){
        return this.tipoDocumento;
    }//end method getTipoDocumento

    /**SET Method Propertie tipoDocumento*/
    public void setTipoDocumento(TipoDocumento tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }//end method setTipoDocumento

//End GetterSetterExtension Source Code


}//End class