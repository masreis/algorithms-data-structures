package net.ads.algorithms.test2;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import net.ads.algorithms.test2.PuzzleConcat;
import net.ads.algorithms.test2.PuzzleConcat.Validator;

class PuzzleConcatTest {

//    @Test
    final void testCompareChars() throws IOException {
//        PuzzleConcat clazz = new PuzzleConcat();
//        Validator validator = clazz.new StrategyCompareChars();
//        clazz.doProcess(validator);
    }

//    @Test
    final void testCompareCharsOptimized() throws IOException {
//        PuzzleConcat clazz = new PuzzleConcat();
//        Validator validator = clazz.new StrategyCompareCharsOptimized();
//        clazz.doProcess(validator);
    }

//    @Test
    final void testCompareCharsInSequence() throws IOException {
        PuzzleConcat clazz = new PuzzleConcat();
//        Validator validator = clazz.new StrategyCompareCharsInSequence();
//        clazz.doProcess(validator);
    }

//    @Test
    final void testBinary() throws IOException {
//        PuzzleConcat clazz = new PuzzleConcat();
//        Validator validator = clazz.new StrategyNoProcess();
//        clazz.doProcess(validator);
    }

    @Test
    final void testStringBuilder() throws IOException {
        PuzzleConcat clazz = new PuzzleConcat();
        Validator validator = clazz.new StrategyStringBuilder();
        clazz.doProcess(validator);
    }

}
