package by.epam.composite.service.comparator;

import by.epam.composite.domain.Component;

import java.util.Comparator;

public class SymbolComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        return Integer.compare(o1.getSize(), o2.getSize());
    }
}
