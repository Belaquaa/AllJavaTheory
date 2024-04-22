import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;


public class New {


public static class MailMessage implements Sendable<String> {
    private final String from;
    private final String to;
    private final String content;

    public MailMessage(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String getContent() {
        return content;
    }
}

public static class Salary implements Sendable<Integer> {
    private final String from;
    private final String to;
    private final Integer content;

    public Salary(String from, String to, Integer content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public Integer getContent() {
        return content;
    }
}

public static class MailService<T> implements Consumer<Sendable<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<>();

    @Override
    public void accept(Sendable<T> tSendable) {
        if (tSendable == null || tSendable.getTo() == null || tSendable.getContent() == null) {
            // В зависимости от вашей логики, вы можете выбросить исключение или просто вернуться из метода.
            return;
        }
        mailBox.computeIfAbsent(tSendable.getTo(), k -> new ArrayList<>()).add(tSendable.getContent());
    }


    public Map<String, List<T>> getMailBox() {
        Map<String, List<T>> result = new HashMap<>();
        for (Map.Entry<String, List<T>> entry : mailBox.entrySet()) {
            result.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }
        return result;
    }

}

public interface Sendable<T> {
    String getFrom();

    String getTo();

    T getContent();
}


}

