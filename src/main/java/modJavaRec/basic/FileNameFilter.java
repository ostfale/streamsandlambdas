package modJavaRec.basic;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * Another lambda example for filter functionality
 * <p>
 * Created : 17.04.2019
 *
 * @author : usauerbrei
 */
@Slf4j
public class FileNameFilter {

	private static final File directory = new File("./src/main/java/modJavaRec/basic");

	public static void main(String[] args) {
		new FileNameFilter().doIt();
	}

	private void doIt() {
		useInnerClass();
		useLambda();
	}

	private void useLambda() {
		String names[] = directory.list((dir, name) -> name.endsWith(".java"));
		log.info("Use lambda for filtering: " + Arrays.asList(names).toString());
	}

	private void useInnerClass() {
		String[] names = directory.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("java");
			}
		});
		log.info(Arrays.asList("Use inner class for filtering: " + names).toString());
	}
}
