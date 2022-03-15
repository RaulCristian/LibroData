package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class PublishingRetailer {
    Integer ID;
    String name;
    Country [] countries = new Country[100];
    ArrayList<IPublishingArtifact> iPublishingArtifactArrayList = new ArrayList<IPublishingArtifact>();


    int size = 0;
    int sizecountry = 2;

    public PublishingRetailer(Integer ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public PublishingRetailer(){}

    public void addCountries(Country country){
        if(size >= sizecountry){
            countries = Arrays.copyOf(countries, sizecountry * 2);
        }
        countries[size++] = country;
    }

    public void addPubArtefact(IPublishingArtifact iPublishingArtifact) {
        iPublishingArtifactArrayList.add(iPublishingArtifact);
    }

}
