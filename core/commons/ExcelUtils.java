package commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startRow = 1;

			int startCol = 2;

			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();
			System.out.println(totalRows);

			// you can write a function as well to get Column count

			int totalCols = 2;

			tabArray = new String[totalRows][totalCols];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;

				for (int j = startCol; j <= totalCols + 1; j++, cj++) {

					tabArray[ci][cj] = (String) getCellValue(i, j);

					System.out.println(tabArray[ci][cj]);

				}

			}

		}

		catch (FileNotFoundException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (tabArray);

	}

	// public static String getCellData(int RowNum, int ColNum) throws Exception {
	//
	// try {
	//
	// Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	//
	// int dataType = Cell.getCellType();
	//
	// if (dataType == 3) {
	//
	// return "";
	//
	// } else {
	//
	// String CellData = Cell.getStringCellValue();
	//
	// return CellData;
	//
	// }
	// } catch (Exception e) {
	//
	// System.out.println(e.getMessage());
	//
	// throw (e);
	//
	// }
	//
	// }

	public static Object getCellValue(int RowNum, int ColNum) {

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		// Convert to String
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(Cell);
		return cellData;

		/*
		 * Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum); switch (Cell.getCellTypeEnum()) { case STRING: return Cell.getStringCellValue();
		 * 
		 * case BOOLEAN: return Cell.getBooleanCellValue();
		 * 
		 * case NUMERIC: return Cell.getNumericCellValue(); default: break; } return null;
		 */

	}
}
