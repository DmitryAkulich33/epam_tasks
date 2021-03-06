package by.epam.multithreading.method02.dao;

import by.epam.multithreading.method02.dao.exception.StreamNotReadingException;

import java.util.List;

public interface ReaderDAO {
    List<String> readLines(String path) throws StreamNotReadingException;
}
