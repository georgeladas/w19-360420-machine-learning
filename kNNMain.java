import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{



    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label

          String PATH_TO_data = args[0];
            System.out.println(PATH_TO_data);

          List<DataPoint> fullDataSet = DataSet.readDataSet(PATH_TO_data);

          DataPoint dp = fullDataSet.get(32);
          DataPoint pd = fullDataSet.get(40);
            System.out.println(dp.getLabel());
            System.out.println(dp.getX());

          String printableX = Arrays.toString(dp.getX());
            System.out.println(printableX);





    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
    List<DataPoint> TestSet = DataSet.getTestSet(fullDataSet, 0.3);
    List<DataPoint> TrainingSet = DataSet.getTrainingSet(fullDataSet, 0.7);


    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)



    // TASK 4: write a new method in DataSet.java which takes as arguments two DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)

    System.out.println(DataSet.distanceEuc(dp,pd));

    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
    KNNClassifier classifier = new KNNClassifier(3); //will give 3 closest datapoints
    DataPoint[] nearestNeighbors = classifier.getNearestNeighbors(dp, dp.get(0)); //where dpa = the array list defined in task 1
      for(int j=0; j < nearestNeighbors.length; j++)
      {
        //printDataPoint(nearestNeighbors[j]);// commented out to speed up program
      }


    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.

      double[] arrayS = new double[1000];
    	double[] arrayP = new double[1000];
    	double[] arrayR = new double[1000];
    	double score;
    	double positiveScore;
    	double positiveMissed;

    	for (int p = 0; p<1000; p++)
    	{
    		int n = 0;
    		int q = 0;
    		int r = 0;
    		int i = 0;
    		for (int m = 0; m < fullDataSet.size(); m++)
    		{
    			DataPoint pointReset = fullDataSet.get(m);
    			pointReset.setTestOrTrain("");
    		}
    			test= DataSet.getTestSet(fullDataSet, 0.2);
    			train= DataSet.getTrainingSet(fullDataSet, 0.8);

    				for (int j = 0; j < test.size(); j++)
    				{
    					DataPoint pointX = test.get(j);
    					KNNClassifier K = new KNNClassifier(4);
    					String predictionX = K.predict(train, pointX);

    					if (predictionX.equals(pointX.getLabel()))
    					{
    						n++;		// success rate
    						if (predictionX.equals("malignant"))
    						{
    							q++;		// true positive counter
    						}
    					}
    					if (predictionX.equals("malignant"))
    					{
    						r++;		// total positives assigned
    					}
    					if (pointX.getLabel().equals("malignant"))
    					{
    						i++;
    					}
    				}
    		score = (n*100)/test.size();
    		arrayS[p] = score;
    		positiveScore = q*100/r;
    		arrayP[p] = positiveScore;
    		positiveMissed = q*100/i;
    		arrayR[p] = positiveMissed;

    	}
    	double scoreAverage = mean(arrayS);
    	double scoreDev = standardDeviation(arrayS);
    	double positiveAverage = mean(arrayP);
    	double positiveDev = standardDeviation(arrayP);
    	double missedAverage = mean(arrayR);
    	double missedDev = standardDeviation(arrayR);

    	System.out.println("\n\nTask 6:\n______________________________________\n");
    	System.out.println("Total average score after 1000 runs = " + scoreAverage + "%");
    	System.out.println("Standard deviation = " + scoreDev + "%");
    	System.out.println("\nAverage precision = " + positiveAverage + "%");
    	System.out.println("Standard deviation = " + positiveDev + "%");
    	System.out.println("\nAverage recall = " + missedAverage + "%");
    	System.out.println("Standard deviation = " + missedDev + "%");

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }
}
}
