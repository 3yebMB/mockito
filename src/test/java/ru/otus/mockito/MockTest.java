package ru.otus.mockito;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    private Map<Integer, String> map;

    @Test
    public void testMockMapPutDefaultBehavior() {
        //when
        map.put(1, "test");

        //then
        assertThat(map.get(1), is(nullValue()));
    }

    @Test
    public void testMockMapKeySetDefaultBehavior() {
        //when
        map.put(1, "test");

        //then
        assertThat(map.keySet(), is(empty()));
    }

    @Test
    public void testMockMapValuesWithDefinedBehavior() {
        Collection<String> stub = Arrays.asList("test1", "test2", "test3");
        when(map.values()).thenReturn(stub);

        //when
        map.put(1, "test");

        //then
        assertThat(map.values(), is(stub));
    }

}
