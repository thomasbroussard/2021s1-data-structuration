package fr.epita.data.xml.items;

public class ArticleItem {

	private String month;
	private String year;
	private String title;
	private String topic;


	public ArticleItem(String month, String year, String title, String topic) {
		this.month = month;
		this.year = year;
		this.title = title;
		this.topic = topic;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
}
