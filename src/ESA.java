import commands.CommandResponse;
import commands.InputCommand;
import io.Reader;
import io.impl.ConsolePrinter;
import io.InputParser;
import io.Printable;
import io.impl.ConsoleReader;
import services.InputCommandProcessor;

public class ESA {

    Boolean appRun = true;
    Printable printer = new ConsolePrinter();
    InputParser inputParser = new InputParser();
    Reader reader = new ConsoleReader();
    InputCommand inputCommand;
    CommandResponse commandResponse;
    InputCommandProcessor inputCommandProcessor = new InputCommandProcessor();
    public void run(){

        do{
            String inputString = reader.read();
            inputCommand = inputParser.parseInput(inputString);
            commandResponse = inputCommandProcessor.processInputCommand(inputCommand);
            printer.print(commandResponse.getResponseDescription());
            if(commandResponse.getResponseDescription().equals("Terminated Successfully")){
                appRun = false;
            }
        }while(appRun);
    }

}
