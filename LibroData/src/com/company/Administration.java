package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.company.Main.bookArrayList;
import static com.company.Main.publishingRetailerArrayList;

public class Administration {

    public ArrayList<Book> getBooksForPublishingRetailerID(int publishingRetailerID) {
        ArrayList<Book> bookArrayList= new ArrayList<Book>();

        for (PublishingRetailer publishingRetailer : publishingRetailerArrayList) {

            if (publishingRetailerID == publishingRetailer.ID) {

                for (int j = 0; j < publishingRetailer.iPublishingArtifactArrayList.size(); j++) {

                    if (publishingRetailer.iPublishingArtifactArrayList.get(j).getClass().getName().equals("com.company.Book")) {
                        Book book = (Book) publishingRetailer.iPublishingArtifactArrayList.get(j);
                        bookArrayList.add(book);
                    }

                    if (publishingRetailer.iPublishingArtifactArrayList.get(j).getClass().getName().equals("com.company.EditorialGroup")) {
                        EditorialGroup editorialGroup = (EditorialGroup) publishingRetailer.iPublishingArtifactArrayList.get(j);

                        bookArrayList.addAll(Arrays.asList(editorialGroup.books).subList(0, editorialGroup.size));
                    }

                    if (publishingRetailer.iPublishingArtifactArrayList.get(j).getClass().getName().equals("com.company.PublishingBrand")) {
                        PublishingBrand publishingBrand = (PublishingBrand) publishingRetailer.iPublishingArtifactArrayList.get(j);

                        bookArrayList.addAll(Arrays.asList(publishingBrand.books).subList(0, publishingBrand.size));
                    }
                }
            }
        }

        bookArrayList = (ArrayList<Book>) bookArrayList.stream().distinct().collect(Collectors.toList());

        return bookArrayList;
    }

    public ArrayList<Language> getLanguagesForPublishingRetailerID(int publishingReatilerID){
        ArrayList<Language> languageArrayList = new ArrayList<Language>();

        for(int i = 0; i < publishingRetailerArrayList.size(); i++) {

            if (publishingReatilerID == publishingRetailerArrayList.get(i).ID) {

                for (int j = 0; j < publishingRetailerArrayList.get(i).iPublishingArtifactArrayList.size(); j++) {

                    if (publishingRetailerArrayList.get(i).iPublishingArtifactArrayList.get(j).getClass().getName().equals("com.company.Book")) {
                        Book book = (Book) publishingRetailerArrayList.get(i).iPublishingArtifactArrayList.get(j);
                        languageArrayList.add(book.languageID);
                    }

                    if(publishingRetailerArrayList.get(i).iPublishingArtifactArrayList.get(j).getClass().getName().equals("com.company.EditorialGroup")){
                        EditorialGroup editorialGroup = (EditorialGroup) publishingRetailerArrayList.get(i).iPublishingArtifactArrayList.get(j);
                        for (int k = 0; k < editorialGroup.size; k++){
                            languageArrayList.add(editorialGroup.books[k].languageID);
                        }
                    }

                    if(publishingRetailerArrayList.get(i).iPublishingArtifactArrayList.get(j).getClass().getName().equals("com.company.PublishingBrand")){
                        PublishingBrand publishingBrand = (PublishingBrand) publishingRetailerArrayList.get(i).iPublishingArtifactArrayList.get(j);
                        for (int k = 0; k < publishingBrand.size; k++){
                            languageArrayList.add(publishingBrand.books[k].languageID);
                        }
                    }

                }
            }
        }

        languageArrayList = (ArrayList<Language>) languageArrayList.stream().distinct().collect(Collectors.toList());

        return languageArrayList;
    }

    public ArrayList<Country> getCountriesForBookID(int bookID){
        ArrayList<Country> countryArrayList = new ArrayList<Country>();

        File file = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\publishing-retailers-books.in");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                int pubretailid = Integer.parseInt(tokens[0]);
                int bookidfile = Integer.parseInt(tokens[1]);
                if(bookID == bookidfile){
                    for (PublishingRetailer publishingRetailer : publishingRetailerArrayList) {
                        if (publishingRetailer.ID == pubretailid) {
                            countryArrayList.addAll(Arrays.asList(publishingRetailer.countries).subList(0, publishingRetailer.size));
                            break;
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }

        return countryArrayList;
    }

    public ArrayList<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){

        ArrayList<Book> bookArrayList1 = getBooksForPublishingRetailerID(retailerID1);
        ArrayList<Book> bookArrayList2 = getBooksForPublishingRetailerID(retailerID2);

        ArrayList<Book> bookArrayList = new ArrayList<>();


        for (Book book1 : bookArrayList1) {
            for (Book book2 : bookArrayList2) {
                if (book1.ISBN.equals(book2.ISBN)) {
                    bookArrayList.add(book1);
                }
            }
        }
        bookArrayList = (ArrayList<Book>)  bookArrayList.stream().distinct().collect(Collectors.toList());

        return bookArrayList;
    }

    public ArrayList<Book> getAllBooksForRetailerIDs(int retailerID1, int retailerID2){

        ArrayList<Book> bookArrayList1 = getBooksForPublishingRetailerID(retailerID1);
        ArrayList<Book> bookArrayList2 = getBooksForPublishingRetailerID(retailerID2);

        ArrayList<Book> bookArrayList = new ArrayList<>(bookArrayList1);
        bookArrayList.addAll(bookArrayList2);

        bookArrayList = (ArrayList<Book>)  bookArrayList.stream().distinct().collect(Collectors.toList());

        return bookArrayList;
    }



}
