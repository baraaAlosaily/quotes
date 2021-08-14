package quotes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class App {
    public static void main(String[]args) throws IOException {

        try{
            String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
            HttpURLConnection connect = (HttpURLConnection) new URL(url).openConnection();
            connect.setRequestMethod("GET");
            connect.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            int resCode=connect.getResponseCode();
            if (resCode==HttpURLConnection.HTTP_OK) {
                InputStreamReader inputStreamReader = new InputStreamReader(connect.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String data = bufferedReader.readLine();
                bufferedReader.close();
                Gson gson = new Gson();
                Quotes ownQuote = gson.fromJson(data, Quotes.class);
                String findAuther = ownQuote.getAutherQuotes();
                String findQuote = ownQuote.getTextQuotes();
                System.out.println("Results From API:");
                System.out.println("Book Author: " + findAuther);
                System.out.println("Book Quote: " + findQuote);
                Books myAccount = new Books(findAuther, findQuote);
                Writer writer = new FileWriter("quotes/app/src/main/resources/recentquotes.json", true);
                gson.toJson(myAccount, writer);
                System.out.println(myAccount);
                writer.close();
            }
            else {
                Reader reader =new FileReader("quotes/app/src/main/resources/recentquotes.json");
                Type collectionsType=new TypeToken<List<Books>>(){}.getType();
                List<Books> booksList= new Gson().fromJson(reader,collectionsType);
                Random random=new Random();
                int ranNum= random.nextInt((booksList.size()-1)+1);
                System.out.println("Book Author :"+booksList.get(ranNum).getAuther());
                System.out.println("Book Quote:"+booksList.get(ranNum).getText());
                System.out.println(booksList.get(ranNum).toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
      return;
    }
}