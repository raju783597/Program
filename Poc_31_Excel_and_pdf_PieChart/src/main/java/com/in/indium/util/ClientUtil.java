package com.in.indium.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ClientUtil {
	public void generatePieChart(String location,List<Object[]>list) {
		
		//create data set and read list<object[]> in to datasret value
		DefaultPieDataset dataset =new DefaultPieDataset();
		for(Object[] ob:list) {
			//key cname  value =count number
			dataset.setValue(ob[0].toString(),Double.valueOf(ob[1].toString()));
		}
	
	// convert dataset data in to jfreechart
	JFreeChart chart = ChartFactory.createPieChart3D("NUMBER OF COMPANY ON PIE CHART", dataset);	
	
	//convert jfree chart in to oneImage  using chartutil
	try {
			ChartUtils.saveChartAsJPEG(new File(location+"/companyNameA.jpg"), chart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void generateBarChart(String location,List<Object[]>list) {
	// create data set
	DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	for (Object[] ob : list) {
		// ridetype--->>value
		dataset.setValue(Integer.valueOf(ob[1].toString()),ob[0].toString(),"");
	}
	//jfree
	// convert dataset data in to jfreechart                                            //Y-AXIS
	JFreeChart chart = ChartFactory.createBarChart("NUMBER OF COMPANY ON BAR CHART","COMPANY NAME ","COUNT",dataset);
	
	try {
		ChartUtils.saveChartAsJPEG(new File(location +"/companyNameB.jpg"), chart, 400, 300);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}   

}
