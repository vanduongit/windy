package windy.infrastructure.contracts.commands;

import windy.framework.contracts.ICommand;

import java.util.UUID;

/**
 * Created by phanvanduong on 14/12/2017.
 */
public class Command implements ICommand{

    private String uuid;

    public Command(){
        uuid = UUID.randomUUID().toString();
    }

    @Override
    public void execute() {

    }

    public String getUuid() {
        return uuid;
    }
}
