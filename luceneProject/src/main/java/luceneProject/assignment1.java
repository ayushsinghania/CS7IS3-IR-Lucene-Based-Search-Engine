package luceneProject;

public class assignment1 {
	
	public static void main(String[] args) throws Exception {
		parser build_Index = new parser();
		parserQry search_Query = new parserQry();
		
		build_Index.main(null);
		
		search_Query.main(null);
		
		
	} 

}
