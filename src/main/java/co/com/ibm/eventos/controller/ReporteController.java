package co.com.ibm.eventos.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ibm.eventos.service.ReporteService;
import co.com.ibm.eventos.utils.Constantes;

@RestController
@RequestMapping("/reporte")
public class ReporteController {

	@Autowired
	@Qualifier("reporteService")
	ReporteService reporteService;
	
	@GetMapping("/generar-reporte-eventos")
	public Workbook generarReporteEventos() throws EncryptedDocumentException, IOException{
		
		Sheet ibm = WorkbookFactory.create(new File(Constantes.IBM_XLSX_FILE_PATH)).getSheetAt(Constantes.INDEX_FILE);
		Sheet cgm = WorkbookFactory.create(new File(Constantes.CGM_XLSX_FILE_PATH)).getSheetAt(Constantes.INDEX_FILE);
		
		Workbook result = reporteService.generarReporte(ibm, cgm);
		
		try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
			result.write(fileOut);
	    }

		
		return result;
		/**return reporteService.generarReporte(
				WorkbookFactory.create(new File(Constantes.IBM_XLSX_FILE_PATH)).getSheetAt(Constantes.INDEX_FILE),
				WorkbookFactory.create(new File(Constantes.CGM_XLSX_FILE_PATH)).getSheetAt(Constantes.INDEX_FILE));**/
	}
}
