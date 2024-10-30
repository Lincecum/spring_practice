package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04.domain.dto.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class JUnitAnnotationTests2 {

    @TestFactory
    List<DynamicNode> testFactoryExampleTest(){
        int size = 10;
        List<DynamicNode> result = new ArrayList<>();
        for(int i = 0; i < size; i ++){
            int finalI = i;
            result.add(dynamicTest("Test CaseName" + i, () -> System.out.println("Dynamic Test #" + finalI)));

        }
        return result;
    }
    // 인수 테스트 진행 시, 필요한 데이터를 먼저 저장하고 조회하는 순서로 작성할 경우 가독성이 좋지 않음
    // 이에 dynamicTest 메소드를 이용해서 인수 테스트의 절차를 나누면서 Test의 이름 설정 및 가독성 높일수있음

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @NullAndEmptySource
    // Empty와 NUll도 인자값으로 전달된다
    void parameterizedTestsExample(String userName){
        System.out.println("userName" + userName);
        assertThatThrownBy(() -> new User(userName))
                .isInstanceOf(IllegalArgumentException.class);


    }

    @ParameterizedTest
    @CsvSource(value = {"1||2", "2||4", "3||6", "4||8"}, delimiterString = "||")
    void csvSourceExampleTest2(int input, int expected){
        assertEquals(expected, input * 2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2", "2, 4", "3, 6"})
    void csvSourceExampleTest(int input, int expected) {
        assertEquals(expected, input*2);
    }

    @RepeatedTest(value =10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void repeatedTestExample(RepetitionInfo info){
        int currentValue = info.getCurrentRepetition();
        assertEquals(currentValue *2, currentValue*2);

    }


    @Test
    @DisplayName("User의 이름이 Null이면 예외처리가 되어야 한다.")
    void userNameNullThenException(){
        assertThatThrownBy(() -> new User(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("User Name 공백일 시 예외처리가 되어야 함 ")
    void userNameIsBlankThenException(){
        assertThatThrownBy(() -> new User(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
