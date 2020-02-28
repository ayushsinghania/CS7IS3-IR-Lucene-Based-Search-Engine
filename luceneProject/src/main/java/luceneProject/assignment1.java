package luceneProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.search.similarities.LMDirichletSimilarity;

public class assignment1 {
	
	public static void main(String[] args) throws Exception {
		
		String Path11 = "src/StdAnalyzer_BM25.txt";
		String Path21 = "src/StdAnalyzer_Classic.txt";
		String Path31 = "src/StdAnalyzer_LMD.txt";
		String Path12 = "src/EngAnalyzer_BM25.txt";
		String Path22 = "src/EngAnalyzer_Classic.txt";
		String Path32 = "src/EngAnalyzer_LMD.txt";
		
		System.out.println("Starting Search Engine using Apache Lucene library\n");
		
		parser build_Index = new parser();

		parserQry search_Query = new parserQry();
		
		System.out.println("Building Index for the Cranfield Collection using StandardAnalyzer & BM25Similarity");
		build_Index.main(1,1);
		System.out.println("Build Successful\n");
		System.out.println("Testing & Evaluating our search engine using the queries provided");
		System.out.println("Please Wait.....\n");
		search_Query.main(1,1,Path11);
		System.out.println("Search Completed\n");
		
		System.out.println("Building Index for the Cranfield Collection using StandardAnalyzer & ClassicSimilarity");
		build_Index.main(2,1);
		System.out.println("Build Successful\n");
		System.out.println("Testing & Evaluating our search engine using the queries provided");
		System.out.println("Please Wait.....\n");
		search_Query.main(2,1,Path21);
		System.out.println("Search Completed\n");
		
		System.out.println("Building Index for the Cranfield Collection using StandardAnalyzer & BM25Similarity");
		build_Index.main(3,1);
		System.out.println("Build Successful\n");
		System.out.println("Testing & Evaluating our search engine using the queries provided");
		System.out.println("Please Wait.....\n");
		search_Query.main(3,1,Path31);
		System.out.println("Search Completed\n");
		
		System.out.println("Building Index for the Cranfield Collection using EnglishAnalyzer & BM25Similarity");
		build_Index.main(1,2);
		System.out.println("Build Successful\n");
		System.out.println("Testing & Evaluating our search engine using the queries provided");
		System.out.println("Please Wait.....\n");
		search_Query.main(1,2,Path12);
		System.out.println("Search Completed\n");
		
		System.out.println("Building Index for the Cranfield Collection using EnglishAnalyzer & ClassicSimilarity");
		build_Index.main(2,2);
		System.out.println("Build Successful\n");
		System.out.println("Testing & Evaluating our search engine using the queries provided");
		System.out.println("Please Wait.....\n");
		search_Query.main(2,2,Path22);
		System.out.println("Search Completed\n");
		
		System.out.println("Building Index for the Cranfield Collection using EnglishAnalyzer & LMDirichletSimilarity");
		build_Index.main(3,2);
		System.out.println("Build Successful\n");
		System.out.println("Testing & Evaluating our search engine using the queries provided");
		System.out.println("Please Wait.....\n");
		search_Query.main(3,2,Path32);
		System.out.println("Search Completed\n");
		
		System.out.println("Experimental query using trial Analyzer & BM25Similarity");
		build_Index.main(2,3);
		System.out.println("Build Successful\n");
		System.out.println("Testing & Evaluating our search engine using the queries provided");
		System.out.println("Please Wait.....\n");
		search_Query.main(3,2,Path32);
		System.out.println("Search Completed\n");
		
		System.out.println("All the results files have been created with relevant score and are present in src folder");
		System.out.println("The best result is achieved using EnglishAnalyzer with BM25Similarity ");
		System.out.println("The file is located at src/EngAnalyzer_BM25.txt");
		
		
	} 

}
