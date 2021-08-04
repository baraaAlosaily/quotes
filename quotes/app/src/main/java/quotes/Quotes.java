package quotes;

public class Quotes {
    String quoteText;
    String quoteAuthor;

    public String getTextQuotes() {
        return quoteText;
    }

    public String getAutherQuotes() {
        return quoteAuthor;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "quoteText='" + quoteText + '\'' +
                ", quoteAuthor='" + quoteAuthor + '\'' +
                '}';
    }
}
