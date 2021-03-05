package basic.eng.low_level;

public final class PrivateMessage extends Message{
    private String mDest;

    public PrivateMessage(String dest, String sender, String content){
        super(sender, content);
        mDest = dest;
    }

    public String toString(){
        return "(priv) " + super.toString();
    }

    public String getRecipient(){
        return mDest;
    }
}
