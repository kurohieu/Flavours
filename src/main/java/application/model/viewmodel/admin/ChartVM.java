package application.model.viewmodel.admin;

import application.model.viewmodel.common.ChartDataVM;

import java.util.List;

public class ChartVM {


    private List<ChartDataVM> chartDataVMS;

    public List<ChartDataVM> getChartDataVMS() {
        return chartDataVMS;
    }

    public void setChartDataVMS(List<ChartDataVM> chartDataVMS) {
        this.chartDataVMS = chartDataVMS;
    }


}
