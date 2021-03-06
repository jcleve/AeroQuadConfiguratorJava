package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.plotdrawer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class XYZPlotDrawerPanel extends JPanel
{
    private TimeSeries _xSeries = new TimeSeries("X");
    private TimeSeries _ySeries = new TimeSeries("Y");
    private TimeSeries _zSeries = new TimeSeries("Z");
    private boolean _xVisible = true;
    private boolean _yVisible = true;
    private boolean _zVisible = true;

    public XYZPlotDrawerPanel(final String sensorName)
    {
        init(sensorName);
    }

    private void init(final String sensorName)
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));

        final TimeSeriesCollection xTimeSeriesCollection = new TimeSeriesCollection(_xSeries);
        final TimeSeriesCollection yTimeSeriesCollection = new TimeSeriesCollection(_ySeries);
        final TimeSeriesCollection zTimeSeriesCollection = new TimeSeriesCollection(_zSeries);

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(sensorName, null, null, xTimeSeriesCollection, true, false, false);

        final XYPlot xyplot = (XYPlot) chart.getPlot();
        final ValueAxis valueaxis = xyplot.getDomainAxis();
        valueaxis.setFixedAutoRange(20000);
        valueaxis.setAxisLineStroke(new BasicStroke(3));
        xyplot.setDataset(1, yTimeSeriesCollection);
        final DefaultXYItemRenderer yItemRenderer = new DefaultXYItemRenderer();
        yItemRenderer.setBaseShapesVisible(false);
        xyplot.setRenderer(1, yItemRenderer);

        xyplot.setDataset(2, zTimeSeriesCollection);
        final DefaultXYItemRenderer zItemRenderer = new DefaultXYItemRenderer();
        zItemRenderer.setBaseShapesVisible(false);
        xyplot.setRenderer(2, zItemRenderer);

        final ChartPanel chartpanel = new ChartPanel(chart);
        chartpanel.setPreferredSize(new Dimension(0, 250));
        add(chartpanel);
    }

    public void addXValue(float xValue)
    {
        if (!_xVisible)
        {
            xValue = 0.0F;
        }
        _xSeries.addOrUpdate(new Millisecond(), xValue);
    }

    public void addYValue(float yValue)
    {
        if (!_yVisible)
        {
            yValue = 0.0F;
        }
        _ySeries.addOrUpdate(new Millisecond(), yValue);
    }

    public void addZValue(float zValue)
    {
        if (!_zVisible)
        {
            zValue = 0.0F;
        }
        _zSeries.addOrUpdate(new Millisecond(), zValue);
    }

    public void setXVisible(final boolean XVisible)
    {
        _xVisible = XVisible;
    }

    public void setYVisible(final boolean YVisible)
    {
        _yVisible = YVisible;
    }

    public void setZVisible(final boolean ZVisible)
    {
        _zVisible = ZVisible;
    }
}
