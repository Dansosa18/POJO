package umg.principal.botTelegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Dansosabot";
    }


    @Override
    public String getBotToken() {
        return "7184854100:AAFyfzX7oBKSJRc-q-qMi_C-XT37E1IBs7A";
    }


//El método onUpdateReceived(Update update) de la clase Bot se usa para manejar todas las actualizaciones que el
// bot recibe.
// Dependiendo del tipo de actualización, se toman diferentes acciones.

    @Override
    public void onUpdateReceived(Update update) {


        //Se verifica si la actualización contiene un mensaje y si ese mensaje tiene texto.
        //Luego se procesa el contenido del mensaje y se responde según el caso.

        String nombre = update.getMessage().getFrom().getFirstName();
        String apellido = update.getMessage().getFrom().getLastName();
        String nickName= update.getMessage().getFrom().getUserName();

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            if (message_text.toLowerCase().equals("Hola")) {
                sendText(chat_id,"Que ondas"+ nickName+ "gusto saludarte");
            }
            if (message_text.toLowerCase().equals("bye"))
            {
                sendText(chat_id, "orales " + nombre);
            }
            if (chat_id == 1645907091){
                String msg= nombre +"Te saluda";
                sendText(chat_id, "vos sos un gay+");
            }
            System.out.println("Enviaste: "+ message_text);
System.out.println("nombre: "+ nickName);
            System.out.println("User id: " + chat_id);
            System.out.println("User id: " + chat_id + " Message: " + message_text);
        }

    }
    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }
}
