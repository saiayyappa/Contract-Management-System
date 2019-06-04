package com.cms;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StateDropDown {

	public static List<String> main(String args[]) throws Exception {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get("src\\state.txt")));
		List<String> list = new ArrayList<String>(Arrays.asList(data.split(",")));

		for (String state : list) {
			System.out.println(state);
		}
		return list;
	}
}
