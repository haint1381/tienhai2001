package bai_hoc.case_study_james;

public class Dictionary {
    private String work;
    private String mean;

    public Dictionary() {
    }

    public Dictionary(String work, String mean) {
        this.work = work;
        this.mean = mean;
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

    @Override
    public String toString() {
        return "Dictionary{" +
                "work='" + work + '\'' +
                ", mean='" + mean + '\'' +
                '}';
    }
}
