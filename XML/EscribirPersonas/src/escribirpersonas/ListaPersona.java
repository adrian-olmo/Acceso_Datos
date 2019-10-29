/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escribirpersonas;

/**
 *
 * @author Usuario DAM 2
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario DAM 2
 */
public class ListaPersona {
    private List<Persona> lista = new ArrayList<Persona>();
	public ListaPersona(){}
	public void add(Persona per){
		lista.add(per);
	}
	public List<Persona> getListaPersona(){
		return lista;
	}
}