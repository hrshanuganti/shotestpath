package za.co.in2it.helper;

import za.co.in2it.exception.FileReaderException;
import za.co.in2it.interfaces.FileReaderInterface;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Created by rchennupati on 1/26/18.
 */
public class FileOperations implements FileReaderInterface {
	private static final Logger logger = Logger.getLogger(FileOperations.class.getName());
	
	public Stream<String> readFile(String fileName) throws FileReaderException {

        logger.info("za.co.in2it.helper.FileOperations.readFile() start");

        Stream<String> lines = null;
            try {
                Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
                lines = Files.lines(path);
            } catch (URISyntaxException | IOException e) {
                throw new FileReaderException(e.getMessage());
            }
        logger.info("za.co.in2it.helper.FileOperations.readFile() before return");
        return lines;
	}
}

