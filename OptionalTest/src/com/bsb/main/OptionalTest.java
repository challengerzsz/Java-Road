package com.bsb.main;

import com.bsb.pojo.User;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionalTest {

    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> optionalUser = Optional.empty();
        optionalUser.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        User user = null;
//        使用of和ofNullable方法创建包含值的Optional。两个方法不同之处在于如果将null传入作为参数，of方法会抛出空指针异常。
//        应该在对象明确不为null时使用of方法
//        Optional<User> opt = Optional.of(user);
//        若对象可能是null或非null则应该使用ofNullable方法
        Optional<User> opt = Optional.ofNullable(user);
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "testName";
        Optional<String> opt = Optional.ofNullable(name);
//        从 Optional 实例中取回实际值对象的方法之一是使用 get() 方法：
//        get方法会在Optional对象包含对象为null时抛出空指针异常
        assertEquals("testName", opt.get());
    }

    @Test
    public void whenCheckIfPresent_thenOk() {
        User user = new User("zsz", 1, "12345");
//        User user = null;
        Optional<User> opt = Optional.ofNullable(user);

        assertTrue(opt.isPresent());

//        检查是否有值的另一个选择是 ifPresent() 方法。
//        该方法除了执行检查，还接受一个Consumer(消费者) 参数，如果对象不是空的，就对执行传入的 Lambda 表达式：
        opt.ifPresent( u -> assertEquals(user.getId(), u.getId()));

//        assertEquals(user.getId(), opt.get().getId());
    }

    @Test
    public void whenEmptyValue_thenReturnDefault() {
        User user = null;
        User user1 = new User("zsz", 1, "zsz");

//        方法 orElse()，它的工作方式非常直接，如果有值则返回该值，否则返回传递给它的参数值：
//        若user值不为空则忽略orElse()方法的对象
        User result = Optional.ofNullable(user).orElse(user1);

        assertEquals(user1.getId(), result.getId());
    }

    @Test
    public void givenEmptyValue_whenCompare_thenOk() {
        User user = null;
        System.out.println("Using orElse");
        User result = Optional.ofNullable(user).orElse(createNewUser());
        System.out.println("Using orElseGet");
        //当user对象不为null时，orElseGet()的lambda表达式就将不会执行
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }

    private User createNewUser() {
        System.out.println("Creating New User");
        return new User("zsz", 1, "zsz");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenThrowException_thenOk() {
        User user = null;
        User result = Optional.ofNullable(user)
                .orElseThrow( () -> new IllegalArgumentException());
    }

    @Test
    public void whenMap_thenOk() {
        User user = new User("zsz", 1, "zsz");
        int id = Optional
                .ofNullable(user)
                .map(u -> u.getId())
                .orElse(2);

        assertEquals(id, user.getId());
    }
}
