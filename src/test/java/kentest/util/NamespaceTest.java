package kentest.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ken.util.Namespace.*;

public class NamespaceTest{
    @Test
    public void givenValidNamespacePath_WhenNamespaceOf_ShouldReturnCorrectly(){
        String namespace = "foo", path1 = "bar1", path2 = "bar2", path3 = "bar3";
        String expected = namespace + NAMESPACE_SEPARATOR
            + path1 + PATH_SEPARATOR
            + path2 + PATH_SEPARATOR
            + path3;

        Assertions.assertEquals(expected, of(namespace, path1, path2, path3));
    }

    @Test
    public void givenInvalidNamespaceName_WhenNamespaceOf_ShouldThrow(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> of("foo!", "bar"));
    }

    @Test
    public void givenInvalidNamespacePath_WhenNamespaceOf_ShouldThrow(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> of("foo", "!bar"));
    }

    @Test
    public void givenNamespaceWithoutPath_WhenNamespaceOf_ShouldThrow(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> of("foo"));
    }
}
