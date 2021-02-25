package com.appforest.smarthome;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toolbar;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

public class StatsFragment extends Fragment {

    Toolbar myToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private LineChart chart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats, container, false);


        ListView listview;
        StatsListViewAdapter adapter;

        // Adapter 생성
        adapter = new StatsListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) view.findViewById(R.id.listView);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_tv),
                "TV", "6.2 kw", "$0.90");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_aircon),
                "A/C", "5.5 kw", "$0.85");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_speaker),
                "Speaker", "2.7 kw", "$0.50");

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_washing),
                "Washer", "4.0 kw", "$0.69");

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_fan),
                "Fan", "1.6 kw", "$0.32");

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_refrigerator),
                "Fridge", "5.1 kw", "$0.72");

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_oven),
                "Oven", "3.7 kw", "$0.52");


        setHasOptionsMenu(true);


        {   // // Chart Style // //
            chart = view.findViewById(R.id.chart_line);

            // background color
            chart.setBackgroundColor(Color.rgb(248, 248, 247));

            // disable description text
            chart.getDescription().setEnabled(false);

            // enable touch gestures
            chart.setTouchEnabled(true);


            chart.setDrawGridBackground(false);

            // create marker to display box when values are selected
            UsageMarkerView mv = new UsageMarkerView(getActivity(), R.layout.custom_marker_view);

            // Set the marker to the chart
            mv.setChartView(chart);
            chart.setMarker(mv);

            // enable scaling and dragging
            chart.setDragEnabled(true);
            chart.setScaleEnabled(true);

            // force pinch zoom along both axis
            chart.setPinchZoom(true);
        }

        final ArrayList<String> xLabel = new ArrayList<>();
        xLabel.add("MON");
        xLabel.add("TUE");
        xLabel.add("WED");
        xLabel.add("THR");
        xLabel.add("FRI");
        xLabel.add("SAT");
        xLabel.add("SUN");

        XAxis xAxis;
        {   // // X-Axis Style // //
            xAxis = chart.getXAxis();
            xAxis.setLabelCount(7, true);
            xAxis.setTextColor(Color.BLACK);
            xAxis.setTextSize(11);
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setDrawGridLines(false);
            xAxis.setAxisLineColor(Color.rgb(248, 248, 247));
            chart.getAxisRight().setEnabled(false);
            xAxis.setValueFormatter(new IndexAxisValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    return xLabel.get((int) value);
                }
            });

        }

        YAxis yAxis;
        {   // // Y-Axis Style // //
            yAxis = chart.getAxisLeft();
            yAxis.setLabelCount(3, true);
            yAxis.setTextColor(Color.BLACK);
            yAxis.setTextSize(12);
            yAxis.setAxisMaximum(20f);
            yAxis.setAxisMinimum(0f);
            yAxis.setGranularity(10f);
            yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
            yAxis.setDrawGridLines(false);
            yAxis.setAxisLineColor(Color.rgb(248, 248, 247));
            chart.getAxisRight().setEnabled(false);
        }

        setData(7, 15);
        chart.getLegend().setEnabled(false);

        chart.animateXY(1000, 1000);

        // don't forget to refresh the drawing
        chart.invalidate();

        return view;



    }

    // // Set data of line chart
    private void setData(int count, float range) {

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            float val = (float) (Math.random() * range);
            values.add(new Entry(i, val, getResources()));
        }

        LineDataSet set1;

        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            set1.notifyDataSetChanged();
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {

            set1 = new LineDataSet(values, "");

            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set1.setCubicIntensity(0.2f);
            set1.setDrawFilled(true);
            set1.setDrawCircles(true);
            set1.setDrawValues(!set1.isDrawValuesEnabled());
            set1.setLineWidth(1.6f);
            set1.setCircleRadius(5f);
            set1.setCircleHoleRadius(2.5f);
            set1.setCircleColor(Color.argb(70, 243, 182, 61));
            set1.setCircleHoleColor(Color.rgb(243, 182, 61));
            set1.setColor(Color.rgb(255, 192, 68));
            set1.setFillColor(Color.rgb(248, 248, 247));
            set1.setFillAlpha(100);
            set1.setDrawHorizontalHighlightIndicator(false);

            set1.setFillFormatter(new IFillFormatter() {
                @Override
                public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                    return chart.getAxisLeft().getAxisMinimum();
                }

            });

            // set color of filled area
            if (Utils.getSDKInt() >= 18) {
                // drawables only supported on api level 18 and above
                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_yellow);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.BLACK);
            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the data sets

            // create a data object with the data sets
            LineData data = new LineData(dataSets);

            // set data
            chart.setData(data);


        }
    }


}