package fi.binaryiris.matrix;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;


import android.view.View;

import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final protected int MAXMATRIXCELLFIELDCOUNT = 5;

    EditText[][] inputTexts = new EditText[MAXMATRIXCELLFIELDCOUNT][MAXMATRIXCELLFIELDCOUNT];
    EditText[][] resultTexts = new EditText[MAXMATRIXCELLFIELDCOUNT][MAXMATRIXCELLFIELDCOUNT];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        updateComponents();
    }

    // Does the elementary row interchange operation for the given rows
    protected void rowInterchange(int a, int b) {
        int cols = Integer.parseInt(((EditText)findViewById(R.id.resolutionColumns_EditTextNumber)).getText().toString());
        float[] tempArray = new float[cols];
        for (int i = 0; i < cols; i++) {
            // grab element from the row b to temp storage
            tempArray[i] = Float.parseFloat(inputTexts[b][i].getText().toString());
            inputTexts[b][i].setText((inputTexts[a][i].getText().toString()));
            inputTexts[a][i].setText(String.valueOf(tempArray[i]));
        }
    }

    // Does the elementary row multiply operation for the given row. 'a' as the multiplier and 'b' as the row index number
    protected void rowMultiply(float k, int b) {
        if ((b >= 0) && (b <= MAXMATRIXCELLFIELDCOUNT)) {
            int cols = Integer.parseInt(((EditText)findViewById(R.id.resolutionColumns_EditTextNumber)).getText().toString());
            for (int i = 0; i < cols; i++) {
                float f = k * Float.parseFloat((inputTexts[b][i].getText().toString()));
                inputTexts[b][i].setText(String.valueOf(f));
            }
        }
    }

    // Does the elementary row coefficient addition operation for the given row.
    // The function calculates a = a + bk
    protected void rowAddition(float k, int a, int b) {
        int cols = Integer.parseInt(((EditText)findViewById(R.id.resolutionColumns_EditTextNumber)).getText().toString());
        float bf[] = new float[cols];       // temporarily for row 'b'
        for (int i = 0; i < cols; i++) {
            bf[i] = Float.parseFloat(inputTexts[b][i].getText().toString()) * k + Float.parseFloat(inputTexts[a][i].getText().toString());
            inputTexts[a][i].setText(String.valueOf(bf[i]));
        }
    }

    // processClick is going to be executed after the click event on both buttons
    protected void processClick(View v) {
        if (R.id.computeButton == v.getId()) {
        } else if (R.id.clearButton == v.getId()) {
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++) {
                    inputTexts[i][j].setText("0");
                    resultTexts[i][j].setText("0");
                }
        }

        // refresh after any changes
        updateComponents();
        //rowInterchange(0, 4);
        rowAddition(-1, 1, 0);
        //rowMultiply(1.05f, 0);
    }


    // Grab data from the fields and place them to arrays.
    protected void initComponents() {
        // the worst way of doing things..
        // i bind the fields to an array for more efficient usage, here for the result text fields
        resultTexts[0][0] = (EditText) findViewById(R.id.outputr1c1_editTextNumber); resultTexts[1][0] = (EditText) findViewById(R.id.outputr2c1_editTextNumber);
        resultTexts[2][0] = (EditText) findViewById(R.id.outputr3c1_editTextNumber); resultTexts[3][0] = (EditText) findViewById(R.id.outputr4c1_editTextNumber);
        resultTexts[4][0] = (EditText) findViewById(R.id.outputr5c1_editTextNumber);

        resultTexts[0][1] = (EditText) findViewById(R.id.outputr1c2_editTextNumber); resultTexts[1][1] = (EditText) findViewById(R.id.outputr2c2_editTextNumber);
        resultTexts[2][1] = (EditText) findViewById(R.id.outputr3c2_editTextNumber); resultTexts[3][1] = (EditText) findViewById(R.id.outputr4c2_editTextNumber);
        resultTexts[4][1] = (EditText) findViewById(R.id.outputr5c2_editTextNumber);

        resultTexts[0][2] = (EditText) findViewById(R.id.outputr1c3_editTextNumber); resultTexts[1][2] = (EditText) findViewById(R.id.outputr2c3_editTextNumber);
        resultTexts[2][2] = (EditText) findViewById(R.id.outputr3c3_editTextNumber); resultTexts[3][2] = (EditText) findViewById(R.id.outputr4c3_editTextNumber);
        resultTexts[4][2] = (EditText) findViewById(R.id.outputr5c3_editTextNumber);

        resultTexts[0][3] = (EditText) findViewById(R.id.outputr1c4_editTextNumber); resultTexts[1][3] = (EditText) findViewById(R.id.outputr2c4_editTextNumber);
        resultTexts[2][3] = (EditText) findViewById(R.id.outputr3c4_editTextNumber); resultTexts[3][3] = (EditText) findViewById(R.id.outputr4c4_editTextNumber);
        resultTexts[4][3] = (EditText) findViewById(R.id.outputr5c4_editTextNumber);

        resultTexts[0][4] = (EditText) findViewById(R.id.outputr1c5_editTextNumber); resultTexts[1][4] = (EditText) findViewById(R.id.outputr2c5_editTextNumber);
        resultTexts[2][4] = (EditText) findViewById(R.id.outputr3c5_editTextNumber); resultTexts[3][4] = (EditText) findViewById(R.id.outputr4c5_editTextNumber);
        resultTexts[4][4] = (EditText) findViewById(R.id.outputr5c5_editTextNumber);

        // and for the input text fields

        inputTexts[0][0] = (EditText) findViewById(R.id.inputr1c1_editTextNumber); inputTexts[1][0] = (EditText) findViewById(R.id.inputr2c1_editTextNumber);
        inputTexts[2][0] = (EditText) findViewById(R.id.inputr3c1_editTextNumber); inputTexts[3][0] = (EditText) findViewById(R.id.inputr4c1_editTextNumber);
        inputTexts[4][0] = (EditText) findViewById(R.id.inputr5c1_editTextNumber);

        inputTexts[0][1] = (EditText) findViewById(R.id.inputr1c2_editTextNumber); inputTexts[1][1] = (EditText) findViewById(R.id.inputr2c2_editTextNumber);
        inputTexts[2][1] = (EditText) findViewById(R.id.inputr3c2_editTextNumber); inputTexts[3][1] = (EditText) findViewById(R.id.inputr4c2_editTextNumber);
        inputTexts[4][1] = (EditText) findViewById(R.id.inputr5c2_editTextNumber);

        inputTexts[0][2] = (EditText) findViewById(R.id.inputr1c3_editTextNumber); inputTexts[1][2] = (EditText) findViewById(R.id.inputr2c3_editTextNumber);
        inputTexts[2][2] = (EditText) findViewById(R.id.inputr3c3_editTextNumber); inputTexts[3][2] = (EditText) findViewById(R.id.inputr4c3_editTextNumber);
        inputTexts[4][2] = (EditText) findViewById(R.id.inputr5c3_editTextNumber);

        inputTexts[0][3] = (EditText) findViewById(R.id.inputr1c4_editTextNumber); inputTexts[1][3] = (EditText) findViewById(R.id.inputr2c4_editTextNumber);
        inputTexts[2][3] = (EditText) findViewById(R.id.inputr3c4_editTextNumber); inputTexts[3][3] = (EditText) findViewById(R.id.inputr4c4_editTextNumber);
        inputTexts[4][3] = (EditText) findViewById(R.id.inputr5c4_editTextNumber);

        inputTexts[0][4] = (EditText) findViewById(R.id.inputr1c5_editTextNumber); inputTexts[1][4] = (EditText) findViewById(R.id.inputr2c5_editTextNumber);
        inputTexts[2][4] = (EditText) findViewById(R.id.inputr3c5_editTextNumber); inputTexts[3][4] = (EditText) findViewById(R.id.inputr4c5_editTextNumber);
        inputTexts[4][4] = (EditText) findViewById(R.id.inputr5c5_editTextNumber);

    }

    // get the values from the 'dimension' fields and sets them to mach 'dimensionX' and 'dimensionY'
    // reads the dimension of the matrix and sets respective fields enabled or disabled
    private void updateComponents(){

        // grab dimension information from their fields
        int rows = Integer.parseInt(((EditText)findViewById(R.id.resolutionRows_EditTextNumber)).getText().toString());
        int cols = Integer.parseInt(((EditText)findViewById(R.id.resolutionColumns_EditTextNumber)).getText().toString());

        // if rows or columns are not in their boundaries, set 'rows' and 'cols to MAXCELLFIELDCOUNT and fix their respective field values
        if ((rows < 1) || (rows > MAXMATRIXCELLFIELDCOUNT)) {
            rows = MAXMATRIXCELLFIELDCOUNT;
            ((EditText) findViewById(R.id.resolutionRows_EditTextNumber)).setText(String.valueOf(MAXMATRIXCELLFIELDCOUNT));
        }
        if ((cols < 1) || (cols > MAXMATRIXCELLFIELDCOUNT)) {
            cols = MAXMATRIXCELLFIELDCOUNT;
            ((EditText) findViewById(R.id.resolutionColumns_EditTextNumber)).setText(String.valueOf(MAXMATRIXCELLFIELDCOUNT));
        }

        // runs over both the result and the input matrix, changes their bg colors depending their status (outside dimensions/inside dimensions)
        for (int i = 0; i < MAXMATRIXCELLFIELDCOUNT; i++)
            for (int j = 0; j < MAXMATRIXCELLFIELDCOUNT; j++) {
                if ((j < cols) && (i < rows)) {
                    // if the cell is enabled
                    inputTexts[i][j].setEnabled(true);
                    resultTexts[i][j].setEnabled(false);
                    inputTexts[i][j].getBackground().setColorFilter(Color.rgb(125, 125, 235), PorterDuff.Mode.SRC_ATOP);
                    resultTexts[i][j].getBackground().setColorFilter(Color.rgb(125, 125, 235), PorterDuff.Mode.SRC_ATOP);
                }
                else {
                    // if the cell is disabled
                    inputTexts[i][j].setEnabled(false);
                    inputTexts[i][j].getBackground().setColorFilter(Color.rgb(135, 135, 135), PorterDuff.Mode.SRC_ATOP);
                    resultTexts[i][j].getBackground().setColorFilter(Color.rgb(135, 135, 135), PorterDuff.Mode.SRC_ATOP);
                    resultTexts[i][j].setEnabled(false);
                    inputTexts[i][j].setText("0");
                    resultTexts[i][j].setText("0");
                }
            }
    }
}