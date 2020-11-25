package io.juliocdet.inventario.cli.model;

public interface Constants {

    String JUMPLINE = System.lineSeparator();

    String HELP_CLI_INFO = new StringBuilder()
            .append("This inventarioCli let you: Read, Write, update and delete in the herramientas Db").append(JUMPLINE)
            .append("information of the tools in the herramientas database").append(JUMPLINE)
            .append("the allowed command are: ").append(JUMPLINE)
            .append("user password --get [id] \"That return all the tools or if provided the id, the tool matching that id\"").append(JUMPLINE)
            .append("user password --add nombre catidad categoria \"Add a new tool in the db with the given filds\"").append(JUMPLINE)
            .append("user password --remove id \"Delete the tool that match with that id into the db\"").append(JUMPLINE)
            .append("user password --update id nombre cantidad categoria \"Update the name cantidad and categoria to the tool that match the id\"").append(JUMPLINE)
            .toString();

    String GET_COMMAND = "--get";
    String ADD_COMMAND = "--add";
    String DELETE_COMMAND = "--delete";
    String UPDATE_COMMAND = "--update";
    String HELP_COMMAND = "--help";
}
