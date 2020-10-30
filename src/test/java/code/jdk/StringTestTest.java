package code.jdk;

import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class StringTestTest {

    @Test
    public void testStringAdd() throws Exception {
        Options options = new OptionsBuilder()
                .include(StringBenchmark.class.getSimpleName())
                //.output("E:/Benchmark.log")
                .build();
        new Runner(options).run();
    }

    @Test
    public void testStringBuilderAdd() {
    }
}