package amq.po;

import java.util.Date;

/**
 * Created by Administrator on 2019/7/22.
 */
public class Message {
    private int id;
    private String from;
    private String to;
    private String text;
    private Date time;

    public Message(int id, String from, String to, String text, Date time) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.text = text;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                '}';
    }
}
