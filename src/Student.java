
/**Course: MAD204 - Java Development
 * Lab 1
 * Student Name: Ashishkumar Prajapati
 * Student ID: A00194842
 * Date: September 21, 2025
 *
 * Description:
 * This class models a Student with an id, name, and grades.
 * It supports setting grades, computing averages, and generating letter grades. */



public class Student {
    private String name;
    private int id;
    private double[] grades;


public Student(int id, String name){
    this.id=id;
    this.name =name;
    this.grades= new double[5];  //each student has 5 grade
}
 public void setGrade(int index, double value){
    if(index>=0 && index<grades.length){
        grades[index]= value;
    }
 }
 //compute average grades
public double average(){
    double sum = 0;
    for (double g : grades){
        sum += g;
    }
    retur sum/grades.length;
}

public char letterGrade(){
    double avg=average();
    if (avg >=90) return 'A';
    else if (avg >=80)  return 'B';
    else if (avg >=70) return 'C';
    else if (avg >=60) return 'D';
    else return 'F';
    }


@Override
public String toString(){
    return "ID:"+ id +",Name:"+ name +
            ", Avg:"+ String.format("%.2f", average())+
            "("+letterGrade()+")";
}

public String getName(){ return name;}
public int getId(){ return id; }
}
