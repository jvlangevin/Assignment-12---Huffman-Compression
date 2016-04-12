package assignment12;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class CompressionDemoTest {
	
	@Test
	public void testAlpabetTestCaseSensative() throws IOException {

		compressFile("CompressionFiles/alphabetTestCaseSensative.txt", "CompressionFiles/compressedAlphabet.txt");
		decompressFile("CompressionFiles/compressedAlphabet.txt", "CompressionFiles/decompressedAlphabet.txt");

		String fileName1 = "CompressionFiles/alphabetTestCaseSensative.txt";
		String fileName2 = "CompressionFiles/decompressedAlphabet.txt";

		assertEquals(true, fileCompare(fileName1, fileName2));
	}

	@Test
	public void testCharTabSpaceTab() throws IOException {

		compressFile("CompressionFiles/charTabSpaceTab.txt", "CompressionFiles/compressedCharTab.txt");
		decompressFile("CompressionFiles/compressedCharTab.txt", "CompressionFiles/decompressedCharTab.txt");

		String fileName1 = "CompressionFiles/charTabSpaceTab.txt";
		String fileName2 = "CompressionFiles/decompressedCharTab.txt";

		assertEquals(true, fileCompare(fileName1, fileName2));
	}

	@Test
	public void testSixNewLines() throws IOException {

		compressFile("CompressionFiles/sixNewLines.txt", "CompressionFiles/compressedNewLines.txt");
		decompressFile("CompressionFiles/compressedNewLines.txt", "CompressionFiles/decompressedNewLines.txt");

		String fileName1 = "CompressionFiles/sixNewLines.txt";
		String fileName2 = "CompressionFiles/decompressedNewLines.txt";

		assertEquals(true, fileCompare(fileName1, fileName2));
	}
	
	@Test
	public void testLargeDoc() throws IOException {

		compressFile("CompressionFiles/largeDoc.txt", "CompressionFiles/compressedLargeDoc.txt");
		decompressFile("CompressionFiles/compressedLargeDoc.txt", "CompressionFiles/decompressedLargeDoc.txt");

		String fileName1 = "CompressionFiles/largeDoc.txt";
		String fileName2 = "CompressionFiles/decompressedLargeDoc.txt";

		assertEquals(true, fileCompare(fileName1, fileName2));
	}

	public static void compressFile(String infile, String outfile) {
		HuffmanTree t = new HuffmanTree();

		t.compressFile(new File(infile), new File(outfile));

		t.huffmanToDot("CompressionFiles/huffman_tree.dot");
	}

	public static void decompressFile(String infile, String outfile) {
		HuffmanTree t = new HuffmanTree();

		t.decompressFile(new File(infile), new File(outfile));
	}

	public static boolean fileCompare(String filename1, String filename2) throws IOException {

		File f1 = new File(filename1);
		FileReader fReader1 = new FileReader(f1);

		File f2 = new File(filename2);
		FileReader fReader2 = new FileReader(f2);

		while(fReader1.ready() && fReader2.ready()){
			if (fReader1.read() != fReader2.read())
				return false;
		}
		return true;
	}
	

}
