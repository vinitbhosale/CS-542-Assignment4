# CSX42: Assignment 4
**Name:Vint Surendra Bhosale** 

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [arrayvisitors/src](./arrayvisitors/src/) folder.

## Instruction to clean:

```commandline
ant -buildfile arrayvisitors/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile arrayvisitors/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile arrayvisitors/src/build.xml run -Dinput1="input1.txt" -Dinput2="input2.txt" -Dcommonintsout="commonintsout.txt" -Dmissingintsout="missingintsout.txt" -Ddebug="debugValue"
```
Note: Arguments accept the absolute path of the files.


## Description:
1. Assumption:
- Format of line in input file should be as given format: positive 2 digit integer in each line.
- Integer in input file should be in range 00-99.
- Order of input arguments to run command is input1.txt, input2.txt, commonintsout.txt, missingintsout.txt
  and debugValue.
- No two input file and two output file can have the same name.

2. Data structures:
- String are used to append the results that need to display.
- ArrayList are used to store array objects.
- Array is used to store 2 digit positive integer.

3. Code working:
- Input file is set first in PopulatMyArrayVisitor and MyArray obj is created to store the integer of the
  input file.
- MyArray object accept PopulatMyArrayVisitor and from accept of MyArray it visits the visit method of 
  PopulatMyArrayVisitor where it read input file line by line and store the integers in MyArray.
- Simultaneously MyArray object for each input file in store in Arraylist defined in MyArrayList class.
- Once all integers are populated in their respective arrays, MyArrayList object acccepts CommonIntsVisitor.
- From accept of MyArrayList class it visits the visit method of CommonIntsVisitor and search for commom
  intgers from the two arrays and store those in Results.
- After finding common integers MyArrayList object again accepts MissingIntVisitors where from MyArrayList
  accept the control goes to MissingIntVisitors visit method were it loops through the array list of 
  MyArray objects and again accepts MissingIntVisitors visitor and visit MyArray visit method.
- Then at MissingIntVisitors visits method it search for missing integers in respective array and store 
  those missing integers in Results.
- At the end stored Results are printed on StdOut and in respective output file.

4. Note:
- I have used 1 slack day from my 4 slack days.


## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 07/23/2020
