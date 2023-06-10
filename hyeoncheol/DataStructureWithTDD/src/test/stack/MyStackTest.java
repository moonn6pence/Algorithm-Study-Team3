package stack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack myStack;

    @BeforeEach
    void setUpWithInteger(){
        myStack = new DefaultStack<Integer>();
    }

    @Test
    @DisplayName("빈 스택 empty true 테스트")
    void isEmptyStackWithEmptyStack() {
        // when
        boolean isEmpty = myStack.empty();

        // then
        assertTrue(isEmpty);
    }

    @Test
    @DisplayName("비지 않은 스택 empty false 테스트")
    void isNotEmptyStackWithEmptyStack() {
        // given
        myStack.push(1);

        // when
        boolean isEmpty = myStack.empty();

        // then
        assertFalse(isEmpty);
    }

    @Test
    @DisplayName("pop으로 인해 빈 스택 empty true 테스트")
    void isEmptyStackWithPoppedStack() {
        // given
        myStack.push(1);

        // when
        myStack.pop();

        // then
        assertTrue(myStack.empty());
    }

    @Test
    @DisplayName("한 번 push된 스택 peek 테스트")
    void peekWhenPushedOnce() {
        // given
        Integer expected = new Integer(132);
        myStack.push(expected);

        // when
        Integer result = (Integer) myStack.peek();

        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("여러 번 push된 스택 peek 테스트")
    void peekWhenPushedSeveralTimes() {
        // given
        Integer[] testElementArray = {1,2,3,4,5};

        // when
        for(Integer testElement : testElementArray){
            myStack.push(testElement);
        }

        //then
        assertEquals(testElementArray[testElementArray.length-1], myStack.peek());
    }

    @Test
    @DisplayName("빈 스택 peek 예외 테스트")
    void peekWithEmptyStack() {
        assertThrows(EmptyMyStackException.class, ()->{
            myStack.peek();
        });
    }

    @Test
    @DisplayName("한 번 pop 테스트")
    void popOnce() {
        // given
        Integer[] testElementArray = {1,2,3,4,5};

        for(Integer testElement : testElementArray){
            myStack.push(testElement);
        }

        // when
        Integer expected = testElementArray[testElementArray.length - 2];

        // then
        assertEquals(expected, myStack.pop());
    }


    @Test
    @DisplayName("여러 번 pop 테스트")
    void popSeveralTimes() {
        // given
        Integer[] testElementArray = {1,2,3,4,5};

        for(Integer testElement : testElementArray){
            myStack.push(testElement);
        }

        // when
        myStack.pop();
        Integer expected = testElementArray[testElementArray.length - 3];
        Integer result = (Integer) myStack.pop();

        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("빈 스택 pop 예외 테스트")
    void popWithEmptyStack() {
        assertThrows(EmptyMyStackException.class, ()->{
            myStack.pop();
        });
    }

    @Test
    @DisplayName("빈 스택 push 테스트")
    void pushWithEmptyStack() {
        // given
        Integer[] testElementArray = {1,2,3,4,5};
        String expected = testElementArray.toString();

        // when
        for(Integer testElement : testElementArray){
            myStack.push(testElement);
            assertEquals(testElement, myStack.peek());
        }

        // then
        assertEquals(expected, myStack.toString());
    }

    @Test
    @DisplayName("비지 않은 스택 push 테스트")
    void pushWithNotEmptyStack() {
        // given
        Integer[] testElementArray = {1,2,3,4,5};
        myStack.push(0);
        String expected = "0, " + testElementArray.toString();

        // when
        for(Integer testElement : testElementArray){
            myStack.push(testElement);
            assertEquals(testElement, myStack.peek());
        }

        // then
        assertEquals(expected, myStack.toString());
    }

    @Test
    @DisplayName("search 테스트")
    void search() {
        // given
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(3);


        // when
        assertAll(
                ()->assertEquals(1, myStack.search(Integer.valueOf(2))),
                ()->assertEquals(-1,myStack.search(Integer.valueOf(5))),
                ()->assertEquals(4, myStack.search(Integer.valueOf(4))),
                ()->{
                    myStack.pop();
                    assertEquals(2, myStack.search(Integer.valueOf(2)));
                }
        );
    }
}