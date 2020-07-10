public class People {

    public String getPeopleName() {
        return peopleName;
    }

    public int getId() {
        return id;
    }

    public String getSchool() {
        return school;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    private String peopleName;
    private int id;
    private String school;

    public People(String peopleName, int id, String school) {
        this.peopleName=peopleName;
        this.id = id;
        this.school = school;
    }



}
