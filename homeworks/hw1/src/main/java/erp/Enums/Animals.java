package erp.Enums;

public enum Animals {
    WOLF("WOLF"),
    TIGER("TIGER"),
    RABBIT("RABBIT"),
    MONKEY("MONKEY");

    private final String className; // Строковое описание

    Animals(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
