package bai_hoc.case_study_james;

public class Dictionary {
    private String work;
    private String mean;
    private String wordType;
    private String synonym;
    public Dictionary() {
    }

    public Dictionary(String work, String mean,String wordType,String synonym) {
        this.work = work;
        this.mean = mean;
        this.wordType=wordType;
        this.synonym=synonym;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "work='" + work + '\'' +
                ", mean='" + mean + '\'' +
                ", wordType='" + wordType + '\'' +
                ", synonym='" + synonym + '\'' +
                '}';
    }
}
