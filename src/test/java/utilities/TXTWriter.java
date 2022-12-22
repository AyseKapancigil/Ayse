package utilities;

import pojo.OptimalChangePojo;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TXTWriter {

    public static void saveAPIOptimalData(OptimalChangePojo optimalChangePojo){
        try{
            FileWriter fw = new FileWriter(ConfigReader.getProperty("fondy_txt"),true)  ;

            BufferedWriter bw= new BufferedWriter(fw);

            bw.append(optimalChangePojo.toString() + "\n");



            bw.close();


        }catch(Exception e){
            e.printStackTrace();


        }

    }
}
