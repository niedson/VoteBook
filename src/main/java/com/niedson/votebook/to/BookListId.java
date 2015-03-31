package com.niedson.votebook.to;

public class BookListId {
	private Long firstBookId;
	private Long secondBookId;
	
	public BookListId(Long firstBookId, Long secondBookId) {
		this.firstBookId = firstBookId;
		this.secondBookId = secondBookId;
	}

	public Long getFirstBookId() {
		return firstBookId;
	}

	public void setFirstBookId(Long firstBookId) {
		this.firstBookId = firstBookId;
	}

	public Long getSecondBookId() {
		return secondBookId;
	}

	public void setSecondBookId(Long secondBookId) {
		this.secondBookId = secondBookId;
	}
	
}
