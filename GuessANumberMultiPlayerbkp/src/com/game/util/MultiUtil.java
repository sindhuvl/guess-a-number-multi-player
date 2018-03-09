package com.game.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class MultiUtil {
	public static MultiUtil multiUtil = new MultiUtil();
private MultiUtil() {
	userSecretNumber = new HashMap<>();
	userAttemptsLeft = new HashMap<>();
}

private static Map<String,Integer> userSecretNumber;
private static Map<String,Integer> userAttemptsLeft;

public static Map<String, Integer> getUserSecretNumber() {
	return userSecretNumber;
}
public static  Map<String, Integer> getUserAttemptsLeft() {
	return userAttemptsLeft;
}

public static int getSecretNumber() {
	Random random = new Random();
	return random.nextInt(10 - 1 + 1) + 1;
}

}
