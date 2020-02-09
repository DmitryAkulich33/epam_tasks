package by.epam.exercise04.controller.command.impl;

import by.epam.exercise04.controller.command.Command;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.domain.Treasure;
import by.epam.exercise04.service.TreasureService;
import by.epam.exercise04.service.factory.ServiceFactory;
import by.epam.exercise04.view.Viewer;

public class ChosenTreasure implements Command {
    @Override
    public String execute(String request, DragonCave dragonCave) {
        Viewer viewer = new Viewer();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Treasure treasure = serviceFactory.getTreasureService().getTheMostExpensiveTreasure(dragonCave);
        viewer.printTreasure(treasure);
        serviceFactory.getTreasureService().deleteOneTreasure(treasure, dragonCave);
        return "The most expensive treasure was found successfully.";
    }
}
