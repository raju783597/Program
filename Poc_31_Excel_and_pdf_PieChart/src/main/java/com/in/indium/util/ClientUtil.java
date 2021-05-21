package com.in.indium.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ClientUtil {
	//pie chart
	public void generatePieChart(String location,List<Object[]>list) {

		//create data set and read list<object[]> to datasret value
		DefaultPieDataset dataset =new DefaultPieDataset();
		for(Object[] ob:list) {
			//key 1companyname  2value =count number
			dataset.setValue(ob[0].toString(),Double.valueOf(ob[1].toString()));
		}

		// convert dataset data in to jfreechart in 3d
		//ChartFactory is class in which createPieChart3D ("",dataset) which take value and convert in to pie chart
		JFreeChart chart = ChartFactory.createPieChart3D("NUMBER OF COMPANY ON PIE CHART", dataset);	

		 
		try {
			/*
			  converting charts to image formats (PNG and JPEG) plus creating simple HTML
			  image maps.using chartutil
			 */
			ChartUtils.saveChartAsJPEG(new File(location+"/companyNameA.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	//bar chart
	public void generateBarChart(String location,List<Object[]>list) {
		
		// DefaultCategoryDataset is a class which implement CategoryDataset 
		//and   create data set
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		//fatching data one by one from list
		for (Object[] ob : list) {
			/*
			 * ridetype--->>value Number value, 
			 *  setValue(Number value, Comparable rowKey, Comparable columnKey)
			 */
			dataset.setValue(Integer.valueOf(ob[1].toString()),ob[0].toString(),"");
		}
		/*
		 * convert dataset data in to barchart   Y-AXIS
		 * createBarChart(title, categoryAxisLabel, valueAxisLabel, dataset)		 
		 */
		JFreeChart chart = ChartFactory.createBarChart("NUMBER OF COMPANY ON BAR CHART","COMPANY NAME ","COUNT",dataset);

		try {
			/*
			  converting charts to image formats (PNG and JPEG) plus creating simple HTML
			  image maps.using chartutil
			 */
			ChartUtils.saveChartAsJPEG(new File(location +"/companyNameB.jpg"), chart, 400, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}   

}
