package co.com.ibm.eventos.serviceTest;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ibm.eventos.service.impl.ReporteServiceImpl;
import co.com.ibm.eventos.utils.Constantes;

@RunWith(MockitoJUnitRunner.class)
public class ReporteServiceTest {
	
	@InjectMocks
	ReporteServiceImpl reporteService = new ReporteServiceImpl();

	@Test
	public void debeGenerarReporteVolumentriaEventos() throws EncryptedDocumentException, IOException {
		//Arrange
		Sheet ibm = WorkbookFactory.create(new File(Constantes.IBM_XLSX_FILE_PATH)).getSheetAt(Constantes.INDEX_FILE);
		Sheet cgm = WorkbookFactory.create(new File(Constantes.CGM_XLSX_FILE_PATH)).getSheetAt(Constantes.INDEX_FILE);
		
		//Act
		Workbook result = reporteService.generarReporte(ibm, cgm);
		
		//Assert
		Assert.assertNotNull(result);
	}

}
