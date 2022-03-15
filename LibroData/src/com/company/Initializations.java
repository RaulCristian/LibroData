package com.company;

import java.io.*;
import java.text.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Initializations {

    public ArrayList<Book> readBooksFromFile(File file) {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String [] tokens = line.split("###");
                Book book_new = new Book();
                book_new.ID = Integer.parseInt(tokens[0]);
                book_new.name = tokens[1];
                book_new.subtitle = tokens[2];
                book_new.ISBN = tokens[3];
                book_new.pageCount = Integer.parseInt(tokens[4]);
                book_new.keywords = tokens[5];
                book_new.languageID.ID = Integer.parseInt(tokens[6]);

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                calendar.setTime(simpleDateFormat.parse(tokens[7]));
                book_new.createdOn = calendar;

                bookArrayList.add(book_new);
            }
        }
        catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return bookArrayList;
    }

    public ArrayList<Language> readLanguagesFromFile(File file) throws IOException {
        ArrayList<Language> languageArrayList = new ArrayList<Language>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                Language language_new = new Language();
                language_new.ID = Integer.parseInt(tokens[0]);
                language_new.code = tokens[1];
                language_new.name = tokens[2];

                languageArrayList.add(language_new);
            }
        } catch (FileNotFoundException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }
        return languageArrayList;
    }

    public ArrayList<Author> readAuthorsFromFile(File file) {
        ArrayList<Author> authorArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                Author author_new = new Author();
                author_new.ID = Integer.parseInt(tokens[0]);
                author_new.firstName = tokens[1];
                author_new.lastName = tokens[2];

                authorArrayList.add(author_new);
            }

        } catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }

        return authorArrayList;
    }

    public ArrayList<Country> readCountriesFromFile(File file) {
        ArrayList<Country> countryArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                Country country_new = new Country();
                country_new.ID = Integer.parseInt(tokens[0]);
                country_new.countryCode = tokens[1];

                countryArrayList.add(country_new);
            }

        } catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }

        return countryArrayList;
    }

    public ArrayList<EditorialGroup> readEditorialGroupFromFile(File file){
        ArrayList<EditorialGroup> editorialGroupArrayList = new ArrayList<EditorialGroup>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                EditorialGroup editorialGroup_new = new EditorialGroup();
                editorialGroup_new.ID = Integer.parseInt(tokens[0]);
                editorialGroup_new.name = tokens[1];

                editorialGroupArrayList.add(editorialGroup_new);
            }
        } catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }

        return editorialGroupArrayList;
    }

    public ArrayList<PublishingBrand> readPublishingBrandFromFile(File file){
        ArrayList<PublishingBrand> publishingBrandArrayList = new ArrayList<PublishingBrand>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                PublishingBrand publishingBrand_new = new PublishingBrand();
                publishingBrand_new.ID = Integer.parseInt(tokens[0]);
                publishingBrand_new.name = tokens[1];

                publishingBrandArrayList.add(publishingBrand_new);
            }
        } catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }

        return publishingBrandArrayList;
    }

    public ArrayList<PublishingRetailer> readPublishingRetailerFromFile(File file){
        ArrayList<PublishingRetailer> publishingRetailerArrayList = new ArrayList<PublishingRetailer>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                PublishingRetailer publishingRetailer_new = new PublishingRetailer();
                publishingRetailer_new.ID = Integer.parseInt(tokens[0]);
                publishingRetailer_new.name = tokens[1];

                publishingRetailerArrayList.add(publishingRetailer_new);
            }
        } catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }

        return publishingRetailerArrayList;
    }


    public void readBookAuthorFromFile(File file, ArrayList<Book> readBook, ArrayList<Author> readAuthor) {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                int bookid = Integer.parseInt(tokens[0]);
                int authorid = Integer.parseInt(tokens[1]);

                for (Book book : readBook) {
                    if (bookid == book.ID) {
                        for (Author author : readAuthor) {
                            if (authorid == author.ID) {
                                book.addAuthors(author);
                                break;
                            }
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }
    }

    public void readEditGroupBookFromFile(File file, ArrayList<EditorialGroup> readEditorialGroup, ArrayList<Book> readBook){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                int editgroupid = Integer.parseInt(tokens[0]);
                int bookid = Integer.parseInt(tokens[1]);

                for (EditorialGroup editorialGroup : readEditorialGroup) {
                    if (editgroupid == editorialGroup.ID) {
                        for (Book book : readBook) {
                            if (bookid == book.ID) {
                                editorialGroup.addBooks(book);
                                break;
                            }
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }
    }

    public void readPubBrandBookFromFile(File file, ArrayList<PublishingBrand> readPubBrand, ArrayList<Book> readBook){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                int pubbrandid = Integer.parseInt(tokens[0]);
                int bookid = Integer.parseInt(tokens[1]);

                for (PublishingBrand publishingBrand : readPubBrand) {
                    if (pubbrandid == publishingBrand.ID) {
                        for (Book book : readBook) {
                            if (bookid == book.ID) {
                                publishingBrand.addBooks(book);
                                break;
                            }
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }
    }

    public void readPubRetailCountryFromFile(File file, ArrayList<PublishingRetailer> readPubRetail, ArrayList<Country> readCountry){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                int pubretailid = Integer.parseInt(tokens[0]);
                int countryid = Integer.parseInt(tokens[1]);

                for (PublishingRetailer publishingRetailer : readPubRetail) {
                    if (pubretailid == publishingRetailer.ID) {
                        for (Country country : readCountry) {
                            if (countryid == country.ID) {
                                publishingRetailer.addCountries(country);
                                break;
                            }
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }
    }

    public void readPubRetailBookFromFile(File file, ArrayList<PublishingRetailer> readPubRetail, ArrayList<Book> readBook){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                int pubretailid = Integer.parseInt(tokens[0]);
                int bookid = Integer.parseInt(tokens[1]);

                for (PublishingRetailer publishingRetailer : readPubRetail) {
                    if (pubretailid == publishingRetailer.ID) {
                        for (Book book : readBook) {
                            if (bookid == book.ID) {
                                publishingRetailer.addPubArtefact(book);
                                break;
                            }
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }
    }

    public void readPubRetailEditGroupFromFile(File file, ArrayList<PublishingRetailer> readPubRetail, ArrayList<EditorialGroup> readEditGroup){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                int pubretailid = Integer.parseInt(tokens[0]);
                int editgroupid = Integer.parseInt(tokens[1]);

                for (PublishingRetailer publishingRetailer : readPubRetail) {
                    if (pubretailid == publishingRetailer.ID) {
                        for (EditorialGroup editorialGroup : readEditGroup) {
                            if (editgroupid == editorialGroup.ID) {
                                publishingRetailer.addPubArtefact(editorialGroup);
                                break;
                            }
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }
    }

    public void readPubRetailPubBrandFromFile(File file, ArrayList<PublishingRetailer> readPubRetail, ArrayList<PublishingBrand> readPubBrand){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                int pubretailid = Integer.parseInt(tokens[0]);
                int pubbrandid = Integer.parseInt(tokens[1]);

                for (PublishingRetailer publishingRetailer : readPubRetail) {
                    if (pubretailid == publishingRetailer.ID) {
                        for (PublishingBrand publishingBrand : readPubBrand) {
                            if (pubbrandid == publishingBrand.ID) {
                                publishingRetailer.addPubArtefact(publishingBrand);
                                break;
                            }
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("N-a mers citirea din " + file.getName());
        }
    }


    public void readBookLanguage(ArrayList<Book> bookArrayList, ArrayList<Language> languageArrayList){
        for (Book book : bookArrayList) {
            int langid = book.languageID.ID;
            for (Language language : languageArrayList) {
                if (langid == language.ID) {
                    book.languageID = language;
                }
            }
        }
    }
}

