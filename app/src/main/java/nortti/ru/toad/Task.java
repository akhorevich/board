package nortti.ru.toad;

class Task {
    public enum Type {
        IU,IN,UU,UN
    }

    String name;
    long date;
    Type type;

    public Task(String name, long date, Type type) {
        this.name = name;
        this.date = date;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
