package luceneProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.search.IndexSearcher;

import org.apache.lucene.store.FSDirectory;


public class parserQry {
	
	public static void main(String[] args) throws Exception {
		String index_Path = "src/index";
		String result_Path = "result.txt";
		IndexReader index_Reader = DirectoryReader.open(FSDirectory.open(Paths.get(index_Path)));
		IndexSearcher index_Searcher = new IndexSearcher(index_Reader);
		index_Searcher.setSimilarity(new BM25Similarity());
		PrintWriter print_Writer = new PrintWriter(result_Path, "UTF-8");
	    try 
	    {
			File file = new File("src/cran/cran.qry");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Analyzer std_analyzer = new EnglishAnalyzer();
			MultiFieldQueryParser multi_parser = new MultiFieldQueryParser(new String[] {"title","authors","locations","content"}, std_analyzer);
			String line;
		    int count = 1;
		    boolean print = true;
			
			String id = "";
	        String content = "";
	        String flag = "";
	      
		      while ((line = bufferedReader.readLine()) != null) 
		      {
	             // String REGEX = "^.[A-Z] + \\d{1,2}$";
		    	  
		        switch (line.substring(0,2)) 
		        {
		         
		          case ".I":
		            if(!print){
		              Query query = multi_parser.parse(QueryParser.escape(content));
		              searchEngine(index_Searcher,print_Writer,count,query);
		              count++;
		              Document doc = new Document();
		              doc.add(new TextField("id",id,Field.Store.YES));
		              doc.add(new TextField("content",content,Field.Store.YES));
		              System.out.println(doc);
		              
		            }
		            else{
		              print = false;
		            }
		            id = Integer.toString(count);			   
				    content = "";
				    break;

		          case ".W":
		          flag = line;
	
		          default:
		          switch (flag) 
		          {         
		            case ".W":
		            	if(line == flag) 
		            	{
		            		break;
		            	}
		            	else 
		            	{
		            		content += line + "";
		            	}	
		              break;
		          }
		        }
		      }
		      //outside while 
		      Document doc = new Document();
		      doc.add(new TextField("id",id,Field.Store.YES));
              doc.add(new TextField("content",content,Field.Store.YES));
              System.out.println(doc);
              Query query = multi_parser.parse(QueryParser.escape(content));
              searchEngine(index_Searcher,print_Writer,count,query);
		      fileReader.close();
		      print_Writer.close();
		      index_Reader.close();
		    }
			catch(IOException e) 
    		{
				e.printStackTrace();
			}
		}
	
	public static void searchEngine(IndexSearcher index_Searcher, PrintWriter print_Writer, Integer count, Query query) throws IOException {
	    TopDocs results = index_Searcher.search(query, 1400);
	    ScoreDoc[] hits = results.scoreDocs;

	    // Write the results for each hit
	    for(int i=0;i<hits.length;i++){
	      Document doc = index_Searcher.doc(hits[i].doc);
	      print_Writer.println(count + " 0 " + doc.get("id") + " " + i + " " + hits[i].score + " STD");
	    }
	  }

}

