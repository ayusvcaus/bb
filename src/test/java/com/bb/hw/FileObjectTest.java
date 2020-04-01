package com.bb.hw;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** 
* @author : ayu
* @date creation time：Mar 9, 2020 1:29:33 PM 
* @version 1.0 
* @return  
*/
public class FileObjectTest {

	/*
	 * compareTo() decides the ordring of final output: considering count at first, then file name
	 */
	@Test
	public void testCompareTo() throws Exception {
		
		String f0Name="zero.txt";
		String f0Content="";
		int f0Count=0;
		
		String f1Name="VIII.txt";
		String f1Content="Excessive bail shall not be required, nor excessive fines imposed, nor cruel and unusual punishments inflicted.";
		int f1Count=4;
		
		String f2Name="X.txt";
		String f2Content="The powers not delegated to the United States by the Constitution, nor prohibited by it to the States, are reserved to the States respectively, or to the people.";
		int f2Count=5;	
		
		String f3Name="IX.txt";
		String f3Content="The enumeration in the Constitution, of certain rights, shall not be construed to deny or disparage others retained by the people.";
		int f3Count=6;
		
		String f4Name="II.txt";
		String f4Content="A well regulated Militia, being necessary to the security of a free State, the right of the people to keep and bear Arms, shall not be infringed.";
		int f4Count=8;
		
		String f5Name="III.txt";
		String f5Content="No Soldier shall, in time of peace be quartered in any house, without the consent of the Owner, nor in time of war, but in a manner to be prescribed by law.";
		int f5Count=8;
		
		String f6Name="all.txt";
		String f6Content="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		int f6Count=30;
		
		List<Integer> fcounts=new ArrayList<Integer>() {{
			add(f0Count);
			add(f1Count);
			add(f2Count);
			add(f3Count);
			add(f4Count);
			add(f5Count);
			add(f6Count);
		}};
		
		List<String> fnames=new ArrayList<String>() {{
			add(f0Name);
			add(f1Name);
			add(f2Name);
			add(f3Name);
			add(f4Name);
			add(f5Name);
			add(f6Name);
		}};
		
		Queue<FileObject> queue=new PriorityQueue<>();
		queue.offer(new FileObject(f6Name, f6Content, 'a'));
		queue.offer(new FileObject(f2Name, f2Content, 'a'));
		queue.offer(new FileObject(f5Name, f5Content, 'a'));
		queue.offer(new FileObject(f4Name, f4Content, 'a'));
		queue.offer(new FileObject(f1Name, f1Content, 'a'));
		queue.offer(new FileObject(f0Name, f0Content, 'a'));
		queue.offer(new FileObject(f3Name, f3Content, 'a'));
				
		int i=0;
        while (!queue.isEmpty()) {
        	FileObject fo=queue.poll();
        	assertEquals(fo.getCount(), fcounts.get(i).intValue());
        	assertEquals(fo.getFileName(), fnames.get(i));
        	i++;
        }
	}
}
