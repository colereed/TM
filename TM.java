import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TM{
   private int Result = 0;
   private int time;
   private String description;
   private String timeStart;
   private String timeStop;

   private String startTask(String taskName){
   //Grab time;  
      timeStart = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
      String logLine = timeStart + " -Start " + taskName + "\r\n";
      try{
         Files.write(Paths.get("./TM.txt"), logLine.getBytes(), StandardOpenOption.APPEND);
      }
      catch (IOException e) {
      }
      System.out.println(logLine = "timeStart: " + timeStart + "\n" + 
         "command: " + "-Start" + "\n" + 
         "taskName: " + taskName);
      return timeStart;
   }

   private String describeTask(String taskName, String description, String size) {
   //Ask the user for a description of their task.
      String a = "No size given.";
      if(size.equals(""))
         size = a;
      String logDescription = description;
      logDescription = "\"" + description + "\" " + "\n-describeTask\n " + taskName + " \n " + size  + " \r\n";
      System.out.println("description:" + " \"" + description + "\" \n" +
                         "command: " + "describeTask" + "\n"+
                         "taskName: " + taskName + "\n"+
                         "Size: " + size);

      try{
         Files.write(Paths.get("./TM.txt"), logDescription.getBytes(), StandardOpenOption.APPEND);
      }
      catch (IOException e) {
      }
      return logDescription;
   }

   private String stopTask(String taskName){
   //grab time of stop
      timeStop = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
      String logLine = timeStop + " -Stop " + taskName + "\r\n";
      try{
         Files.write(Paths.get("./TM.txt"), logLine.getBytes(), StandardOpenOption.APPEND);
      }
      catch (IOException e) {
      }
      System.out.println(logLine = "timeStop: " + timeStop + "\n" + 
         "command: " + "-Stop" + "\n" + 
         "taskName: " + taskName);
      return timeStop;
   }

   private int timeResult(String timeStart, String timeStop) {
      int[] teststart = {0,0,0,0,0,0};
      String s = timeStart;
      int c = 11;
      for(int i = 0; i <=5; i++){
         teststart[i]= s.charAt(c)-'0';
         if(c== 12)
            c++;
         if(c== 15)
            c++;
         c++;
         System.out.print(teststart[i]);
      }
      System.out.println();
   
      int[] teststop = {0,0,0,0,0,0};
      String t = timeStop;
      int d = 11;
      for(int j = 0; j <=5; j++){
         teststop[j]= t.charAt(d)-'0';
         if(d== 12)
            d++;
         if(d== 15)
            d++;
         d++;
         System.out.print(teststop[j]);
      }
      System.out.println();
   
      int timeDifference[] = {0,0,0,0,0,0};
      for(int k=0; k <= 5; k++){
         int tmpStart = teststart[k];
         int tmpStop = teststop[k];
         time = tmpStop - tmpStart;
         if(time < 0){
            time += 10;
            timeDifference[k-1] -= 1;
         }
         timeDifference[k] = time;
      }
      System.out.print("Duration: ");
      for(int l = 0; l <=5; l++){
         System.out.print(timeDifference[l]);
         if(l == 1 || l == 3)
            System.out.print(":");
      }
      return Result;
   }
   
   public String sizeTask(String taskName, String size){
      String newSize = taskName + ": " + size;
      try{
         Files.write(Paths.get("./TM.txt"), newSize.getBytes(), StandardOpenOption.APPEND);
      }
      catch (IOException e) {
      }
      System.out.println(newSize);
      return size;
   }

   public void printTask(String taskName){
      String t = taskName;
      String u = "Start";
      String v = "Stop";
      String w = "describeTask";
      String x = "Size";
      String a = "";
      String b = "";
      String d = "";
      String f = "";
      try{
         File file =
               new File("C:\\Users\\wcole\\Documents\\CScWork\\131\\src\\TM.txt");
         Scanner sc = new Scanner(file);
         while (sc.hasNextLine()){
            String c = sc.nextLine();
            if(c.contains(t) && c.contains(u))
               a = sc.nextLine();
               //System.out.println(c);
            if(c.contains(t) && c.contains(v))
               b = sc.nextLine();
               //System.out.println(c);
            if(c.contains(t) && c.contains(w))
               d = sc.nextLine();
               //System.out.println(c);
            if(c.contains(t) && c.contains(x))
               f = sc.nextLine();
               //System.out.println(c);
         }
         System.out.println(t);
         System.out.println(u);
         System.out.println(v);
         System.out.println(w);
         System.out.println(x);
      }
      catch (IOException e)
      {  // do something
         e.printStackTrace();
      }
   }
   public int getTimeOfTask(String task){
      return time;    
   }
   
   public void findTaskText(String taskName){ 
   
      String t = taskName;
      try{
         File file =
               new File("C:\\Users\\wcole\\Documents\\CScWork\\131\\src\\TM.txt");
         Scanner sc = new Scanner(file);
         while (sc.hasNextLine()){
            String c = sc.nextLine();
            if(c.contains(t))
               System.out.println(c);
         }
      }
      
      catch (IOException e)
      {  // do something
         e.printStackTrace();
      }
   }
   
   public void log(){
      try{
      // create a new file with specified file name
         FileWriter fw = new FileWriter("Summary.log");
      // create the IO stream on that file
         BufferedWriter bw = new BufferedWriter(fw);
      // write a string into the IO stream
      
         bw.write("fileName.txt");
      // close the stream
         bw.close();
      }
      catch (IOException e)
      {
      }
   }

   void runs(String args[]){
      if(args[0].equals("startTask")){
         startTask(args[1]);
      }
      if(args[0].equals("stopTask")){
         stopTask(args[1]);
      }
      if(args[0].equals("describeTask")){
         if(args.length == 4)
            describeTask(args[1], args[2], args[3]);
         if(args.length == 3)
            describeTask(args[1], args[2], "");
      }
      if(args[0].equals("timeResult"))
         timeResult(timeStart, timeStop);
   
      if(args[0].equals("Summary")){
         printTask(args[1]);
      }
      if(args[0].equals("log")){
         log();
      }
      if(args[0].equals("sizeTask")){
         sizeTask(args[1], args[3]);
      }
   }

   public static void main(String args[]) throws IOException{
      TM tm = new TM();
      tm.runs(args);
   }
}
