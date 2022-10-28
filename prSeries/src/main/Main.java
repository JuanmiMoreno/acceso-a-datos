package main;
import dao.SerieDao;
import pojo.Serie;

public class Main {

	public static void main(String[] args) {
		
		Serie serie = new Serie(7,"los simpson","Disney Plus");
		SerieDao serieDao = new SerieDao();
		serieDao.insertar(serie);

	}

}
