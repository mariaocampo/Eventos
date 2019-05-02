package co.com.ibm.eventos.controllerTest;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ibm.eventos.controller.ReporteController;
import co.com.ibm.eventos.service.ReporteService;
import co.com.ibm.eventos.utils.Constantes;

@RunWith(MockitoJUnitRunner.class)
public class ReporteControllerTest {

	@InjectMocks
	ReporteController reporteController;
	
	@Mock
	ReporteService reporteService;
	
	@Test
	public void debeCapturarInformacionExcel() throws EncryptedDocumentException, IOException {
		//Arrange
		Sheet ibm = WorkbookFactory.create(new File(Constantes.IBM_XLSX_FILE_PATH)).getSheetAt(Constantes.INDEX_FILE);
		Sheet cgm = WorkbookFactory.create(new File(Constantes.CGM_XLSX_FILE_PATH)).getSheetAt(Constantes.INDEX_FILE);
		Workbook wb = new XSSFWorkbook();
		try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
	        wb.write(fileOut);
	    }
		when(reporteService.generarReporte(ibm, cgm)).thenReturn(wb);

		//Act
		Workbook result = reporteController.generarReporteEventos();
		
		//Assert
		Assert.assertNotNull(result);
	}
}
