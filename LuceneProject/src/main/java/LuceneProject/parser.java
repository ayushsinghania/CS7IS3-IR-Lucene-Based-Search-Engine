package luceneProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


// "src/cran/cran.all.1400"

public class parser {
	
	public static String Index_Dir = "src/index";
	
	public static void main(String[] args) throws IOException {
	    try 
	    {	        
	    	Analyzer std_analyzer = new StandardAnalyzer();
	    	Directory dir = FSDirectory.open(Paths.get(Index_Dir));
	    	IndexWriterConfig config = new IndexWriterConfig(std_analyzer);
	    	config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
	    	config.setSimilarity(new ClassicSimilarity());
	    	
	    	IndexWriter index_Writer = new IndexWriter(dir, config);
	    	
//	    	List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
			File file = new File("src/cran/cran.all.1400");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			// Dictionary for storing parsed data
//			HashMap<String, String> cranDict = new HashMap<String, String>();
			
			String line;
//			String next = ".I";
		    int count = 1;
		    boolean print = true;
			
			String id = "";
			String title = "";
			String authors = "";
			String locations = "";
	        String content = "";
	        String flag = "";
	      
		      while ((line = bufferedReader.readLine()) != null) 
		      {
	             // String REGEX = "^.[A-Z] + \\d{1,2}$";
		    	  
		        switch (line.substring(0,2)) 
		        {
		        
		          case ".I":
		        	  
		            if(!print){
		              count++;
//		              cranDict.put("id", id);
//		              cranDict.put("title", title);
//		              cranDict.put("author", authors);
//		              cranDict.put("locations", locations);
//		              cranDict.put("content", content);
//		              
//		              dataList.add(cranDict);
//		              
//		              cranDict = new HashMap<String, String>();
		              Document doc = new Document();
		              doc.add(new TextField("id",id,Field.Store.YES));
		              doc.add(new TextField("title",title,Field.Store.YES));
		              doc.add(new TextField("authors",authors,Field.Store.YES));
		              doc.add(new TextField("locations",locations,Field.Store.YES));
		              doc.add(new TextField("content",content,Field.Store.YES));
		              index_Writer.addDocument(doc);
		              System.out.println(doc);
		              
		            }
		            else{
		              print = false;
		            }
		            id = Integer.toString(count);
				    title = "";
				    authors = "";
				    locations = "";
				    content = "";
				    break;
		          
		          case ".T":
		          case ".A":
		          case ".B":
		          case ".W":
		          flag = line;
	
		          default:
		          switch (flag) 
		          {
		            case ".T":
		            	if(line == flag) 
		            	{
		            		break;
		            	}
		            	else 
		            	{
		            		title += line + "";
		            	}	
		              break;
		            case ".A":
		            	if(line == flag) 
		            	{
		            		break;
		            	}
		            	else 
		            	{
		            		authors += line + "";
		            	}	
		              break;
		            case ".B":
		            	if(line == flag) 
		            	{
		            		break;
		            	}
		            	else 
		            	{
		            		locations += line + "";
		            	}	
		              break;
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
		      // outside loop
		      Document doc = new Document();
		      doc.add(new TextField("id",id,Field.Store.YES));
              doc.add(new TextField("title",title,Field.Store.YES));
              doc.add(new TextField("author",authors,Field.Store.YES));
              doc.add(new TextField("locations",locations,Field.Store.YES));
              doc.add(new TextField("content",content,Field.Store.YES));
              index_Writer.addDocument(doc);
              System.out.println(doc);
		      fileReader.close();
		      index_Writer.close();
		      dir.close();
		    }
				catch(IOException e) {
					e.printStackTrace();
				}
		}

}
