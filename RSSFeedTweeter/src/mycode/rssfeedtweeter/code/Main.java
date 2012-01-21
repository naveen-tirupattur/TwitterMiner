/**
 * Main Class for RSSFeedTweeter
 */
package mycode.rssfeedtweeter.code;

/**
 * @author Naveen Tirupattur
 *
 */
public class Main {
	public static void main(String[] args) {
		RSSFeedReader parser = new RSSFeedReader(
				"http://www.javaworld.com/community/blogs/rss");
		RSSFeed feed = parser.readFeed();
		System.out.println(feed);
		for (RSSFeedMessage message : feed.getMessages()) {
			System.out.println(message);

		}

	}
}