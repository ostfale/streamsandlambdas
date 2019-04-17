package modJavaRec.basic;

import lombok.extern.slf4j.Slf4j;

/**
 * Some introductory examples
 * <p>
 * Created : 17.04.2019
 *
 * @author : usauerbrei
 */
@Slf4j
public class Intro {

	public static void main(String[] args) {
		new Intro().doIt();
	}

	private void doIt() {
		useInnerAnonymousClass();
		useLambdaExpression();
		useLambdaAssignedToVariable();
	}

	private void useLambdaAssignedToVariable() {

		Runnable runnable = () -> log.info("Use lambda assigned to variable...");
		new Thread(runnable).start();

	}

	private void useLambdaExpression() {
		new Thread(() -> log.info("use a lambda")).start();
	}

	private void useInnerAnonymousClass() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				log.info("Run with an inner anonymous class...");
			}
		}).start();
	}
}
