package bai_hoc.case_study_james;

import java.io.*;
import java.util.*;

public class Comons {
    public static String FILE_PATH = "D:\\Codegym\\src\\bai_hoc\\case_study_james\\dictionary.csv";
    public static String[] arrayTemp;
    public static List<Dictionary> dictionaryList = new LinkedList<>();
    public static Map<String,Dictionary> dictionaryMap=new TreeMap<>();

    public static void exportDictionaryDatabase() {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ( (line = bufferedReader.readLine()) != null ) {
                arrayTemp = line.split(",");
                dictionaryList.add(new Dictionary(arrayTemp[0], arrayTemp[1],arrayTemp[2],arrayTemp[3]));
                dictionaryMap.put(arrayTemp[0],new Dictionary(arrayTemp[0], arrayTemp[1],arrayTemp[2],arrayTemp[3]));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void additionalDictionary(String word, String mean,String wordType,String synonym) {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(word);
            bufferedWriter.append(",");
            bufferedWriter.append(mean);
            bufferedWriter.append(",");
            bufferedWriter.append(wordType);
            bufferedWriter.append(",");
            bufferedWriter.append(synonym);
            bufferedWriter.append("\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lookup(String word) {
        dictionaryMap.clear();
        Comons.exportDictionaryDatabase();
        for (String key: dictionaryMap.keySet()){
            if(key.equals(word)){
                System.out.println("word: "+dictionaryMap.get(key).getWork()+" mean: "+dictionaryMap.get(key).getMean()+" Word Type: "+dictionaryMap.get(key).getWordType()+" Synonym: "+dictionaryMap.get(key).getSynonym());
            }
        }
    }

    public static void delete(String word) {
        dictionaryList.clear();
        Comons.exportDictionaryDatabase();
        for (int i = 0; i < dictionaryList.size(); i++) {
            if (word.equals(dictionaryList.get(i).getWork())) {
                dictionaryList.remove(dictionaryList.get(i));
            }
        }
        Comons.save(dictionaryList.get(0).getWork(),dictionaryList.get(0).getMean(),dictionaryList.get(0).getWordType(),dictionaryList.get(0).getSynonym());
        for (int i = 1; i < dictionaryList.size(); i++) {
            Comons.additionalDictionary(dictionaryList.get(i).getWork(),dictionaryList.get(i).getMean(),dictionaryList.get(i).getWordType(),dictionaryList.get(i).getSynonym());
        }
    }

    public static void save(String word, String mean,String wordType,String synonym) {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(word);
            bufferedWriter.append(",");
            bufferedWriter.append(mean);
            bufferedWriter.append(",");
            bufferedWriter.append(wordType);
            bufferedWriter.append(",");
            bufferedWriter.append(synonym);
            bufferedWriter.append("\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
