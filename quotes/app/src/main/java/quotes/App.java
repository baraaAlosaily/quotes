/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;
import com.google.gson.Gson;
import com.google.common.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;


public class App {
    public static void main(String[]args)throws FileNotFoundException{
        Gson gson=new Gson();
        Reader reader =new FileReader("app/src/main/resources/recentquotes.json");

        Type collectionsType=new TypeToken<List<Books>>(){}.getType();
        List<Books> booksList= new Gson().fromJson(reader,collectionsType);

        Random random=new Random();
        int ranNum= random.nextInt((booksList.size()-1)+1);

//        System.out.println("Book Author :"+booksList.get(ranNum).getAuther());
//        System.out.println("Book Quote:"+booksList.get(ranNum).getText());
        System.out.println(booksList.get(ranNum).toString());

    }
}
