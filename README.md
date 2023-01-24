# AmazonAutomationTest

This project includes a basic flow automation of Amazon official website. 

## Prerequisites to setup project

- install and setup Java
- install and setup Maven
- Install an IDE

## Steps to run the code

- Clone the repository 
- Open the project in IDE
- Run the command 'maven clean install' to download and install all the dependencies
- To run the testcases -> right click on the TestNG.xml -> select run 

## Issues faced

- Faced difficulty in locating some elements as they were not having any unique id or name attribute. 

Workaround - try to find the xpath of the elements. For this install 'Chropath' browser extension and find xpath to uniquely loacte an element.

- In one step, it is needed to take the unitprice of the product and multiply it with the qtyunits_bought to find the totalprice. Here, the unitprice is extracted using getText() method as a String. 
Therefore, it needed to be converted to a Double variable, in order to perform desired calculation of multiplying by an integer value(qtyunits_bought). 

Workaround - First removed $ sign from the extracted string. Then, used Double.parseDouble() to convert the string value to a double.

- Observed that between some steps, there should be a wait time in order to load the page or elements.

Workaround - define an "implictWait=20" in config.properties file and used it in the test method.

- Parameterization test data.

workaround - There were two possible ways to parameterize tests. That is either using a xml or excel file.
first, study some website references on how to parameterize the test data. Then, created a mock class and got familiarized with it. 
Then applied it to the testclass.  
   

##Challenges
- an error was displayed on amazon product details page time to time. This is a sporadic issue and cannot recreate in manual navigation.
As a workaround, handle the timeout exception and print out a meaningful error message on the console.

##Things to further research on
- I was searching for a way to parameterize the xpath in order to select different 'review star' option and 'languages'.
Need more time to research on this further.


