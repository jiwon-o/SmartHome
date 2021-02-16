//package com.appforest.smarthome;
//
//
//import android.graphics.Color;
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.content.ContextCompat;
//
//import com.github.mikephil.charting.charts.LineChart;
//import com.github.mikephil.charting.components.XAxis;
//import com.github.mikephil.charting.components.YAxis;
//import com.github.mikephil.charting.data.Entry;
//import com.github.mikephil.charting.data.LineData;
//import com.github.mikephil.charting.data.LineDataSet;
//import com.github.mikephil.charting.formatter.IFillFormatter;
//import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
//import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
//import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
//import com.github.mikephil.charting.utils.Utils;
//
//import java.util.ArrayList;
//
//public class UsageActivity extends AppCompatActivity {
//
//    private LineChart chart;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_stats);
//
//        // // Line chart style // //
//        {   // // Chart Style // //
//            chart = findViewById(R.id.chart_line);
//
//            // background color
//            chart.setBackgroundColor(Color.WHITE);
//
//            // disable description text
//            chart.getDescription().setEnabled(false);
//
//            // enable touch gestures
//            chart.setTouchEnabled(true);
//
//
//            chart.setDrawGridBackground(false);
//
//            // create marker to display box when values are selected
//            RangeMarkerView mv = new RangeMarkerView(this, R.layout.custom_marker_view);
//
//            // Set the marker to the chart
//            mv.setChartView(chart);
//            chart.setMarker(mv);
//
//            // enable scaling and dragging
//            chart.setDragEnabled(true);
//            chart.setScaleEnabled(true);
//
//            // force pinch zoom along both axis
//            chart.setPinchZoom(true);
//        }
//
//        final ArrayList<String> xLabel = new ArrayList<>();
//        xLabel.add("MON");
//        xLabel.add("TUE");
//        xLabel.add("WED");
//        xLabel.add("THR");
//        xLabel.add("FRI");
//        xLabel.add("SAT");
//        xLabel.add("SUN");
//
//        XAxis xAxis;
//        {   // // X-Axis Style // //
//            xAxis = chart.getXAxis();
//            xAxis.setLabelCount(7, true);
//            xAxis.setTextColor(Color.GRAY);
//            xAxis.setTextSize(11);
//            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//            xAxis.setDrawGridLines(false);
//            xAxis.setAxisLineColor(Color.WHITE);
//            chart.getAxisRight().setEnabled(false);
//            xAxis.setValueFormatter(new IndexAxisValueFormatter() {
//                @Override
//                public String getFormattedValue(float value) {
//                    return xLabel.get((int) value);
//                }
//            });
//
//        }
//
//        YAxis yAxis;
//        {   // // Y-Axis Style // //
//            yAxis = chart.getAxisLeft();
//            yAxis.setLabelCount(3, true);
//            yAxis.setTextColor(Color.GRAY);
//            yAxis.setTextSize(12);
//            yAxis.setAxisMaximum(80f);
//            yAxis.setAxisMinimum(0f);
//            yAxis.setGranularity(40f);
//            yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
//            yAxis.setDrawGridLines(true);
//            yAxis.setAxisLineColor(Color.WHITE);
//            chart.getAxisRight().setEnabled(false);
//        }
//
//        setData(7, 80);
//        chart.getLegend().setEnabled(false);
//
//        chart.animateXY(1000, 1000);
//
//        // don't forget to refresh the drawing
//        chart.invalidate();
//    }
//
//    private void setData(int count, float range) {
//
//        ArrayList<Entry> values = new ArrayList<>();
//
//        for (int i = 0; i < count; i++) {
//
//            float val = (float) (Math.random() * range);
//            values.add(new Entry(i, val, getResources()));
//        }
//
//        LineDataSet set1;
//
//        if (chart.getData() != null &&
//                chart.getData().getDataSetCount() > 0) {
//            set1 = (LineDataSet) chart.getData().getDataSetByIndex(0);
//            set1.setValues(values);
//            set1.notifyDataSetChanged();
//            chart.getData().notifyDataChanged();
//            chart.notifyDataSetChanged();
//        } else {
//
//            set1 = new LineDataSet(values, "");
//
//            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
//            set1.setCubicIntensity(0.2f);
//            set1.setDrawFilled(true);
//            set1.setDrawCircles(true);
//            set1.setDrawValues(!set1.isDrawValuesEnabled());
//            set1.setLineWidth(1.8f);
//            set1.setCircleRadius(4f);
//            set1.setCircleColor(Color.rgb(255, 35, 102));
//            set1.setHighLightColor(Color.GRAY);
//            set1.setColor(Color.rgb(255, 35, 102));
//            set1.setFillColor(Color.WHITE);
//            set1.setFillAlpha(100);
//            set1.setDrawHorizontalHighlightIndicator(false);
//
//            set1.setFillFormatter(new IFillFormatter() {
//                @Override
//                public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
//                    return chart.getAxisLeft().getAxisMinimum();
//                }
//
//            });
//
//            // set color of filled area
//            if (Utils.getSDKInt() >= 18) {
//                // drawables only supported on api level 18 and above
//                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
//                set1.setFillDrawable(drawable);
//            } else {
//                set1.setFillColor(Color.BLACK);
//            }
//
//            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
//            dataSets.add(set1); // add the data sets
//
//            // create a data object with the data sets
//            LineData data = new LineData(dataSets);
//
//            // set data
//            chart.setData(data);
//
//
//        }
//    }
//}
