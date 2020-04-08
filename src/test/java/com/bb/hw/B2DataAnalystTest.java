package com.bb.hw;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.backblaze.b2.client.structures.B2FileVersion;

/**
 * @author : ayu
 * @date creation time：Mar 31, 2020 21:14:15 PM
 * @version 1.0
 */
public class B2DataAnalystTest {

    @Test
    public void testDownloadFileContent() throws Exception {
        List<String> fnames = new ArrayList<>();
        List<String> fcontents = new ArrayList<>();
        List<Integer> fcounts = new ArrayList<>();

        String f0Name = "zero.txt";
        String f0Content = "";
        int f0Count = 0;
        fnames.add(f0Name);
        fcontents.add(f0Content);
        fcounts.add(f0Count);

        String f1Name = "4.txt";
        String f1Content = "53457 nxb,x quwew9vbbn4 rwquqaaa90bmdel -``242))((%#$$axmfhwuyrtvqpsltdmh";
        int f1Count = 4;
        fnames.add(f1Name);
        fcontents.add(f1Content);
        fcounts.add(f1Count);

        String f2Name = "5.txt";
        String f2Content = "T4730573$@@v**aa kfsgh-e95698a gfgkmiuoiuyop dfa245890 m,b./xbnsa--===='';;..";
        int f2Count = 5;
        fnames.add(f2Name);
        fcontents.add(f2Content);
        fcounts.add(f2Count);

        String f3Name = "6.txt";
        String f3Content = "pjiyura riuwoeruaaafkflirt khoir22a885na ggjg9012nv";
        int f3Count = 6;
        fnames.add(f3Name);
        fcontents.add(f3Content);
        fcounts.add(f3Count);

        String f4Name = "8a.txt";
        String f4Content = "hjatodiymbe'topa kljgsd gsdoirjk slajsoistewpatwe a gdjskdgajs avnbcvp bmnkakfjlg";
        int f4Count = 8;
        fnames.add(f4Name);
        fcontents.add(f4Content);
        fcounts.add(f4Count);

        String f5Name = "8b.txt";
        String f5Content = ".....qwe skjdjfa gkjdlgjeaiuyey fhjfh yoeejeamkg afgjf;dly bmld;gkj<<<gkraot ahala";
        int f5Count = 8;
        fnames.add(f5Name);
        fcontents.add(f5Content);
        fcounts.add(f5Count);

        String f6Name = "all.txt";
        String f6Content = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int f6Count = 30;
        fnames.add(f6Name);
        fcontents.add(f6Content);
        fcounts.add(f6Count);

        StubB2StorageClient client = new StubB2StorageClient();
        StubB2ContentMemoryWriterDelegator sink = new StubB2ContentMemoryWriterDelegator();

        Queue<FileObject> queue = new PriorityQueue<>();

        /*
         * Create an array with numbers same as its indexes
         */
        Random random = new Random();
        int[] idexes = new int[fnames.size()];
        for (int i = 0; i < idexes.length; i++) {
            idexes[i] = i;
        }

        /*
         * Shuffle the array randomly
         */
        for (int i = 0; i < idexes.length; i++) {
            int randomPosition = random.nextInt(idexes.length);
            int j = idexes[i];
            idexes[i] = idexes[randomPosition];
            idexes[randomPosition] = j;
        }

        /*
         * Populate the data into priority queue without order
         */
        for (int i = 0; i < idexes.length; i++) {
            sink.setData(fcontents.get(idexes[i]));
            B2DataAnalyst.downloadFileContent(client,
                    new B2FileVersion("" + i, fnames.get(idexes[i]), 0L, null, null, null, null, 0L), sink, queue);
        }

        int i = 0;
        while (!queue.isEmpty()) {
            FileObject fo = queue.poll();
            assertEquals(fo.getCount(), fcounts.get(i).intValue());
            assertEquals(fo.getFileName(), fnames.get(i));
            i++;
        }
    }
}
