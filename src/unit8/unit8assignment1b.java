package unit8;

import java.util.Scanner;

import org.jfree.chart.ChartFactory; 

public class unit8assignment1b extends JFrame {
	initUI(); // set up the chart window, constructor 

}

// create dataset, chart, panel, and window, user interface
private void initUI() {
	
	 // get data ready in a format JFreeChart understands
    CategoryDataset dataset = createDataset();
    
    JFreeChart chart = createChart(dataset);
    ChartPanel chartPanel = new ChartPanel(chart);
    
    // styling 
    chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    chartPanel.setBackground(Color.white);
    add(chartPanel);
    
    pack(); // resizes window
    
    setTitle("Bar chart");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    try {
        ChartUtils.saveChartAsPNG(new File("U8_A1.png"), chart, 1000, 600);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

	public String [] [] getMyData () {
		String [][] csvArray = null; 
		
		try {
			
			// opens file
			Scanner csvData = new Scanner (new File("C:\\Users\\enzuo_8i6f2u6\\OneDrive\\Documents\\Purdue\\IN300\\csv\\Average_Daily_Traffic_Counts.csv")); 
			
			
			// reads the file until the end 
			ArrayList<String> list = new ArrayList<String>(); 
			while (csvData.hasNext()) {
				list.add(csvData.nextLine());
			}
			
			// convert to normal string  array 
			String[] tempArray = list.toArray(new String[1]); 
			csvArray = new String [tempArray.length][]; 
			
			// split each line into comma separated values 
			for (int i=0; i < tempArray.length; i++) {
				csvArray[i] = tempArray[i].split(","); 
			}
			csvData.close(); 
		}
		catch (Exception ex) {System.out.println(ex);
		
		}
		// return the completed 2d table of data 
		return csvArray; 
		}
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}