package id.frogobox.mpchartbatang;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // ---------------------------------------------------------------------------------------------
    private BarChart chart;
    private ArrayList<BarEntry> barEntries;
    private ArrayList<String> barLabels;
    private BarDataSet barDataSet;
    private BarData barData;
    // ---------------------------------------------------------------------------------------------

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // -----------------------------------------------------------------------------------------
        chart = (BarChart) findViewById(R.id.chart_id); // Diagram Batang
        YAxis leftAxis = chart.getAxis(YAxis.AxisDependency.LEFT); // Inisiasi Sumbu Y kiri
        YAxis rightAxis = chart.getAxis(YAxis.AxisDependency.RIGHT); // Inisiasi Sumbu Y kanan
        XAxis xAxis = chart.getXAxis(); // Inisiasi Sumbu X
        // -----------------------------------------------------------------------------------------
        barEntries = new ArrayList<>();
        barLabels = new ArrayList<>();

        float posX[] = {0,1,2,3,4,5,6,7,8,9,10};
        float posY[] = {20,40,20,60,80,40,100,60,100,60,80};
        String label[] = {"CEK","CEK","CEK","CEK","CEK","CEK","CEK","CEK","CEK","CEK","CEK"};

        for (int i=0; i <= posX.length-1; i++ ) {
            barEntries.add(new BarEntry(posX[i], posY[i]));
            barLabels.add(label[i]);
            barDataSet = new BarDataSet(barEntries, "Poin Shalat");
            barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        }

        barData = new BarData(barDataSet);

        CreateBarChart(chart, xAxis, leftAxis, rightAxis, barData, barLabels);

    }


    public void CreateBarChart(BarChart mBarchart, XAxis mXAxis, YAxis mLeftAxis, YAxis mRightAxis, BarData mBarData, ArrayList<String> mBarLabels){
        mBarchart.setData(mBarData);
        // -----------------------------------------------------------------------------------------
        mBarchart.setScaleEnabled(false);
        mBarchart.getDescription().setEnabled(false);
        mBarchart.animateY(2000);
        mBarchart.setVisibleXRange(1,7);
        mBarchart.setVisibleYRange(20,100,YAxis.AxisDependency.LEFT);
        // -----------------------------------------------------------------------------------------
        // Sumbu X
        mXAxis.setValueFormatter(new IndexAxisValueFormatter(mBarLabels));
        mXAxis.setEnabled(true);
        mXAxis.setDrawGridLines(false);
        mXAxis.setTextSize(6f);
        mXAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // -----------------------------------------------------------------------------------------
        // Garis Bagian Kanan
        mRightAxis.setDrawAxisLine(false);
        mRightAxis.setDrawGridLines(false);
        mRightAxis.setDrawLabels(false);
        // -----------------------------------------------------------------------------------------
        // Garis Bagian Kiri
        mLeftAxis.setDrawGridLines(false);
        mLeftAxis.setLabelCount(5);
        mLeftAxis.setAxisMinimum(0);
        mLeftAxis.setAxisMaximum(100);
        // -----------------------------------------------------------------------------------------
    }

}
