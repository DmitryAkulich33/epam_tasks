package by.epam.exercise04.controller.command;

import by.epam.exercise04.domain.DragonCave;

public interface Command {
    String execute(String request, DragonCave dragonCave);
}
