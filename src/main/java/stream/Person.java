package stream;

/**
 * Created by shraddha on 2/7/16.
 */
public class Person {
    private String fName;
    private Integer age;
    private SEX sex;

    public Person(String fName, Integer age, SEX sex) {
        this.fName = fName;
        this.age = age;
        this.sex = sex;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SEX getSex() {
        return sex;
    }

    public void setSex(SEX sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
