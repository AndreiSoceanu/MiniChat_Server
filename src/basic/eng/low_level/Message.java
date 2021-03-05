package basic.eng.low_level;

public class Message {
    private String mSender;
    private String mContent;

    public Message(String sender, String content){
        this.mSender = sender;
        this.mContent = content;
    }

    public String toString(){
        return mSender + ":" + mContent;
    }
}
