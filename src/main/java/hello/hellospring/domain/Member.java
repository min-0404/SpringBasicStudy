package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 이제부터 애는 JPA가 관리하는 엔티티구나 !! 라고 선언
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // id 에 해당하는 어노테이션들
    private long id;

    private String name;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}