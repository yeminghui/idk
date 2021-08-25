package top.codermhc.utils.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;

/**
 * @author yemh
 */
public class PoiCellUtil {

    public static CellDO backup(Cell cell) {
        final CellDO cellDO = new CellDO();
        final CellType cellType = cell.getCellType();
        cell.getCellStyle();
        return null;
    }

    public static Cell recovery(CellDO cell) {
        return null;
    }

    public static void copyTo(Cell source, Cell target) {

    }

}

class CellDO {
    CellType cellType;
    CellStyle cellStyle;
    CellValue cellValue;
    int row;
    int col;
}
