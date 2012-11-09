package edu.dhbw.oodb.dao.test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.WriterConsumer;
import com.carrotsearch.junitbenchmarks.XMLConsumer;
import com.carrotsearch.junitbenchmarks.h2.H2Consumer;

@ContextConfiguration(locations = { "file:src/db.xml" })
@BenchmarkOptions(benchmarkRounds = 15, warmupRounds = 2)
public abstract class AbstractDaoTests extends AbstractJUnit4SpringContextTests {

	@Rule
	public MethodRule benchmarkRun = new BenchmarkRule(h2Consumer,
			writerConsumer, xmlConsumer);

	private static final File dbFile = new File("benchmark/"
			+ AbstractDaoTests.class.getName());
	// private static final File dbFileFull = new File(dbFile.getName() +
	// ".h2.db");
	private static final File xmlFile = new File("benchmark/"
			+ AbstractDaoTests.class.getName() + ".xml");

	private static H2Consumer h2Consumer;
	private static WriterConsumer writerConsumer;
	private static XMLConsumer xmlConsumer;

	@BeforeClass
	public static void checkFile() throws SQLException, IOException {
		// This condition will delete the database, it it exists. For historical
		// values leave this in comment.
		// if (dbFileFull.exists())
		// assertTrue(dbFileFull.delete());

		h2Consumer = new H2Consumer(dbFile);
		writerConsumer = new WriterConsumer();
		xmlConsumer = new XMLConsumer(xmlFile);

	}

	private static Connection jdbcConnection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			jdbcConnection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "tpch", "tpch");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		jdbcConnection.close();
	}
}
