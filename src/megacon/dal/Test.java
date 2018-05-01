package megacon.dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Test {
	 
	
	public static void main(String args[]){
		String datum= "06-04-2018 08:00:00.000";
		
		String tijd= "07:00";
		
		//String newdatetime= getStringFromDateandTime(datum,tijd);
		Timestamp dt= getTimestampFromDateandTimeString(datum,tijd);
		System.out.println(dt);

		
	}
	
	/* @datum
	 * @tijd 
	 * return string date + time
	 */
	private static Timestamp getTimestampFromDateandTimeString(String datum, String tijd ){
		return getTimestampFromString(datum.substring(0, 11) + tijd);
	}
	
	private static Timestamp getTimestampFromString(String inputDate)	 {
		 DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		 Date parsedDate = null;
		 Timestamp datum = null;
        try{
       	 parsedDate = df.parse(inputDate);
       	 long time = parsedDate.getTime();
       	 datum = new Timestamp(time);
       }catch(ParseException parseEx){
          // parseEx.printStackTrace();
       }catch(NullPointerException nEx){
           //nEx.printStackTrace();
       }
     return datum; 
	 }

}
