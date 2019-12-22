package by.epam.classes.dao;

import by.epam.classes.dao.exception.StreamNotReadingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LinesReader {

    public List<String> returnListCarsFromFile(String path) {
        List<String> cars;
        Path source = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(source)) {
            cars = lineStream.collect(Collectors.toList());
        } catch (IOException e){
            throw new StreamNotReadingException("File reading problems", e);
        }
        return cars;
    }
}
