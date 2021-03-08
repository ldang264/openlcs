import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00692mTest {

    Q00692m q00692m = new Q00692m();

    @Test
    public void topKFrequent() {
        Assert.assertEquals(q00692m.topKFrequent(new String[]{"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"}, 14).toString(),
                "[nftk, qkjzgws, qrkgmliewc, nsfspyox, qengse, htpvnmozay, fqizrrnmif, glarko, hdemkfr, pwqvwmlgri, qggx, zskaqzwo, ijy, zlfiwwb]");
        Assert.assertEquals(q00692m.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2).toString(),
                "[i, love]");
        Assert.assertEquals(q00692m.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4).toString(),
                "[the, is, sunny, day]");

    }
}