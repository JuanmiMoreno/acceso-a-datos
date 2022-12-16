package Principal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.DirectivoDao;
import Dao.EmpresaDao;
import Pojo.Directivo;
import Pojo.Empresa;

public class MainPractica1 {

	public static void main(String[] args) {
		
		
		try {
			ArrayList<Empresa> todasEmpresas = new ArrayList<Empresa>();
		System.out.println("Vamos a insertar una empresa en base de datos\n");
		Empresa empresa = new Empresa("Agricolas Moreno", "12345678K",(float) 1234567812);
		EmpresaDao empresaDao = new EmpresaDao();
		empresaDao.vaciarTablas();
		empresaDao.resetAutoIncrement();
		empresaDao.insertar(empresa);
		
		
		Empresa empresa1 = empresaDao.buscarPorId(1);
		
			Thread.sleep(3000);
	
		
		System.out.println("Vamos a insertar varios directivos a la empresa\n");
		Directivo d1 = new Directivo("Juan", "Moreno", "12345678L","Juan@gmail.com", empresa1);
		Directivo d2 = new Directivo("Luisa", "Rodriguez", "92545071A","Luisa@gmail.com", empresa1);
		DirectivoDao directivoDao = new DirectivoDao();
		directivoDao.resetAutoIncrement();
		directivoDao.insertar(d1);
		directivoDao.insertar(d2);
		
		Thread.sleep(3000);
		
		System.out.println("Vamos a insertar otra empresa para buscar  la primera empresa\n");
		Empresa empresaSegunda = new Empresa("AgricolasBecerra","34345678Y", (float)9866732);
		empresaDao.insertar(empresaSegunda);
		Thread.sleep(3000);
		
		Empresa empresa2 = empresaDao.buscarPorId(2);
		System.out.println("Insertamos varios directivos en la empresa con ID 2");
		Directivo d3 = new Directivo("Antonio", "Lopez", "09845678Q","Antonio@gmail.com", empresa2);
		Directivo d4 = new Directivo("Carmen", "Marin", "92900071Ñ","Carmen@gmail.com", empresa2);
		directivoDao.insertar(d3);
		directivoDao.insertar(d4);
		Thread.sleep(3000);
		
		System.out.println("Segunda empresa insertada, ahora vamos a buscar todas las empresas\n");
	 	 todasEmpresas = empresaDao.buscarTodos();
	 	for (Empresa empresas : todasEmpresas) {
	 		  System.out.println(empresas+"\n");
	 		}
	 	Thread.sleep(3000);
	 	
	 	System.out.println("Ahora mostraremos la empresa con id 1");
		 Empresa agricolaMoreno = empresaDao.buscarPorId(1);
		 System.out.println(agricolaMoreno+ "\n");
		 Thread.sleep(3000);
		 
		 System.out.println("Vamos a modificar el nombre a la primera empresa\n");
		 agricolaMoreno.setNombre("JuanmiAgricolas(MODIFICADO) ");
		 empresaDao.modificar(agricolaMoreno);
		 System.out.println(agricolaMoreno+"\n");
		 Thread.sleep(3000);
		 
		 System.out.println("Vamos a mostrar los empleados de la empresa con id 1\n");
		 ArrayList<Directivo> totalDirectivoEmpresa = new ArrayList<>();
		 totalDirectivoEmpresa = empresaDao.obetenerDirectivos(agricolaMoreno);
			for (Directivo directivos : totalDirectivoEmpresa) {
		 		  System.out.println(directivos+"\n");
		 		}
		 	Thread.sleep(3000);
		 

		 System.out.println("Vamos a borrar la empresa con id 1 y mostramos todas las empresas para ver que se ha borrado\n");
		 empresaDao.borrar(agricolaMoreno);
		 todasEmpresas = empresaDao.buscarTodos();
		 	for (Empresa empresas : todasEmpresas) {
		 		  System.out.println(empresas+"\n");
		 		}
		 	Thread.sleep(3000);
		 
		 	System.out.println("Al borrar la empresa con id 1 los directivos tambien de han borrado,\npara demostrarlo enseñaremos todos los empleados\n");
		 	ArrayList<Directivo> todosDirectivos = new ArrayList<Directivo>();
		 	todosDirectivos=directivoDao.buscarTodos();
		 	for (Directivo directivos : todosDirectivos) {
		 		  System.out.println(directivos+"\n");
		 		}
		 	Thread.sleep(3000);
		 	
		 	
		 	
		 	System.out.println("Vamos a modificar un directivo\n");
		 	Directivo directivo3 = directivoDao.buscarPorId(3);
		 	System.out.println(directivo3);
		 	directivo3.setNombre("Pepito(MODIFICADO)");
		 	directivoDao.modificar(directivo3);
		 	System.out.println(directivo3);
		 	Thread.sleep(3000);
		 	
		 
		 	System.out.println("Ahora vamos a añadir dos nuevosd directivo a empresa con id 2 para poder realizar una bisqueda personalizada\n");
		 	Directivo d5 = new Directivo("Luis", "Marin", "00900071A","Luis@gmail.com", empresa2);
		 	Directivo d6 = new Directivo("Jose Luis", "Moreno", "12998071Q","JoseLuis@gmail.com", empresa2);
		 	directivoDao.insertar(d5);
		 	directivoDao.insertar(d6);
		 	Thread.sleep(3000);
		 	
		 	
		 	System.out.println("Ahora vamos a buscar todos los empleados con apellido  = Marin\n");
		 	ArrayList<Directivo> directivosMarin =   directivoDao.buscarPorApellido();
		 	for (Directivo directivos : directivosMarin) {
		 		  System.out.println(directivos+"\n");
		 		}
		 	Thread.sleep(3000);
		 	
		 	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
