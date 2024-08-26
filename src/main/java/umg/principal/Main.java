package umg.principal;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import umg.principal.botTelegram.Bot;
import umg.principal.botTelegram.BotRegistra;
import umg.principal.botTelegram.botPregunton;
import umg.principal.db.DatabaseConnection;
import umg.principal.model.User;
import umg.principal.service.UserService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TelegramBotsApi botsApi;

        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);

            BotSession botSession = botsApi.registerBot(new BotRegistra());
            System.out.println("Bot iniciado correctamente");
        }
        catch (TelegramApiException e) {    e.printStackTrace(); }
        }

    }

