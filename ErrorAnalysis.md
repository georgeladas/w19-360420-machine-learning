# Machine Learning
## Intro to Computer - Section 03
## George Ladas and Gabriel Sabatino

## Distributions of Model Accuracy

When we run the code, we are getting 30% of the test set which consists of randomly assigned data. Each time an iteration occurs, the data points from the list are shuffled; the test set is constantly being cut through each iteration, which impacts the overall accuracy of our results.

Mean Accuracy: 96.42823938197% standard Deviation: 1.193839233273491 (After 1000 loops)

If we were to assume that a program randomly assigned its results, its accuracy would be 50%. If a program would assume all values to be benign, it would have a 65.19% accuracy rate. Sensible baseline: 35% malignant and 65% benign.
## Analysis of different error types

False positive: When the initial hypothesis is for a positive result, however the outcome is negative.
False negative: When the initial hypothesis is for a negative result, however the outcome is positive.

Precision: Precision is the accuracy of what was initially predicted (correctly predicted malignant over total amount of predicted malignant individuals)

Recall: Recall returns the correct amount of predictions over the total number of individuals (correctly predicted malignant over actual malignant individuals)

A good baseline for either would be 1.

The hyperparameter k indicates the amount of closest neighbors that we want to look at. We noticed that as we increased our k parameter, the precision also increased, however recall was sacrificed. 
