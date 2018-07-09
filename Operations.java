package cg;

/**
 * Created by kreisso on 09.07.2018.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public interface Operations {

    default public void makeCopies(String source, String destiny, Integer howManyCopies) throws IOException
    {
        if(!Files.exists(Paths.get(destiny)))
        {
            Files.createDirectory(Paths.get(destiny));
        }
        for(int i = 0; i < howManyCopies.intValue(); i++) {
            Files.copy(Paths.get(source), Paths.get(destiny+"/"+i+".png"), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}

