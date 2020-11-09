package q00763s;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionLabels_AnsTest {

    PartitionLabels_Ans pl = new PartitionLabels_Ans();

    @Test
    public void partitionLabels() {
        Assert.assertEquals("[9, 7, 8]", pl.partitionLabels("ababcbacadefegdehijhklij").toString());
    }
}