package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();

  @AfterEach //메소드가 실행이 끝날때마다 동작하는 콜백함수
  public void afterEach(){
    repository.clearStore(); //실행할 때마다 메모리를 클리어
  }

  //테스트는 의존 관계가 없이 실행되어야 함, 순서대로 실행되지 않음
  //그래서 하나의 테스트가 끝날 때마다 메모리를 클리어해야 함
  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");
    repository.save(member);

    Member result = repository.findById(member.getId()).get();
//    System.out.println("result = " + (result == member));
//    Assertions.assertEquals(member, null);
    assertThat(member).isEqualTo(result);
  }

  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    Member result = repository.findByName("spring1").get();

    assertThat(result).isEqualTo(member1);
  }

  @Test
  public void findAll() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    List<Member> result = repository.findAll();

    assertThat(result.size()).isEqualTo(2);
  }
}
