package prZoologicoDAO;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//Animal a = new Animal("Ignacion", "Bosque",(float)0.1);
		//AnimalDAO.insetAnimal(a);
		//AnimalDAO.deleteAnimal();
		//AnimalDAO.deleteAnimalNombre("Ignacion");
		//Animal a = AnimalDAO.buscarAnimalID(2);
		//System.out.println(a);
		
		//BUSQUEDAD DE TODOS LOS ANIMALES Y MOSTRARLOS
		ArrayList<Animal> animales = new ArrayList<Animal>();
		animales = AnimalDAO.buscarTodosAnimales();
		
		for(byte i=0; i<animales.size();i++) {
			
			System.out.println(animales.get(i));
		}
	}

}
