package by.epam.composite.domain;

import java.util.List;

public class Sentence implements Component {
    private List<Component> components;

    @Override
    public int calcSize() {
        return components.size();
    }

    public Sentence() {
    }

    public Sentence(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public String operation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : getComponents()) {
            stringBuilder.append(component.operation());
        }

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        return components != null ? components.equals(sentence.components) : sentence.components == null;
    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }
}
