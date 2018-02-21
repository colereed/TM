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

public class TM {
	private int Result = 0;
	private int time;
	private String description;
	private String timeStart;
	private String timeStop;
   
	private String Start(String taskName){
	//Grab time;
	timeStart = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
   String logLine = timeStart + " " + "start" + " " + taskName + "\r\n";
	System.out.println(timeStart + "  start");
   try{
         Files.write(Paths.get("./fileName.txt"), logLine.getBytes(), StandardOpenOption.APPEND);
      }
      catch (IOException e) {
      }
	return timeStart;
   }
	
	private String Description(String taskName, String description) {
   //Ask the user for a description of their task.
	//description = args[2];
      try{
            Files.write(Paths.get("./fileName.txt"), description.getBytes(), StandardOpenOption.APPEND);
      }
      catch (IOException e) {
      }
	return description;
   }

	private String Stop(String taskName){
	//grab time
	timeStop = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
	System.out.println(timeStop + "  stop");
   try{
         Files.write(Paths.get("./fileName.txt"), timeStop.getBytes(), StandardOpenOption.APPEND);
      }
      catch (IOException e) {
      }
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
   
   void runs(String args[]){
      if(args[0].equals("Start")){
         Start(args[1]);
      }
      if(args[0].equals("Stop")){
         Stop(args[1]);
         //timeResult();
      }
      if(args[0].equals("Description")){
         Description(args[1], args[2]);
      }
      if(args[0].equals("Summary")){
      }
   }

	public static void main(String args[]) throws IOException{
      TM tm = new TM();
      tm.runs(args);
		/*projectO TM = new projectO();
		String text = TM.Start();
		TM.startDescription();
		String ts = TM.Stop();
		int Result = TM.timeResult(text, ts);
      String Output = text + "\r\n"+
                      ts + "\r\n"+
                      Result + "\r\n";
		try{
         Files.write(Paths.get("./fileName.txt"), Output.getBytes(), StandardOpenOption.APPEND);
      }
      catch (IOException e) {
      }*/
	}	
}   