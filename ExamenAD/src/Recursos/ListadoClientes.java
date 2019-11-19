/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario DAM 2
 */
public class ListadoClientes {
     private List<Cliente> lista = new ArrayList<Cliente>();
	public ListadoClientes(){}
	public void add(Cliente per){
		lista.add(per);
	}
	public List<Cliente> getListaCliente(){
		return lista;
	}
}