package luceneProject;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.miscellaneous.LengthFilter;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.en.EnglishMinimalStemFilter;
import org.apache.lucene.analysis.en.EnglishPossessiveFilter;
import org.apache.lucene.analysis.en.KStemFilter;
import org.apache.lucene.analysis.standard.ClassicTokenizer;

public class trialAnalyzer extends Analyzer{
	
	@Override
	protected TokenStreamComponents createComponents (String token) {
		ClassicTokenizer tokenizer = new ClassicTokenizer();
		TokenStream tokenStream = new LowerCaseFilter(tokenizer);
		tokenStream = new EnglishPossessiveFilter(tokenStream);
		tokenStream = new EnglishMinimalStemFilter(tokenStream);
		tokenStream = new KStemFilter(tokenStream);
		tokenStream = new PorterStemFilter(tokenStream);
		CharArraySet stopSet = CharArraySet.copy(EnglishAnalyzer.ENGLISH_STOP_WORDS_SET);
		tokenStream = new StopFilter(tokenStream,stopSet);
		return new TokenStreamComponents(tokenizer,tokenStream);
	}
			
}
