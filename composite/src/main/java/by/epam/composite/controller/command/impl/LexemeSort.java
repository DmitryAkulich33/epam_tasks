package by.epam.composite.controller.command.impl;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;
import by.epam.composite.service.factory.ServiceFactory;
import by.epam.composite.view.Viewer;

public class LexemeSort implements Command {
    @Override
    public String execute(String request, Component component) {
        Viewer viewer = new Viewer();
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        return "not done yet";
    }
}
