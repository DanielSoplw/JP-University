
public class Fecha
{
    private int dia, mes, año; 
    
    public Fecha(){
        
    }
    
    public Fecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie dia*/
    public int getDia(){
        return this.dia;
    }//end method getDia

    /**SET Method Propertie dia*/
    public void setDia(int dia){
        this.dia = dia;
    }//end method setDia

    /**GET Method Propertie mes*/
    public int getMes(){
        return this.mes;
    }//end method getMes

    /**SET Method Propertie mes*/
    public void setMes(int mes){
        this.mes = mes;
    }//end method setMes

    /**GET Method Propertie año*/
    public int getAño(){
        return this.año;
    }//end method getAño

    /**SET Method Propertie año*/
    public void setAño(int año){
        this.año = año;
    }//end method setAño

//End GetterSetterExtension Source Code


}//End class