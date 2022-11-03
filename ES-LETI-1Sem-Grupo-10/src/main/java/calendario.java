
import java.net.*;
import java.io.*;
import java.util.*;


public class calendario {

	private String name;
	private URL url;
	private static HttpURLConnection connection;

	public calendario(String name, URL url) {

		this.name = name;
		this.url = url;

	}

	public void makeConnection() {
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			
			if(status>299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line=reader.readLine())!=null)
					responseContent.append (line);
			
				
				reader.close();
			} else {
				
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line=reader.readLine())!=null)
					responseContent.append (line);
				
				reader.close();
			}
 
			System.out.println(responseContent.toString());
			
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

}	
