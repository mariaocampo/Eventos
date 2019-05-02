package co.com.ibm.excelFile;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelFile {

	public Workbook construirReporteExcel(Sheet ibm,Sheet cgm);
}
