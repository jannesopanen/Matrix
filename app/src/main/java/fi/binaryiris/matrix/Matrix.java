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
    private int mMatRows;
    private int mMatColumns;
    private int[][] mData;

    // default constructor, default hardcoded values are used
    public Matrix() {

    }

    public Matrix(int rowCount, int columnCount, EditText[][] inputEditTexts) {
        if (rowCount <= MAXROWS) this.mMatRows = rowCount;
        else this.mMatRows = DEFAULTROWCOUNT;
        if (columnCount <= MAXCOLUMNS) this.mMatColumns = columnCount;
        else this.mMatColumns = DEFAULTCOLUMNCOUNT;
        mData = new int[mMatRows][mMatColumns];
        for (int i = 0; i < mMatColumns; i++) {
            for (int j = 0; j < mMatRows; j++) {
                inputEditTexts[i][j].setText(String.valueOf(i) + "!" + String.valueOf(j));
            }
        }
    }
    // overload, data input using int array
    public Matrix(int rowCount, int columnCount, int[][] inputCells) {

    }

    // return the count of the rows
    public int getmMatRows() {
        return this.mMatRows;
    }

    // return the count of columns
    public int getmMatColumns() {
        return this.mMatColumns;
    }

    public int readCell(int rowCount, int columnCount)
    {
        return this.mData[rowCount][columnCount];
    }
}
