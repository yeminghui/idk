package top.codermhc.utils.excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yemh
 */
public class Test {
    public static void main(String[] args) throws IOException {
        final XSSFWorkbook sheets = new XSSFWorkbook(new FileInputStream("/tmp/test.xlsx"));
        final XSSFSheet sheet = sheets.getSheetAt(0);
        PoiSheetUtil.deleteRow(sheet, sheet.getRow(9));
        final FileOutputStream fileOutputStream = new FileOutputStream("/tmp/out.xlsx");
        sheets.write(fileOutputStream);
        sheets.close();
    }
}
