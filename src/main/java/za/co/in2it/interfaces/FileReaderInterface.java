package za.co.in2it.interfaces;

import za.co.in2it.exception.FileReaderException;

import java.util.stream.Stream;

/**
 * Created by rchennupati on 2/10/18.
 */
public interface FileReaderInterface {

    public Stream<String> readFile(String fileName) throws FileReaderException;
}
