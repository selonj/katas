package test.java.lang;

import com.selonj.katas.data.Resource;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Generated;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.xml.stream.events.Characters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by L.x on 16-3-7.
 */
public class ClassTest {

    @Test
    public void asSubclass() throws Exception {
        assertThat(Integer.class.asSubclass(Number.class), equalTo((Class) Integer.class));

        try {
            Number.class.asSubclass(Integer.class);
            fail("should raising exception");
        } catch (ClassCastException expected) {

        }
    }

    @Test
    public void canGetAnnotationOnlyOnRuntime() throws Exception {
        assertThat(Resource.class.getAnnotation(SupportedSourceVersion.class).value(), equalTo(SourceVersion.RELEASE_7));
        assertThat(Resource.class.getAnnotation(Generated.class), nullValue());//source only
    }

    @Test
    public void canCheckingAnnotationPresentOnlyOnRuntime() throws Exception {
        assertTrue(Resource.class.isAnnotationPresent(SupportedSourceVersion.class));
        assertFalse(Resource.class.isAnnotationPresent(Generated.class));
    }

    @Test
    public void instanceChecking() throws Exception {
        assertTrue(String.class.isInstance("<string>"));
        assertTrue(CharSequence.class.isInstance("<string>"));
        assertFalse(Integer.class.isInstance("<string>"));
    }

    @Test
    public void typeChecking() throws Exception {
        assertTrue(CharSequence.class.isAssignableFrom(String.class));
        assertFalse(Integer.class.isAssignableFrom(Characters.class));
    }

    @Test
    public void synthetic() throws Exception {
        assertFalse(Integer.class.isSynthetic());
    }

    @Test
    public void enclosingMethod() throws Exception {
        class EnclosedClass {

        }
        assertThat(Resource.class.getEnclosingMethod(), nullValue());
        Assert.assertThat(EnclosedClass.class.getEnclosingMethod(), equalTo(ClassTest.class.getMethod("enclosingMethod")));
    }


}
