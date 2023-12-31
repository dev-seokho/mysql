package com.example.fastcampusmysql.domain.member;

import com.example.fastcampusmysql.domain.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

  @DisplayName("회원은 닉네임을 변경할 수 있다")
  @Test
  void testChangeName() {
    var member = MemberFixtureFactory.create();
    var expected = "noah";

    member.changeNickname(expected);
    Assertions.assertEquals(expected, member.getNickname());
  }

  @DisplayName("회원은 닉네임은 10자를 초과할 수 없다")
  @Test
  void testNicknameMaxLength() {
    var member = MemberFixtureFactory.create();
    var overMaxLengthName = "noahnoahnoah";

    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> member.changeNickname(overMaxLengthName)
    );
  }
}
