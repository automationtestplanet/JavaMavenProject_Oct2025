package com.automationtestplanet;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public List<Map<String, String>> readDataFromExcel(String excelFilePath, String sheetName) {
		try {
			FileInputStream testXlsxFile = new FileInputStream(new File(excelFilePath));

			XSSFWorkbook workbook = new XSSFWorkbook(testXlsxFile);
			XSSFSheet languagesSheet = workbook.getSheet(sheetName);

			List<String> headers = getHeaders(languagesSheet);

			List<Map<String, String>> mappedDataList = readDataAndMapItWithHeaders(languagesSheet, headers);

			testXlsxFile.close();

			return mappedDataList;
		} catch (Exception e) {
			System.out.println("Exception Occurred while reading the data fro excel: " + e.getMessage());
			return null;
		}
	}

	public List<String> getHeaders(XSSFSheet sheet) {
		List<String> headersList = new ArrayList();

		Row headersRow = sheet.getRow(0);

		Iterator<Cell> allColumns = headersRow.cellIterator();

		while (allColumns.hasNext()) {
			Cell eachCell = allColumns.next();
			switch (eachCell.getCellType()) {
			case STRING:
				String cellVal = eachCell.getStringCellValue();
				headersList.add(cellVal);
				break;
			default:
				System.out.println("No match fond");
			}
		}

		return headersList;
	}

	public List<Map<String, String>> readDataAndMapItWithHeaders(XSSFSheet sheet, List<String> headers) {

		List<Map<String, String>> allDataMaps = new ArrayList<>();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row eachRow = sheet.getRow(i);

			Map<String, String> dataMap = new LinkedHashMap<>();

			for (int j = 0; j < eachRow.getLastCellNum(); j++) {
				Cell eachCell = eachRow.getCell(j);
				switch (eachCell.getCellType()) {
				case STRING:
					String cellVal = eachCell.getStringCellValue();
					dataMap.put(headers.get(j), cellVal);
					break;
				case NUMERIC:
					double value = eachCell.getNumericCellValue();
					dataMap.put(headers.get(j), String.valueOf((int)value));
					break;
				default:
					System.out.println("No match fond");
				}
			}
			allDataMaps.add(dataMap);
		}

		return allDataMaps;
	}

	public static void main(String[] args) {
		ExcelUtils excel = new ExcelUtils();
//		String excelFilePath = System.getProperty("user.dir") + "//src//main//resources//Test.xlsx";
//		List<Map<String, String>> testData = excel.readDataFromExcel(excelFilePath, "Languages");
//		System.out.println(testData);
//		
//		for(Map<String, String> eachMap : testData) {
//			System.out.println(eachMap);
//		}
		
		String excelFilePath = System.getProperty("user.dir") + "//src//main//resources//OpenMRSTestData.xlsx";
		List<Map<String, String>> testData = excel.readDataFromExcel(excelFilePath, "RegisterPatientDetails");
		
		
		for(Map<String, String> eachMap : testData) {
			System.out.println(eachMap);
		}
		
	}

}
