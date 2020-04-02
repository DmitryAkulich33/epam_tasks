package by.epam.bakery.controller;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandName;
import by.epam.bakery.controller.command.impl.admin.*;
import by.epam.bakery.controller.command.impl.common.*;
import by.epam.bakery.controller.command.impl.user.CreatorFeedbackCommand;
import by.epam.bakery.controller.command.impl.user.ShowFeedbackCommand;
import by.epam.bakery.controller.command.impl.user.AddOrderCommand;
import by.epam.bakery.controller.command.impl.user.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SHOW_MAIN_PAGE, new ShowMainPageCommand());
        repository.put(CommandName.LOGIN, new LoginCommand());
        repository.put(CommandName.LOG_OUT, new LogoutCommand());
        repository.put(CommandName.SORT_BY_INCREASE_PRICE, new SorterByPriceIncreaseCommand());
        repository.put(CommandName.SORT_BY_REDUCTION_PRICE, new SorterByPriceReductionCommand());
        repository.put(CommandName.PERSONAL_ACCOUNT, new PersonalAccountCommand());
        repository.put(CommandName.CHANGE_NAME, new ChangeNameCommand());
        repository.put(CommandName.CHANGE_SURNAME, new ChangeSurnameCommand());
        repository.put(CommandName.CHANGE_PATRONYMIC, new ChangePatronymicCommand());
        repository.put(CommandName.CHANGE_ADDRESS, new ChangeAddressCommand());
        repository.put(CommandName.CHANGE_PHONE, new ChangePhoneCommand());
        repository.put(CommandName.SHOW_FEEDBACK, new ShowFeedbackCommand());
        repository.put(CommandName.ADD_FEEDBACK, new CreatorFeedbackCommand());
        repository.put(CommandName.SHOW_ABOUT_US, new ShowAboutUsCommand());
        repository.put(CommandName.SHOW_CONTACTS, new ShowContactsCommand());
        repository.put(CommandName.SHOW_DELIVERY, new ShowDeliveryCommand());
        repository.put(CommandName.ADD_PIE, new AddPieCommand());
        repository.put(CommandName.CLEAR_BASKET, new ClearBasketCommand());
        repository.put(CommandName.ADD_ORDER, new AddOrderCommand());
        repository.put(CommandName.ADMIN_ACCOUNT, new AdminAccountCommand());
        repository.put(CommandName.ADMIN_PIES, new AdminPiesCommand());
        repository.put(CommandName.ADMIN_FEEDBACK, new AdminFeedbackCommand());
        repository.put(CommandName.FIND_PIE_BY_ID, new FindPieByIdCommand());
        repository.put(CommandName.FIND_PIE_BY_NAME, new FindPieByNameCommand());
        repository.put(CommandName.DELETE_PIE, new DeletePieCommand());
        repository.put(CommandName.SAVE_PIE, new SavePieCommand());
        repository.put(CommandName.CHANGE_PIE, new ChangePieCommand());
        repository.put(CommandName.FIND_FEEDBACK_BY_USER, new FindFeedbackByUserCommand());
        repository.put(CommandName.DELETE_FEEDBACK, new DeleteFeedbackCommand());
        repository.put(CommandName.SHOW_LAST_FEEDBACK, new ShowLastFeedbackCommand());
        repository.put(CommandName.ADMIN_USERS, new AdminUsersCommand());
        repository.put(CommandName.DELETE_USER, new DeleteUserCommand());
        repository.put(CommandName.SAVE_USER, new SaveUserCommand());
        repository.put(CommandName.FIND_USER_BY_ID, new FindUserByIdCommand());
        repository.put(CommandName.FIND_USER_BY_SURNAME, new FindUserBySurnameCommand());
        repository.put(CommandName.CHANGE_USER, new ChangeUserCommand());
        repository.put(CommandName.ADMIN_ORDER, new AdminOrderCommand());
        repository.put(CommandName.ADMIN_ORDER_PRODUCT, new AdminOrderProductCommand());
//        repository.put(CommandName.ADMIN_BASKET, new AdminBasketCommand());
//        repository.put(CommandName.ADMIN_BASKET_PRODUCT, new AdminBasketProductCommand());
        repository.put(CommandName.SHOW_BASKET, new ShowBasketCommand());
        repository.put(CommandName.DELETE_PIE_FROM_BASKET, new DeletePieFromBasketCommand());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException ex) {
            command = repository.get(CommandName.WRONG_COMMAND);
        }
        return command;
    }
}
