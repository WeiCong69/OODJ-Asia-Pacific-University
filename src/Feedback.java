public class Feedback {

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getReply() {
        return reply;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Feedback(String id, String subject, String content, String reply) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.reply = reply;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    private String id;
    private String subject;
    private String content;
    private String reply;
    
    @Override
    public String toString()
    {
        return null;
    }
    
    public static void main(String[] args) {
        
    }
    
}
