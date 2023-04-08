/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp;

/**
 *
 * @author mcasatti
 */
public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private int idPartido;
    
    public Partido() {
        
    }
    
    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.idPartido = idPartido;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public int getIdPärtido() {
        return idPartido;
    }

    public void setIdPärtido(int idPärtido) {
        this.idPartido = idPärtido;
    }
    
    @Override
    public String toString() {
        String res = 
                "-----------------------------------------\n"+
                this.equipo1.getNombre()+" vs. "+this.equipo2.getNombre()+"\n"+
                "Resultado: "+this.golesEquipo1+ " a "+this.golesEquipo2+"\n"+ "partido nro.: " + this.idPartido+"\n"+
                "-----------------------------------------\n";
        return res;
    }
    
    public char getResultado (Equipo equipo) {
        char resultado = 'X'; // POR DEFECTO NO SE SABE QUIEN GANO
        
        if (equipo.getNombre().equals(equipo1.getNombre())) {
            if (this.golesEquipo1 > this.golesEquipo2) {
                resultado = 'G';
            } else if (this.golesEquipo1 < this.golesEquipo2) {
                resultado = 'P';
            } else {
                resultado = 'E';
            }
        } else if (equipo.getNombre().equals(equipo2.getNombre())) {
            if (this.golesEquipo2 > this.golesEquipo1) {
                resultado = 'G';
            } else if (this.golesEquipo2 < this.golesEquipo1) {
                resultado = 'P';
            } else {
                resultado = 'E';
            }
        } 
        return resultado;
    }
}
