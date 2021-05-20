package com.in.indium.utill;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class PersionDetailUtility {
	public void generatePiChart(String location, List<Object[]> list) {

		// create data set
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : list) {
			// ridetype--->>value
			dataset.setValue(ob[0].toString(), Double.valueOf(ob[1].toString()));
		}
			// convert dataset data in to jfreechart
			JFreeChart chart = ChartFactory.createPieChart3D("PERSION PICK UPLOCATION", dataset);

			// convert jfreechart into one image
			try {
				ChartUtils.saveChartAsJPEG(new File(location +"/persiondetailA.jpg"), chart, 400, 400);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		

	}

	public void generateBarChart(String location, List<Object[]> list) {
		// create data set
				DefaultCategoryDataset dataset=new DefaultCategoryDataset();
				for (Object[] ob : list) {
					// ridetype--->>value
					dataset.setValue(Double.valueOf(ob[1].toString()),ob[0].toString(),"");
				}
		//jfree
				// convert dataset data in to jfreechart                                            //Y-AXIS
				JFreeChart chart = ChartFactory.createBarChart("PICK UP LOCATION","PICKUP LOCATION","COUNT",dataset);
				
				try {
					ChartUtils.saveChartAsJPEG(new File(location +"/persiondetailB.jpg"), chart, 400, 300);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
	}

}
