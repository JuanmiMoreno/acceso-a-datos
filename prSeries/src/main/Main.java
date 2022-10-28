package main;
import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		
		//Serie serie = new Serie(7,"los simpson","Disney Plus");
		SerieDao serieDao = new SerieDao();
		//serieDao.insertar(serie);
		//System.out.println(serieDao.buscarPorId(2));
		
		Serie serie = serieDao.buscarPorId(3);
		Temporada t1 = new Temporada(1,"bart el cabron", serie);
		Temporada t2 = new Temporada (2, "Hommer el molon", serie); 
		
		TemporadaDao  temporadaDao = new TemporadaDao();
		temporadaDao.insertar(t1);
		temporadaDao.insertar(t2);
		
	}

}
