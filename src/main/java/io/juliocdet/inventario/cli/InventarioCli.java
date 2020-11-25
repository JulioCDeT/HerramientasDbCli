package io.juliocdet.inventario.cli;

import io.juliocdet.inventario.cli.exception.InventarioServiceException;
import io.juliocdet.inventario.cli.model.Herramienta;
import io.juliocdet.inventario.cli.service.InventarioService;

import static io.juliocdet.inventario.cli.model.Constants.ADD_COMMAND;
import static io.juliocdet.inventario.cli.model.Constants.DELETE_COMMAND;
import static io.juliocdet.inventario.cli.model.Constants.GET_COMMAND;
import static io.juliocdet.inventario.cli.model.Constants.HELP_CLI_INFO;
import static io.juliocdet.inventario.cli.model.Constants.HELP_COMMAND;
import static io.juliocdet.inventario.cli.model.Constants.UPDATE_COMMAND;

public class InventarioCli {

    private static InventarioService inventarioService;

    public static void main(String[] args) {
        /* Validate args recived */
        if (args.length > 0) {

            String user = args[0];      // leemos el usuario del argumento 0
            String password = args[1];  // leemos el pasword del argumento 1

            try {
                inventarioService = new InventarioService(user, password);
            } catch (InventarioServiceException e) {
                System.out.println("Error while starting inventarios service, " + e.getMessage());
                System.exit(-1);
            }

            /* consultar el comando pedido */
            switch (args[2]) {
                case GET_COMMAND:
                    if (args.length == 3) {
                        inventarioService.getAllTools();
                    } else if (args.length == 4) {
                        inventarioService.getAllToolById(Integer.parseInt(args[3]));
                    } else {
                        showNotFoundCommand();
                    }
                    break;

                case ADD_COMMAND:
                    if (args.length == 6) {
                        inventarioService.addHerramienta(
                                new Herramienta(
                                        args[3],
                                        Integer.parseInt(args[4]),
                                        args[5]));
                    } else {
                        showNotFoundCommand();
                    }
                    break;

                case DELETE_COMMAND:
                    if (args.length == 4) {
                        /* remove the tool that match the id */
                    } else {
                        showNotFoundCommand();
                    }
                    break;

                case UPDATE_COMMAND:
                    if (args.length == 7) {
                        /* update the tool data related to the tool that match the id */
                    } else {
                        showNotFoundCommand();
                    }
                    break;

                case HELP_COMMAND:
                    showHelp();
                    break;

                default:
                showNotFoundCommand();
                    break;
            }
        } else {
            showNotFoundCommand();
        }
    }

    private static void showHelp() {
        System.out.println(HELP_CLI_INFO);
    }

    private static void showNotFoundCommand() {
        System.out.println("command not found see --help");
    }
}
