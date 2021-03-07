import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LexicalAnalyzer {
  String[] keywordArray = {"int","double","float","String","if","else"};
  String[] keywordArray2 = {"int","double","float","String"};
  String[] math_op = {"=","+","-","*","/","%"};
  String[] logical_op = {"<",">","<=",">="};
  String[] other = {",",";","(",")","{","}"};
  String keywords="";
  String identifier="";
  String math_operators="";
  String logical_operators="";
  String numerical_values="";
  String others="";
  int arrCount=0;
  public void analyze(){
    try{
      File  file = new File("G:\\Spring21\\CSE420\\LAB\\Lab1\\input.txt");
      Scanner sc= new Scanner(file);
      
      while (sc.hasNextLine()){
        String ongoingLine = sc.nextLine();
        String[] ongoingLineArray2 = ongoingLine.split(" ");
        
        if(Arrays.asList(keywordArray).contains(ongoingLineArray2[0])){
            addkeyword(ongoingLineArray2[0]);
        }
        
        if(Arrays.asList(keywordArray2).contains(ongoingLineArray2[0])){
        	arrCount++;
            for(int i=1;i<ongoingLineArray2.length;i++){
              addIdentifier(ongoingLineArray2[i], i, ongoingLineArray2.length-1);
          }
        }
        
        for(int i = 1; i < ongoingLineArray2.length - 1; i++){
          if(Arrays.asList(math_op).contains(ongoingLineArray2[i])){
            addOperator(ongoingLineArray2[i]);
          }
        }

        for(int i = 1; i < ongoingLineArray2.length - 1; i++){
          if(Arrays.asList(logical_op).contains(ongoingLineArray2[i])){
            addLogical(ongoingLineArray2[i]);
          }
        }
        
        for(int i = 0; i < ongoingLineArray2.length; i++){
          boolean flag = false;
          int decimal_count = 2;
          if(ongoingLineArray2[i].charAt(0) >= 48 && ongoingLineArray2[i].charAt(0) <= 57){
            flag = true;
            decimal_count = 0;
            for(int j = 1; j < ongoingLineArray2[i].length(); j++){
              if(ongoingLineArray2[i].charAt(j) == '.'){
                decimal_count++;
              }
              if(!((ongoingLineArray2[i].charAt(j) >= 48 && ongoingLineArray2[i].charAt(j) <= 57))){
                flag=false;
                break;
              }
            }
          }
          if(flag == true || decimal_count <= 1){
            addNumber(ongoingLineArray2[i]);
          }
        }
        
        for(int i = 0; i < ongoingLineArray2.length; i++){
            String temp = ongoingLineArray2[i];
            for(int j = 0; j < temp.length(); j++){
                String str = Character.toString(temp.charAt(j));
                if(Arrays.asList(other).contains(str)){
                    addOthers(str);
                }
            }
        }
      }
      
      System.out.println("Keywords: "+keywords);
      System.out.println("Identifier: "+identifier);
      System.out.println("Math Operators: "+math_operators);
      System.out.println("Logical Operators: "+logical_operators);
      System.out.println("Numercial Values: "+numerical_values);
      System.out.println("Others: "+others);
    }

    catch (Exception ex){
      System.out.println(ex);
    }
  }
  
  public void addkeyword(String word){
    
    if(!keywords.contains(word)){
      if(keywords.equals("")){
        keywords = word;
      }
      else{
        keywords = keywords+","+word;
      }
    }
  }
  
  public void addIdentifier(String word, int index, int len){
    String temp_identifier = identifier + word;
    if(index != arrCount){
      identifier = temp_identifier.replace(';',',');
    }
    else{
      identifier = temp_identifier.replace(';',' ');
    }
  }
  public void addOperator(String word){
    if(!math_operators.contains(word)){
      if(math_operators.equals("")){
        math_operators = word;
      }
      else{
        math_operators = math_operators+", "+word;
      }
    }
  }
  public void addLogical(String word){
    if(!logical_operators.contains(word)){
      if(logical_operators.equals("")){
        logical_operators = word;
      }
      else{
        logical_operators = logical_operators+", "+word;
      }
    }
  }
  public void addNumber(String word){
    word = word.replace(";","");
    if(!numerical_values.contains(word)){
      if(numerical_values.equals("")){
        numerical_values = word;
      }
      else{
        numerical_values = numerical_values+", "+word;
      }
    }
  }
  public void addOthers(String word){
    if(!others.contains(word)){
      others = others+word;
    }
  }
}