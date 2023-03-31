package odczytdanychzip;

import java.io.*;
import java.util.zip.*;

public class OdczytDanychZIP 
{   public static final int buffor = 1024;
    public static void main(String[] args) 
    {
        File katalog = new File(System.getProperty("user.dir")+File.separator+"MojZip");
        ZipEntry wpis = null;
        byte tmpData[] = new byte[buffor];
        try
        {
            if(!katalog.exists())
                katalog.mkdir();
            
            ZipInputStream zInS = new ZipInputStream(new BufferedInputStream(new FileInputStream("MojZip.zip"),buffor));
            
            while((wpis = zInS.getNextEntry())!= null)
            {
                BufferedOutputStream fOutS = new BufferedOutputStream(new FileOutputStream(katalog+File.separator+wpis.getName()));
                
                int counter;
                while ((counter = zInS.read(tmpData, 0, buffor)) != -1)
                    fOutS.write(tmpData, 0, counter);
                
                fOutS.close();
                zInS.closeEntry();
            }
            
            
            zInS.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
        
    
}