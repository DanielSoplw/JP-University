public class Ayuda
{
    private Fecha fechaAsignacion, fechaEntrega;
    private TipoAyuda tipoAyuda;
    private Estado estado;
    private Estudiante estudiante; 
    
    public Ayuda(){
        
    }
    
    public Ayuda(Fecha fechaAsignacion, Fecha fechaEntrega, TipoAyuda tipoAyuda, Estado estado, Estudiante estudiante){
        this.fechaAsignacion = fechaAsignacion;
        this.fechaEntrega = fechaEntrega; 
        this.tipoAyuda = tipoAyuda;
        this.estado = estado;
        this.estudiante = estudiante;
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie fechaAsignacion*/
    public Fecha getFechaAsignacion(){
        return this.fechaAsignacion;
    }//end method getFechaAsignacion

    /**SET Method Propertie fechaAsignacion*/
    public void setFechaAsignacion(Fecha fechaAsignacion){
        this.fechaAsignacion = fechaAsignacion;
    }//end method setFechaAsignacion

    /**GET Method Propertie fechaEntrega*/
    public Fecha getFechaEntrega(){
        return this.fechaEntrega;
    }//end method getFechaEntrega

    /**SET Method Propertie fechaEntrega*/
    public void setFechaEntrega(Fecha fechaEntrega){
        this.fechaEntrega = fechaEntrega;
    }//end method setFechaEntrega

    /**GET Method Propertie tipoAyuda*/
    public TipoAyuda getTipoAyuda(){
        return this.tipoAyuda;
    }//end method getTipoAyuda

    /**SET Method Propertie tipoAyuda*/
    public void setTipoAyuda(TipoAyuda tipoAyuda){
        this.tipoAyuda = tipoAyuda;
    }//end method setTipoAyuda

    /**GET Method Propertie estado*/
    public Estado getEstado(){
        return this.estado;
    }//end method getEstado

    /**SET Method Propertie estado*/
    public void setEstado(Estado estado){
        this.estado = estado;
    }//end method setEstado

    /**GET Method Propertie estudiante*/
    public Estudiante getEstudiante(){
        return this.estudiante;
    }//end method getEstudiante

    /**SET Method Propertie estudiante*/
    public void setEstudiante(Estudiante estudiante){
        this.estudiante = estudiante;
    }//end method setEstudiante

//End GetterSetterExtension Source Code

  
   public void entregar(){
        this.estado = Estado.ENTREGADO;
        this.fechaEntrega = new Fecha();
   }
   
   public void rechazar(){
        this.estado = Estado.RECHAZADO;
        this.fechaEntrega = new Fecha(); 
   }

}//End class