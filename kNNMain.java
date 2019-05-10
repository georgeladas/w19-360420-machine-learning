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
    List<DataPoint> TestSet = DataSet.getTestSet(fullDataSet, 0.2);
    List<DataPoint> TrainingSet = DataSet.getTrainingSet(fullDataSet, 0.8);


    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)



    // TASK 4: write a new method in DataSet.java which takes as arguments two DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)

    System.out.println(DataSet.distanceEuc(dp,pd));

    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label



    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.


  }

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
