package com.devcenter.apptest.util;

import com.devcenter.apptest.data.entity.Car;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UtilExcel {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Car> lisCars;

    public UtilExcel(List<Car> listCars) {
        this.lisCars = listCars;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ID COCHE", style);
        createCell(row, 1, "MODELO", style);
        createCell(row, 2, "COLOR", style);
        createCell(row, 3, "ID MARCA", style);
        createCell(row, 4, "MARCA", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value.toString());
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Car car : lisCars) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, car.getId(), style);
            createCell(row, columnCount++, car.getName(), style);
            createCell(row, columnCount++, car.getColor(), style);
            createCell(row, columnCount++, car.getBrand().getName(), style);
            createCell(row, columnCount++, car.getBrand().getId(), style);
            //createCell(row, columnCount++, car.getPrice()., style);

        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
