package co.com.ibm.eventos.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface ReporteService {
	
	public Workbook generarReporte(Sheet ibm, Sheet cgm) throws FileNotFoundException, IOException ;

}
