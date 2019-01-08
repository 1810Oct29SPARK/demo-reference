package com.revature.beans;

public class Flashcard {
	
	public Flashcard(String question, String answer, FlashcardTopics topic, Author author) {
		super();
		this.question = question;
		this.answer = answer;
		this.topic = topic;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Flashcard [question=" + question + ", answer=" + answer + ", topic=" + topic + ", author=" + author
				+ "]";
	}
	public Flashcard() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String question;
	private String answer;
	private FlashcardTopics topic;
	private Author author;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public FlashcardTopics getTopic() {
		return topic;
	}
	public void setTopic(FlashcardTopics topic) {
		this.topic = topic;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
