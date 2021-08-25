package top.codermhc.utils.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yemh
 */
public class PoiSheetUtil {
    public static void addRows() {

    }

    /**
     * delete the {@code row} in the {@code sheet}
     * @param sheet which sheet have the row to delete.
     * @param row which row will be removed.
     */
    public static void deleteRow(Sheet sheet, Row row) {
        if (sheet == null) {
            throw new IllegalArgumentException("sheet could not be [null].");
        }
        if (row == null) {
            throw new IllegalArgumentException("row could not be [null].");
        }
        if (!sheet.getRow(row.getRowNum()).equals(row)) {
            throw new IllegalArgumentException("sheet ["+sheet+"] dose not have row ["+row+"].");
        }
        deleteRow(sheet, row.getRowNum());
    }

    /**
     * delete row in sheet.
     * @param sheet which sheet have the row to delete.
     * @param deleteRowNum the number of the row will delete. 0 based.
     */
    private static void deleteRow(Sheet sheet, final int deleteRowNum) {
        int lastRowNum = sheet.getLastRowNum();

        List<Integer> removal = new ArrayList<>();
        List<CellRangeAddress> merge = new ArrayList<>();
        List<CellRangeAddress> mergedRegions = sheet.getMergedRegions();
        List<CellDO> needFix = new ArrayList<>();
        for (int i = 0, mergedRegionsSize = mergedRegions.size(); i < mergedRegionsSize; i++) {
            CellRangeAddress mergedRegion = mergedRegions.get(i);
            if (deleteRowNum < mergedRegion.getFirstRow()) {
                // Move merged area up. Do notion because {@code sheet.shiftRows()} will shift merged area also.
            } else if (deleteRowNum >= mergedRegion.getFirstRow() && deleteRowNum <= mergedRegion.getLastRow()) {
                // Decrease merged area's height. Remove when height is zero.
                removal.add(i);
                mergedRegion.setLastRow(mergedRegion.getLastRow() - 1);
                if (mergedRegion.getLastRow() > mergedRegion.getFirstRow()
                        || (mergedRegion.getLastRow() == mergedRegion.getFirstRow() && mergedRegion.getLastColumn() > mergedRegion.getFirstColumn())) {
                    merge.add(mergedRegion);
                }
                if (deleteRowNum == mergedRegion.getFirstRow()) {
                    // Retrieve merge area's content, set when necessary.
                    CellDO cell = PoiCellUtil.backup(sheet.getRow(mergedRegion.getFirstRow()).getCell(mergedRegion.getFirstColumn()));
                    needFix.add(cell);
                }
            } else {
                // Condition: deleteRowNum > mergedRegion.getLastRow()
                // Do noting.
            }
        }
        if (!removal.isEmpty()) {
            sheet.removeMergedRegions(removal);
        }
        merge.forEach(sheet::addMergedRegion);

        sheet.shiftRows(deleteRowNum + 1, lastRowNum + 1, -1);
        needFix.stream().map(PoiCellUtil::recovery).forEach(cell -> {
            final Cell target = sheet.getRow(cell.getRowIndex()).getCell(cell.getColumnIndex());
            PoiCellUtil.copyTo(cell, target);
        });
    }
}
