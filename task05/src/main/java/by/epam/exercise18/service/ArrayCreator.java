package by.epam.exercise18.service;

import by.epam.exercise18.service.exception.WrongDataException;

import java.util.List;

public class ArrayCreator {
    public int[] getArray(List<Integer> list, int length) {
        ArrayValidator arrayValidator = new ArrayValidator();
        int[] array = new int[length];
        if (arrayValidator.isValid(list)) {
            array[list.get(0)] = list.get(2);
            array[list.get(1)] = list.get(3);
            return array;
        } else {
            throw new WrongDataException("The entered data is wrong");
        }
    }
}
