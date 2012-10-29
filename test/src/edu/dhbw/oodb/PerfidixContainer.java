package edu.dhbw.oodb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.perfidix.Perfidix;
import org.perfidix.ouput.CSVOutput;
import org.perfidix.ouput.TabularSummaryOutput;
import org.perfidix.result.BenchmarkResult;

public class PerfidixContainer {
	final static String[] classNames = {
//			"edu.dhbw.oodb.dao.test.CustomerDaoTest",
			"edu.dhbw.oodb.dao.test.OrderDaoTest" };

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BenchmarkResult result;
		try {
			result = Perfidix.runBenchs(classNames);
			File folder = new File(System.getProperty("user.home")
					+ "/workspace/OODB_FetchPerf/benchmark/");
			PrintStream sum = new PrintStream(System.getProperty("user.home")
					+ "/workspace/OODB_FetchPerf/benchmark/summary");
			new TabularSummaryOutput().visitBenchmark(result);
			new TabularSummaryOutput(sum).visitBenchmark(result);
			new CSVOutput(folder).visitBenchmark(result);
		} catch (ClassNotFoundException err) {
			err.printStackTrace();
		} catch (InstantiationException err) {
			err.printStackTrace();
		} catch (IllegalAccessException err) {
			err.printStackTrace();
		} catch (FileNotFoundException err) {
			err.printStackTrace();
		}
	}

}
