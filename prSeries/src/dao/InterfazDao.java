package dao;

import java.util.ArrayList;

public interface InterfazDao<T>{

	
	/**
	 * Funcion que inserta objetos en la base de datos
	 * @param t objeto que tenemos que insertar
	 */
	public void insertar (T t);
	
	
	/**
	 * Funcion para modificar un objeto en la base de datos
	 * @param t objeto a modificar
	 */
	public void modificar (T t);
	
	
	/**
	 * 	Funcion que borra un obejto de la base de datos
	 * @param t objeto para borrar
	 */
	public void borrar (T t);
	
	
	/**
	 * Muestra todos los objetos de la base de datos
	 * @return un arraylist de objetos t
	 */
	public ArrayList<T> buscarTodos();
	
	
	/**
	 * Muestra el objeto t con el id especificado
	 * @param i numero del id del objeto a buscar
	 * @return el objeto con el id especificado
	 */
	public T buscarPorId(int i);
	
}
