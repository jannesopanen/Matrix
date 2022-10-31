// This class holds the information of n x m matrix, each cell with a float value. There are two methods, both will simplify the matrix to either the row echelon form
// or row reduced echelon form.
// For RREF form, the Gauss-Jordan algorithm is used and for the REF form, the Gaussian algorithm is used.
// To get a matrix to the RREF form, Gaussian algorithm is first used to bring it to REF form.


package fi.binaryiris.matrix;
import android.widget.EditText;

public class Matrix {
// hard boundaries
final protected int MAXROWS = 10;
final protected int MAXCOLUMNS = 10;
final protected int DEFAULTCOLUMNCOUNT = 5;
final protected int DEFAULTROWCOUNT = 5;

// member variables
private int matRows;
private int matColumns;
private int[][] data;

    // default constructor. if the given dimension fails, the hardcoded MAX values are used
    public Matrix(int rowCount, int columnCount, EditText[][] inputEditTexts) {
        if (rowCount <= MAXROWS) this.matRows = rowCount; else this.matRows = DEFAULTROWCOUNT;
        if (columnCount <= MAXCOLUMNS) this.matColumns = columnCount; else this.matColumns =  DEFAULTCOLUMNCOUNT;
        data = new int[matRows][matColumns];

        for (int i = 0; i < matColumns; i++) {
            for (int j = 0; j <  matRows; j++) {
                inputEditTexts[i][j].setText(String.valueOf(i)+"!"+String.valueOf(j));
            }
        }

    }

    // return the count of the rows
    public int getMatRows() {
        return this.matRows;
    }

    // return the count of columns
    public int getMatColumns() {
        return this.matColumns;
    }

    public int readCell(int rowCount, int columnCount)
    {
        return this.data[rowCount][columnCount];
    }
}
