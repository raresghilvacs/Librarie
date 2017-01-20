package com.example.raresghilvacs.librarie;


import android.text.Editable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HistoryBook {
    private String[] mFacts = {
            "1.the longest war in history was between the Netherlands and the Isles of Scilly.1651 to 1986 There were no casualties.",
            "2.The Anglo-Zanzibar war of 1896 is the shortest war. 38 min",
            "3.Albert Einstein was offered the role of Israel’s second President in 1952.",
            "4.John F. Kennedy, Anthony Burgess, Aldous Huxley, and C.S. Lewis all died on the same day.",
            "5.Napoleon was once attacked by rabbits.",
    };
    public String[] getFacts(){
        return mFacts;
    }
    public String getFact() {
        String fact = "";
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mFacts.length);
        fact = mFacts[randomNumber];
        return fact;
    }
    public int searchFact (String key){
        int i=0;
        for(String item : mFacts){
            i++;
            if  (key!=null){
                if(key.equals(item)) {
                   return i;
                }
            }
        }
        return -1;
    }
    public String getFactByIndex(int index){
        if (index<mFacts.length && index>=0){
            return mFacts[index];
        }
        return null;
    }

    public String[] editFact( int pos, String editMe) {
        List result = new LinkedList();
        /*String oldElement= */
        mFacts[pos]=editMe;
//        if (editMe!=null){
//            for(String item : mFacts){
//                if(oldElement.equals(item)) {
//                    item = editMe;
//                }
//                result.add(item);
//            }
//        }
//        mFacts = Arrays.copyOf(mFacts, mFacts.length);
//        return (String[]) result.toArray(mFacts);
        return mFacts;
    }

    public String[] removeElements( String deleteMe) {
        List result = new LinkedList();
        int number=0;
        for(String item : mFacts){
            if  (deleteMe!=null){
                if(!deleteMe.equals(item)) {
                    result.add(item);
                }
                else{
                    number++;
                }
            }
        }
        mFacts = Arrays.copyOf(mFacts, mFacts.length-number);
        return (String[]) result.toArray(mFacts);
    }
    public String[] addElement (String addMe) {
        List result = new LinkedList();
        for (String item : mFacts) {
            result.add(item);
        }
        result.add(addMe);
        mFacts = Arrays.copyOf(mFacts, mFacts.length +1);
        return (String[]) result.toArray(mFacts);
    }

    public String[] showAllFacts() {
       return mFacts;
    }

    public String showAllFactsLikeOneString() {
        String allFacts = "";
        for(String item : mFacts){
            if (item!=null){
                allFacts = allFacts +"  "+ item ;
            }
        }
        allFacts = allFacts +"  "+ mFacts.length ;
        return allFacts;
    }

}
