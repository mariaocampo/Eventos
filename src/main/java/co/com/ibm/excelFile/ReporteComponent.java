package co.com.ibm.excelFile;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

@Component
public class ReporteComponent implements ExcelFile {

	@Override
	public Workbook construirReporteExcel(Sheet ibm, Sheet cgm) {
		// TODO Auto-generated method stub
		return null;
	}

}
