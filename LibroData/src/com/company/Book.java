package com.company;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Book implements IPublishingArtifact {
    Integer ID;
    String name;
    String subtitle;
    String ISBN;
    Integer pageCount;
    String keywords;
    Language languageID = new Language();
    Calendar createdOn = new GregorianCalendar();
    Author [] authors = new Author[3];

    public Book(Integer ID, String name, String subtitle, String ISBN, Integer pageCount,
                String keywords, Language languageID, Calendar createdOn, Author [] authors){
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
        this.authors = authors;
    }

    public Book(){}

    int size = 0;
    int sizeauthor = 2;

    public void addAuthors(Author author){
        if(size >= sizeauthor){
            authors = Arrays.copyOf(authors, sizeauthor * 2);
        }
        authors[size++] = author;
    }

    @Override
    public String Publish() {

        String metadata = "";

        metadata = metadata.concat("<xml>\n").concat("    " + "<title>" + this.name + "</title>\n")
                    .concat("    " + "<subtitle>" + this.subtitle + "</subtitle>\n")
                    .concat("    " + "<isbn>" + this.ISBN + "</isbn>\n")
                    .concat("    " + "<pageCount>" + this.pageCount + "</pageCount>\n")
                    .concat("    " + "<keywords>" + this.keywords + "</keywords>\n")
                    .concat("    " + "<languageID>" + this.languageID.ID + "</languageID>\n")
                    .concat("    " + "<createdOn>" + this.createdOn.getTime() + "</createdOn>\n")
                    .concat("    " + "<authors>" + this.authors[0].firstName + " " + this.authors[0].lastName + "</authors>\n")
                    .concat("</xml>\n");

        return metadata;
    }
}
