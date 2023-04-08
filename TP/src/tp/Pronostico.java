/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp;

/**
 *
 * @author mcasatti
 */
public class Pronostico {
    private Equipo equipo;
    private Partido partido;
    private char Resultado;
    private int idPronostico;
    public Pronostico(Equipo equipoApuesta, Partido partido1, char resultadoApuesta) {
        
    }

    public Pronostico(Equipo equipo, Partido partido, char Resultado, int idPronostico) {
        this.equipo = equipo;
        this.partido = partido;
        this.Resultado = Resultado;
        this.idPronostico = idPronostico;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public char getResultado() {
        return Resultado;
    }

    public void setResultado(char Resultado) {
        this.Resultado = Resultado;
    }

    public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
    }
    
    public String toString() {
        String res = "\nApuesto a que en el partido:\n"+
                this.getPartido()+
                this.getEquipo().getNombre()+" obtiene el siguiente Resultado: "+
                this.getResultado()+"\n" +
                this.idPronostico + "id del pronostico";
        return res;
    }
    
}
