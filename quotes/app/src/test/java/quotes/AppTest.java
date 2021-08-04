/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test void appHasAGreeting() throws FileNotFoundException {
        Gson gson=new Gson();
        Reader reader =new FileReader("../app/src/main/resources/recentquotes.json");

        Type collectionsType=new TypeToken<List<Books>>(){}.getType();
        List<Books> booksList= new Gson().fromJson(reader,collectionsType);

        Random random=new Random();
        int ranNum= random.nextInt((booksList.size()-1)+1);
        String str=booksList.get(ranNum).toString();

        assertEquals(str,booksList.get(ranNum).toString());

    }
}
