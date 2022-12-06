package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import pojo.Animal;
import pojo.Zoologico;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
	//ABRIR CONEXION
		 Session sesion = HibernateUtil.getSessionFactory().openSession();
		
	//INSERTAT EN BASE DE DATOS
		
		 /*Animal a1 = new Animal("gato","Casa", new BigDecimal(1));
		  sesion.save(a1);
		 */
		 /*
		 Zoologico z1 = new Zoologico("ZooloPark","Malaga",1997);
		 sesion.save(z1);
		 */
		 
	//TRAER DESDE BASE DE DATOS
		 /*int id = 4;
		  Animal a = (Animal)sesion.get(Animal.class,id);
		  System.out.println(a.getNombre());
		 */
		
	//LISTA DE ANIMALES
		  
		//BUSCAR CON CONSULTA WHERE (HABITAT = CASA)
		  	/*String hql = "FROM Animal where habitat = :habitat";
			Query query = sesion.createQuery(hql);
			query.setParameter("habitat", "Casa");
			List animales = query.getResultList();*/
			
			//TODOS LOS ANIMALES
			//List animales = sesion.createQuery("FROM Animal").getResultList();
		
			/*for(Iterator i = animales.iterator(); i.hasNext();) {
			
				Animal a = (Animal) i.next();
				System.out.println(a.getNombre());
			}*/
	//LISTA DE ZOOLOGICOS
		 //TODOS LOS ZOOLOGICOS
		 	/*List zoologicos = sesion.createQuery("From Zoologico").getResultList();*/ 
		 
		 //ZOOLOGICOS QUE ESTAN EN MALGA
		 	String hql = "FROM Zoologico where ciudad = :ciudad";
			Query query = sesion.createQuery(hql);
			query.setParameter("ciudad", "Malaga");
			List zoologicos = query.getResultList();
		 
		 for(Iterator i = zoologicos.iterator(); i.hasNext();) {
				
			Zoologico z = (Zoologico) i.next();
				System.out.println(z.getNombre());
		 	}
		  //CERRAR CONEXION
			sesion.close();

	}

}
