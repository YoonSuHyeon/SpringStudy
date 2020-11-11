package exception;

public class IDTest {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) throws IDFormatException{
        if(userId == null){
            throw  new IDFormatException("아이디는 null일 수 없다.");
        }else if(userId.length() < 8 || userId.length() > 20){
            throw  new IDFormatException("아이디는 8자 이상 20자 이하여야합니다.");
        }

        this.userId = userId;
    }

    public static void main(String[] args) {
        IDTest idTest = new IDTest();
        String myId= null;
        String myId2="12345";

        try {
            idTest.setUserId(myId2);
        } catch (IDFormatException e) {
            System.out.println(e);
        }
    }
}
