package main;
import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;


public class Main {

	public static void main(String[] args) {
		
//		//Serie serie = new Serie(7,"los simpson","Disney Plus");
	SerieDao serieDao = new SerieDao();
//		//serieDao.insertar(serie);
//		//System.out.println(serieDao.buscarPorId(2));
//		
//		Serie serie = serieDao.buscarPorId(3);
//		Temporada t1 = new Temporada(1,"bart el cabron", serie);
//		Temporada t2 = new Temporada (2, "Hommer el molon", serie); 
//		
//		TemporadaDao  temporadaDao = new TemporadaDao();
//		temporadaDao.insertar(t1);
//		temporadaDao.insertar(t2);
		//Serie s = new Serie (12, "The Mandalorian",  "Disney plus");
		//serieDao.insertar(s);
		
		Serie losSimpson = serieDao.buscarPorId(3);
		losSimpson.setPlataforma("Netflix");
		serieDao.modificar(losSimpson);
		
		/*ArrayList<Serie>series = serieDao.buscarTodos();
		
		for(Serie serie : series) {
			System.out.println(serie);
		}*/
		
		ArrayList<Temporada> temporadas = serieDao.obetenerTemporadas(losSimpson);
		for(Temporada temporada : temporadas) {
			System.out.println(temporada);
		}
	}

}
