package executor.service.service.factory;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static executor.service.service.factory.PackageTree.ROOT_DIR;
import static executor.service.service.factory.PackageTree.scanDirectoryForInterfaces;

class PackageTreeTest {

    @Test
    void testPackageTree() {
        PackageTree.printPackageTree(new File(ROOT_DIR), "");
    }

    @Test
    void testPackageTrees() {

        File rootDirectory = new File(ROOT_DIR);
        List<Class<?>> interfaces = new ArrayList<>();
        scanDirectoryForInterfaces(rootDirectory, interfaces);
        interfaces.forEach(System.out::println);
    }
}
