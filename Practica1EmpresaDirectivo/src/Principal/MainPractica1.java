package Principal;

import Dao.EmpresaDao;
import Pojo.Empresa;

public class MainPractica1 {

	public static void main(String[] args) {
		

		Empresa empresa = new Empresa("Agricolas Moreno", "12345678K",(float) 1234567812);
		EmpresaDao empresaDao = new EmpresaDao();
		empresaDao.insertar(empresa);
	}

}
