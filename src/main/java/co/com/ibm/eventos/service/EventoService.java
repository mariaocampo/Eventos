package co.com.ibm.eventos.service;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface EventoService {
	
	public Sheet generarReporteEventos(Workbook workbook); 

}
