package hello.hellospring.Controller.Member;

// MemberController 에서 가입기능을 구현할 때 가입할때 입력받은 데이터를 임시로 저장해줄 클래스
// 사실 이 클래스는 아무 쓸모 없다 : HTML Form 으로 받은 데이터는 보통 쿼리 파라미터로 처리하면 되기 때문
public class MemberForm {
    private String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
