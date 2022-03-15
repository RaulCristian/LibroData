package com.company;

import java.util.Arrays;
import java.util.Calendar;

public class EditorialGroup implements IPublishingArtifact{
    Integer ID;
    String name;
    Book [] books = new Book[100];

    int size = 0;
    int sizebooks = 2;

    public EditorialGroup(Integer ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public EditorialGroup(){}

    public void addBooks(Book book){
        if(size >= sizebooks){
            books = Arrays.copyOf(books, sizebooks * 2);
        }
        books[size++] = book;
    }

    @Override
    public String Publish(){
        String metadata = "";

        metadata = metadata.concat("<xml>\n")
                .concat("    " + "<editorialGroup>\n")
                .concat("    " + "    " + "<ID>" + this.ID + "</ID\n")
                .concat("    " + "    " + "<Name>" + this.name + "</Name\n")
                .concat("    " + "</editorialGroup>\n")
                .concat("    " + "<books>\n");
        for (int i = 0; i < this.size; i++) {
            metadata = metadata.concat("        " + "<book>\n")
                    .concat("            " + "<title>" + this.books[i].name + "</title>\n")
                    .concat("            " + "<subtitle>" + this.books[i].subtitle + "</subtitle>\n")
                    .concat("            " + "<isbn>" + this.books[i].ISBN + "</isbn>\n")
                    .concat("            " + "<pageCount>" + this.books[i].pageCount + "</pageCount>\n")
                    .concat("            " + "<keywords>" + this.books[i].keywords + "</keywords>\n")
                    .concat("            " + "<languageID>" + this.books[i].languageID.ID + "</languageID>\n")
                    .concat("            " + "<createdOn>" + this.books[i].createdOn.getTime() + "</createdOn>\n")
                    .concat("            " + "<authors>" + this.books[i].authors[0].firstName + " " + this.books[i].authors[0].lastName + "</authors>\n")
                    .concat("        " + "</book>\n");
        }

        metadata = metadata.concat("    " + "</books>\n").concat("</xml>\n");
        return metadata;
    }
}
