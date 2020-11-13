# HW10 EMR / Hadoop

For this problem we will use AWS EMR to build a cluster that we can access Hadoop through, and run MapReduce jobs. We will run a common wordcount on a large text file.

## Step 1
Download the ```100-0.txt.zip``` file and extract the ```100-0.txt``` data file we will use for this exercise, the complete works of William Shakespeare in a single txt file.

## Step 2
Generate an EMR cluster with a Core Hadoop installation that you can SSH into directly.

![Screenshot](img/img_2.png?raw=true "Screenshot")

## Step 3
SSH into your master, using ```hadoop``` as the user, to upload (scp) and execute the ```WordCount.java``` program.

![Screenshot](img/img_1.png?raw=true "Screenshot")

## Step 4
Share the first 20 lines of results from your first output file. 

```
[hadoop@ip-172-31-23-192 ~]$ hadoop fs -cat /output/part-r-00000 | head -20 &C. 3
'Alas, 1
'And 9
'Art 1 'But,1 'Clarence 1 'Dear3
'Do 1
'Edward 1 'Fair1 'Greensleeves.' 1 'Hath1
'His 1
'In 3
'Item: 19 'Jockey 1 'Light 1 'Lord1
'Make1
'Marcius, 1
```
