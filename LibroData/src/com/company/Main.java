package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<PublishingRetailer> publishingRetailerArrayList;
    static ArrayList<Book> bookArrayList;

    public static void main(String[] args) throws IOException {

        Initializations init = new Initializations();
        Administration administration = new Administration();

        File bookfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\books.in");
        bookArrayList = init.readBooksFromFile(bookfile);

        ArrayList<Language> languageArrayList;
        File languagefile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\languages.in");
        languageArrayList = init.readLanguagesFromFile(languagefile);

        ArrayList<Author> authorArrayList;
        File authorfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\authors.in");
        authorArrayList = init.readAuthorsFromFile(authorfile);

        ArrayList<Country> countryArrayList;
        File countryfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\countries.in");
        countryArrayList= init.readCountriesFromFile(countryfile);

        ArrayList<EditorialGroup> editorialGroupArrayList;
        File editorialgroupfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\editorial-groups.in");
        editorialGroupArrayList = init.readEditorialGroupFromFile(editorialgroupfile);

        ArrayList<PublishingBrand> publishingBrandArrayList;
        File pubbrandfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\publishing-brands.in");
        publishingBrandArrayList = init.readPublishingBrandFromFile(pubbrandfile);

        File pubretailfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\publishing-retailers.in");
        publishingRetailerArrayList = init.readPublishingRetailerFromFile(pubretailfile);

        init.readBookLanguage(bookArrayList,languageArrayList); // asociem fiecarei carti cate o limba in functie de languageID-ul citit din fisier

        /*   INITIALIZAREA ASOCIERILOR   */
        File bookauthorfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\books-authors.in");
        init.readBookAuthorFromFile(bookauthorfile, bookArrayList, authorArrayList);

        File editgroupbookfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\editorial-groups-books.in");
        init.readEditGroupBookFromFile(editgroupbookfile, editorialGroupArrayList, bookArrayList);

        File pubbrandbookfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\publishing-brands-books.in");
        init.readPubBrandBookFromFile(pubbrandbookfile, publishingBrandArrayList, bookArrayList);

        File pubretailcountryfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\publishing-retailers-countries.in");
        init.readPubRetailCountryFromFile(pubretailcountryfile, publishingRetailerArrayList, countryArrayList);

        File pubretailbookfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\publishing-retailers-books.in");
        init.readPubRetailBookFromFile(pubretailbookfile, publishingRetailerArrayList, bookArrayList);

        File pubretaileditgroupfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\publishing-retailers-editorial-groups.in");
        init.readPubRetailEditGroupFromFile(pubretaileditgroupfile, publishingRetailerArrayList, editorialGroupArrayList);

        File pubretailpubbrandfile = new File("E:\\ACS-CTI\\ACS-CTI ANUL 2 2021-2022\\SEM 1\\POO\\Teme\\Tema1\\init\\publishing-retailers-publishing-brands.in");
        init.readPubRetailPubBrandFromFile(pubretailpubbrandfile, publishingRetailerArrayList, publishingBrandArrayList);


        /*  TESTE   */
        //  1. Teste pentru getBooksForPublishingRetailerID(int publishingRetailerID)
        //  Test 1.a
        ArrayList<Book> bookArrayListRetaila = administration.getBooksForPublishingRetailerID(14);
        System.out.println("""

                1. Teste pentru getBooksForPublishingRetailerID(int publishingRetailerID)
                Test 1.a:\s""");
        System.out.println("Cartile din publishingReatiler-ul: " + publishingRetailerArrayList.get(13).name);
        for (Book book : bookArrayListRetaila) {
            System.out.println(book.name);
        }
        //  Test 1.b
        ArrayList<Book> bookArrayListRetailb = administration.getBooksForPublishingRetailerID(1);
        System.out.println("""

                Test 1.b:\s""");
        System.out.println("Cartile din publishingReatiler-ul: " + publishingRetailerArrayList.get(0).name);
        for (Book book : bookArrayListRetailb) {
            System.out.println(book.name);
        }
        //  Test 1.c
        ArrayList<Book> bookArrayListRetailc = administration.getBooksForPublishingRetailerID(9);
        System.out.println("""

                Test 1.c:\s""");
        System.out.println("Cartile din publishingReatiler-ul: " + publishingRetailerArrayList.get(8).name);
        for (Book book : bookArrayListRetailc) {
            System.out.println(book.name);
        }
        //  Test 1.d
        ArrayList<Book> bookArrayListRetaild = administration.getBooksForPublishingRetailerID(30);
        System.out.println("""

                Test 1.d:\s""");
        System.out.println("Cartile din publishingReatiler-ul: " + publishingRetailerArrayList.get(29).name);
        for (Book book : bookArrayListRetaild) {
            System.out.println(book.name);
        }
        //  Test 1.e
        ArrayList<Book> bookArrayListRetaile = administration.getBooksForPublishingRetailerID(16);
        System.out.println("""

                Test 1.d:\s""");
        System.out.println("Cartile din publishingReatiler-ul: " + publishingRetailerArrayList.get(15).name);
        for (Book book : bookArrayListRetaile) {
            System.out.println(book.name);
        }

        //  2. Teste pentru getLanguagesForPublishingRetailerID(int publishingReatilerID)
        //  Test 2.a
        ArrayList<Language> languageArrayListRetaila = administration.getLanguagesForPublishingRetailerID(7);
        System.out.println("""

                2. Teste pentru getLanguagesForPublishingRetailerID(int publishingReatilerID)
                Test 2.a:\s""");
        System.out.println("Limbile din publishingReatiler-ul: " + publishingRetailerArrayList.get(6).name);
        for (Language language : languageArrayListRetaila) {
            System.out.println(language.name);
        }
        //  Test 2.b
        ArrayList<Language> languageArrayListRetailb = administration.getLanguagesForPublishingRetailerID(13);
        System.out.println("""

                Test 2.b:\s""");
        System.out.println("Limbile din publishingReatiler-ul: " + publishingRetailerArrayList.get(12).name);
        for (Language language : languageArrayListRetailb) {
            System.out.println(language.name);
        }
        //  Test 2.c
        ArrayList<Language> languageArrayListRetailc = administration.getLanguagesForPublishingRetailerID(30);
        System.out.println("""

                Test 2.c:\s""");
        System.out.println("Limbile din publishingReatiler-ul: " + publishingRetailerArrayList.get(29).name);
        for (Language language : languageArrayListRetailc) {
            System.out.println(language.name);
        }
        //  Test 2.d
        ArrayList<Language> languageArrayListRetaild = administration.getLanguagesForPublishingRetailerID(1);
        System.out.println("""

                Test 2.d:\s""");
        System.out.println("Limbile din publishingReatiler-ul: " + publishingRetailerArrayList.get(0).name);
        for (Language language : languageArrayListRetaild) {
            System.out.println(language.name);
        }
        //  Test 2.e
        ArrayList<Language> languageArrayListRetaile = administration.getLanguagesForPublishingRetailerID(10);
        System.out.println("""

                Test 2.e:\s""");
        System.out.println("Limbile din publishingReatiler-ul: " + publishingRetailerArrayList.get(9).name);
        for (Language language : languageArrayListRetaile) {
            System.out.println(language.name);
        }

        //  3. Teste pentru getCountriesForBookID(int bookID)
        //  Test 3.a
        ArrayList<Country> countryArrayListBooka = administration.getCountriesForBookID(204);
        System.out.println("""

                3. Teste pentru getCountriesForBookID(int bookID)
                Test 3.a:\s""");
        System.out.println("Tarile unde este trimisa cartea Voyage au centre de la terre: ");
        for (Country country : countryArrayListBooka) {
            System.out.println(country.countryCode);
        }
        //  Test 3.b
        ArrayList<Country> countryArrayListBookb = administration.getCountriesForBookID(1181);
        System.out.println("""

                Test 3.b:\s""");
        System.out.println("Tarile unde este trimisa cartea Overconfident: ");
        for (Country country : countryArrayListBookb) {
            System.out.println(country.countryCode);
        }
        //  Test 3.c
        ArrayList<Country> countryArrayListBookc = administration.getCountriesForBookID(4131);
        System.out.println("""

                Test 3.c:\s""");
        System.out.println("Tarile unde este trimisa cartea Mes amis les Hindoust: ");
        for (Country country : countryArrayListBookc) {
            System.out.println(country.countryCode);
        }
        //  Test 3.d
        ArrayList<Country> countryArrayListBookd = administration.getCountriesForBookID(9110);
        System.out.println("""

                Test 3.d:\s""");
        System.out.println("Tarile unde este trimisa cartea À coups de fusil: ");
        for (Country country : countryArrayListBookd) {
            System.out.println(country.countryCode);
        }
        //  Test 3.e
        ArrayList<Country> countryArrayListBooke = administration.getCountriesForBookID(14958);
        System.out.println("""

                Test 3.e:\s""");
        System.out.println("Tarile unde este trimisa cartea Deux doigts dans la porte: ");
        for (Country country : countryArrayListBooke) {
            System.out.println(country.countryCode);
        }

        //  4. Teste pentru getCommonBooksForRetailerIDs(int retailerID1, int retailerID2)
        //  Test 4.a
        ArrayList<Book> commonBookArrayLista = administration.getCommonBooksForRetailerIDs(7,14);
        System.out.println("""

                4. Teste pentru getCommonBooksForRetailerIDs(int retailerID1, int retailerID2)
                Test 4.a:\s""");
        System.out.println("Cartile comune dintre: " + publishingRetailerArrayList.get(6).name + " si " + publishingRetailerArrayList.get(13).name);
        for (Book book : commonBookArrayLista) {
            System.out.println(book.name);
        }
        //  Test 4.b
        ArrayList<Book> commonBookArrayListb = administration.getCommonBooksForRetailerIDs(1,2);
        System.out.println("""

                Test 4.b:\s""");
        System.out.println("Cartile comune dintre: " + publishingRetailerArrayList.get(0).name + " si " + publishingRetailerArrayList.get(1).name);
        for (Book book : commonBookArrayListb) {
            System.out.println(book.name);
        }
        //  Test 4.c
        ArrayList<Book> commonBookArrayListc = administration.getCommonBooksForRetailerIDs(33,32);
        System.out.println("""

                Test 4.c:\s""");
        System.out.println("Cartile comune dintre: " + publishingRetailerArrayList.get(30).name + " si " + publishingRetailerArrayList.get(29).name);
        for (Book book : commonBookArrayListc) {
            System.out.println(book.name);
        }
        //  Test 4.d
        ArrayList<Book> commonBookArrayListd = administration.getCommonBooksForRetailerIDs(21,6);
        System.out.println("""

                Test 4.d:\s""");
        System.out.println("Cartile comune dintre: " + publishingRetailerArrayList.get(18).name + " si " + publishingRetailerArrayList.get(5).name);
        for (Book book : commonBookArrayListd) {
            System.out.println(book.name);
        }
        //  Test 4.e
        ArrayList<Book> commonBookArrayListe = administration.getCommonBooksForRetailerIDs(9,2);
        System.out.println("""

                Test 4.e:\s""");
        System.out.println("Cartile comune dintre: " + publishingRetailerArrayList.get(8).name + " si " + publishingRetailerArrayList.get(1).name);
        for (Book book : commonBookArrayListe) {
            System.out.println(book.name);
        }

        //  5. Teste pentru getAllBooksForRetailerIDs (int retailerID1, int retailerID2)
        //  Test 5.a
        ArrayList<Book> allBookArrayLista = administration.getAllBooksForRetailerIDs(22,32);
        System.out.println("""

                5. Teste pentru getAllBooksForRetailerIDs (int retailerID1, int retailerID2)
                Test 5.a:\s""");
        System.out.println("Toate cartile dintre: " + publishingRetailerArrayList.get(19).name + " si " + publishingRetailerArrayList.get(29).name);
        for (Book book : allBookArrayLista) {
            System.out.println(book.name);
        }
        //  Test 5.b
        ArrayList<Book> allBookArrayListb = administration.getAllBooksForRetailerIDs(1,2);
        System.out.println("""

                Test 5.b:\s""");
        System.out.println("Toate cartile dintre: " + publishingRetailerArrayList.get(0).name + " si " + publishingRetailerArrayList.get(1).name);
        for (Book book : allBookArrayListb) {
            System.out.println(book.name);
        }
        //  Test 5.c
        ArrayList<Book> allBookArrayListc = administration.getAllBooksForRetailerIDs(5,8);
        System.out.println("""

                Test 5.c:\s""");
        System.out.println("Toate cartile dintre: " + publishingRetailerArrayList.get(4).name + " si " + publishingRetailerArrayList.get(7).name);
        for (Book book : allBookArrayListc) {
            System.out.println(book.name);
        }
        //  Test 5.d
        ArrayList<Book> allBookArrayListd = administration.getAllBooksForRetailerIDs(20,33);
        System.out.println("""

                Test 5.d:\s""");
        System.out.println("Toate cartile dintre: " + publishingRetailerArrayList.get(17).name+ " si " + publishingRetailerArrayList.get(30).name);
        for (Book book : allBookArrayListd) {
            System.out.println(book.name);
        }
        //  Test 5.e
        ArrayList<Book> allBookArrayListe = administration.getAllBooksForRetailerIDs(7,14);
        System.out.println("""

                Test 5.e:\s""");
        System.out.println("Toate cartile dintre: " + publishingRetailerArrayList.get(6).name + " si " + publishingRetailerArrayList.get(14).name);
        for (Book book : allBookArrayListe) {
            System.out.println(book.name);
        }

        //  Teste pentru metoda Publish
        // Publish pentru o instanta Book
        System.out.println("\nPublish pentru o instanta Book: ");
        System.out.println(publishingRetailerArrayList.get(1).iPublishingArtifactArrayList.get(1).Publish());

        // Publish pentru o instanta EditorialGroup
        System.out.println("\nPublish pentru o instanta EditorialGroup: ");
        System.out.println(publishingRetailerArrayList.get(9).iPublishingArtifactArrayList.get(39).Publish());

        // Publish pentru o instanta PublishingBrand
        System.out.println("\nPublish pentru o instanta PublishingBrand: ");
        System.out.println(publishingRetailerArrayList.get(16).iPublishingArtifactArrayList.get(50).Publish());
    }

}
