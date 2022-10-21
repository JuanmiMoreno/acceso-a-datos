package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		
		//Animal a = new Animal("Ignacion", "Bosque",(float)0.1);
		//AnimalDAO.insetAnimal(a);
		//AnimalDAO.deleteAnimal();
		//AnimalDAO.deleteAnimalNombre("Ignacion");
		Animal a = AnimalDAO.buscarAnimalID(2);
		System.out.println(a);
	}

}
