
package bank.util;

import java.io.*;
import java.util.*;

public class FileUtil {

    public static List<String> read(String path){

        List<String> lines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line;

            while((line = br.readLine()) != null){
                lines.add(line);
            }

        }catch(Exception e){}

        return lines;
    }

    public static void write(String path,List<String> data){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){

            for(String l : data){
                bw.write(l);
                bw.newLine();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void append(String path,String line){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){

            bw.write(line);
            bw.newLine();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
