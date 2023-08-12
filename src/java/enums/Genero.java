package java.enums;

public enum Genero {
    DRAMA,
    COMEDIA,
    ACAO,
    TERROR,
    SUSPENSE,
    MUSICAL,
    FICCAO_CIENTIFICA,
    ROMANCE,
    DOCUMENTARIO,
    CULT,
    AVENTURA,
    FANTASIA;

    public static Genero getGenero(String genero) {
        switch (genero) {
            case "DRAMA":
                return Genero.DRAMA;
            case "COMEDIA":
                return Genero.COMEDIA;
            case "ACAO":
                return Genero.ACAO;
            case "TERROR":
                return Genero.TERROR;
            case "SUSPENSE":
                return Genero.SUSPENSE;
            case "MUSICAL":
                return Genero.MUSICAL;
            case "FICCAO_CIENTIFICA":
                return Genero.FICCAO_CIENTIFICA;
            case "ROMANCE":
                return Genero.ROMANCE;
            case "DOCUMENTARIO":
                return Genero.DOCUMENTARIO;
            case "CULT":
                return Genero.CULT;
            case "AVENTURA":
                return Genero.AVENTURA;
            case "FANTASIA":
                return Genero.FANTASIA;
            default:
                return null;
        }
    }

}
