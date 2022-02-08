package hello.hellospring.Controller;

// MemberController 에서 가입기능을 구현할 때 가입할때 입력받은 데이터를 임시로 저장해줄 클래스
public class MemberForm {
    private String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
