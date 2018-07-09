package cg;

/**
 * Created by kreisso on 09.07.2018.
 */
import java.io.File;
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

        String fileName = new File(source).getName();
        int dotIndex = fileName.lastIndexOf('.');
        String extension = (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);


        for(int i = 0; i < howManyCopies.intValue(); i++) {
            Files.copy(Paths.get(source), Paths.get(destiny+"/"+i+"."+extension), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}

